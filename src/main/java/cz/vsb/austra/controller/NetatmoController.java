package cz.vsb.austra.controller;

import cz.vsb.austra.connector.netatmo.NetatmoConnector;
import cz.vsb.austra.dto.NetatmoStationDto;
import cz.vsb.austra.dto.netatmo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetatmoController {
    NetatmoConnector connector;

    @Autowired
    public NetatmoController(NetatmoConnector connector) {
        this.connector = connector;
    }

    @CrossOrigin
//    @GetMapping("netatmo/{lat_ne},{lon_ne},{lat_sw},{lon_sw},{zoom}")
    @GetMapping("netatmo/test")
    public List<NetatmoStationDto> getStationsDataForSquare() {
        var response = connector.getData(49.89, 18.18, 49.85, 18.10, 14);
        return response;
    }
}
