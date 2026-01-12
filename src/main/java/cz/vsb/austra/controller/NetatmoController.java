package cz.vsb.austra.controller;

import cz.vsb.austra.connector.netatmo.NetatmoConnector;
import cz.vsb.austra.dto.NetatmoStationDto;
import cz.vsb.austra.dto.netatmo.ApiResponse;
import cz.vsb.austra.service.NetatmoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NetatmoController {
    NetatmoConnector connector;
    NetatmoService service;

    @Autowired
    public NetatmoController(NetatmoConnector connector, NetatmoService service) {
        this.connector = connector;
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("netatmo/{lat_ne}/{lon_ne}/{lat_sw}/{lon_sw}/{zoom}")
//    @GetMapping("netatmo/test")
    public List<NetatmoStationDto> getStationsDataForSquare(@PathVariable("lat_ne") Double lat_ne,
                                                            @PathVariable("lon_ne") Double lon_ne,
                                                            @PathVariable("lat_sw") Double lat_sw,
                                                            @PathVariable("lon_sw") Double lon_sw,
                                                            @PathVariable("zoom") Integer zoom) {

        List<NetatmoStationDto> netatmoStationsData =  service.getNetatmoStationsDataForSquare(lat_ne, lon_ne, lat_sw, lon_sw, zoom);
        return netatmoStationsData;
    }
}
