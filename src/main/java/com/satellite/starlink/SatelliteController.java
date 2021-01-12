package com.satellite.starlink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class SatelliteController {

    private final static Logger logger= LoggerFactory.getLogger(SatelliteController.class);
    @Autowired
    SatelliteService service;

    @GetMapping("/all")
    public List<Satellite> getAllData(){

        List<Satellite> sats=service.getAll();

        return sats;
    }

   @PostMapping("/addsatellite")
    public Satellite addSatelliteData(@RequestBody Satellite satellite){

       return service.addSatellite(satellite);
    }

    @GetMapping("/checkhealth/{satname}")
    public String checkHealthData(@PathVariable("satname") String satname){
        return  service.checkHealth(satname);
    }

    @GetMapping("/orbit/{satname}")
    public String getOrbitData(@PathVariable("satname") String satname){
        return service.getOrbit(satname);
    }

    @PutMapping("/disconnect/{satname}")
    public String disconnectSatelliteData(@PathVariable("satname") String satname){
        return service.disconnectSatellite(satname);
    }

    @PutMapping("/connect/{satname}")
    public String connectSatelliteData(@PathVariable("satname") String satname){
        return service.connectSatellite(satname);
    }

    @PutMapping("/changeorbit/{satname}")
    public Satellite changeOrbitData(@RequestBody Satellite satellite,@PathVariable("satname") String satname){
        return service.changeOrbit(satellite,satname);
    }
}


