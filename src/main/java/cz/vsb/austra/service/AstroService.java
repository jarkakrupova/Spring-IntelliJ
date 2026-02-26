package cz.vsb.austra.service;

import cz.vsb.austra.dto.*;
import cz.vsb.austra.dto.weatherapi.AstroApiDto;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AstroService {
    //    SunriseSunsetConnector connector;
//    LocationConnector locationConnector;
//    AstroConnector astroConnector;
//
//    @Autowired
//    public AstroService(SunriseSunsetConnector connector, LocationConnector locationConnector, AstroConnector astroConnector) {
//        this.connector = connector;
//        this.locationConnector = locationConnector;
//        this.astroConnector = astroConnector;
//    }
//
//    public SunMoonAstroDto getSunMoonAstroDataForTheCity(String city) {
//        SearchLocation cityLocation = locationConnector.getLocationForCity(city)[0];
//        double lat = cityLocation.getLat();
//        double lng = cityLocation.getLon();
//        SunriseSunsetApiDto sunriseSunsetApiDto = connector.getSunriseSunsetDataForCity(lat, lng);
//        AstroApiDto astroApiDto = astroConnector.getAstroForCity(city);
//        return transformDto(sunriseSunsetApiDto, astroApiDto);
//    }
    private final WebClient sunriseSunsetWebClient;
    private final WebClient locationWebClient;
    private final WebClient astroWebClient;

    public AstroService(@Qualifier("sunriseSunsetWebClient") WebClient sunriseSunsetWebClient,
                        @Qualifier("weatherApiLocationWebClient") WebClient locationWebClient,
                        @Qualifier("weatherApiAstroWebClient") WebClient astroWebClient) {
        this.sunriseSunsetWebClient = sunriseSunsetWebClient;
        this.locationWebClient = locationWebClient;
        this.astroWebClient = astroWebClient;
    }

    public Mono<SunMoonAstroDto> getSunMoonAstroDataForCity(String city) {
        Mono<AstroApiDto> astroMono = astroWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", city)
                        .build()).retrieve().bodyToMono(AstroApiDto.class);
        Mono<SearchLocation> firstLocationMono = getSearchLocationMono(city);

        Mono<SunriseSunsetApiDto> sunriseSunsetMono = getSunriseSunsetMono(firstLocationMono);
        return Mono.zip(astroMono, sunriseSunsetMono)
                .map(tuple -> {
                    AstroApiDto astroData = tuple.getT1();
                    SunriseSunsetApiDto sunriseSunsetData = tuple.getT2();
                    return transformDto(sunriseSunsetData, astroData);
                });
    }

    private @NonNull Mono<SunriseSunsetApiDto> getSunriseSunsetMono(Mono<SearchLocation> firstLocationMono) {
        Mono<SunriseSunsetApiDto> sunriseSunsetMono = firstLocationMono
                .flatMap(firstLocation -> {
                    return sunriseSunsetWebClient.get()
                            .uri(uriBuilder -> uriBuilder
                                    .queryParam("lat", firstLocation.getLat())
                                    .queryParam("lng", firstLocation.getLon())
                                    .build())
                            .retrieve()
                            .bodyToMono(SunriseSunsetApiDto.class);
                });
        return sunriseSunsetMono;
    }

    private @NonNull Mono<SearchLocation> getSearchLocationMono(String city) {
        Mono<SearchLocation[]> locationMono = locationWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", city)
                        .build())
                .retrieve().bodyToMono(SearchLocation[].class);
        Mono<SearchLocation> firstLocationMono = locationMono
                .map(locations -> {
                    if (locations == null || locations.length == 0) {
                        throw new RuntimeException("No locations found");
                    }
                    return locations[0];
                });
        return firstLocationMono;
    }


    private SunMoonAstroDto transformDto(SunriseSunsetApiDto sunriseSunsetApiDto, AstroApiDto astroApiDto) {
        SunMoonAstroDto sunMoonDto = new SunMoonAstroDto();
        sunMoonDto.setMoon_phase(astroApiDto.getAstronomy().getAstro().getMoon_phase());
        sunMoonDto.setMoonrise(astroApiDto.getAstronomy().getAstro().getMoonrise());
        sunMoonDto.setMoonset(astroApiDto.getAstronomy().getAstro().getMoonset());
        sunMoonDto.setSunrise(astroApiDto.getAstronomy().getAstro().getSunrise());
        sunMoonDto.setSunset(astroApiDto.getAstronomy().getAstro().getSunset());
        sunMoonDto.setDawn(sunriseSunsetApiDto.getResults().getDawn());
        sunMoonDto.setDusk(sunriseSunsetApiDto.getResults().getDusk());
        sunMoonDto.setDayLength(sunriseSunsetApiDto.getResults().getDay_length());
        sunMoonDto.setFirst_light(sunriseSunsetApiDto.getResults().getFirst_light());
        sunMoonDto.setLast_light(sunriseSunsetApiDto.getResults().getLast_light());
        sunMoonDto.setGoldenHour(sunriseSunsetApiDto.getResults().getGolden_hour());
        sunMoonDto.setTimezone(sunriseSunsetApiDto.getResults().getTimezone());
        return sunMoonDto;
    }

    public Mono<SunMoonAstroDto> getSunMoonAstroDataForTheLatLon(Double lat, Double lon) {
        //SunriseSunsetApiDto sunriseSunsetApiDto = connector.getSunriseSunsetDataForCity(lat, lon);
        Mono<SunriseSunsetApiDto> sunriseSunsetMono = sunriseSunsetWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .build())
                .retrieve()
                .bodyToMono(SunriseSunsetApiDto.class);
        Mono<AstroApiDto> astroMono = astroWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", lat.toString()+","+lon.toString())
                        .build()).retrieve().bodyToMono(AstroApiDto.class);

       // AstroApiDto astroApiDto = astroConnector.getAstroForLatLon(lat, lon);
        return Mono.zip(astroMono, sunriseSunsetMono)
                .map(tuple -> {
                    AstroApiDto astroData = tuple.getT1();
                    SunriseSunsetApiDto sunriseSunsetData = tuple.getT2();
                    return transformDto(sunriseSunsetData, astroData);
                });
       // return transformDto(sunriseSunsetApiDto, astroApiDto);
    }
}
