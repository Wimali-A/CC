package com.satellite.starlink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteService {

    @Autowired
    SatelliteRepository repo;

    public List<Satellite> getAll() {
        List<Satellite> sats=repo.findAll();
        return sats;
    }

    public Satellite addSatellite(Satellite satellite) {
        return repo.insert(satellite);
    }


    public String checkHealth(String satname) {
        String status ="Error";
        if(repo.getSatelliteByName(satname).isHealth()){
            status="Healthy";
        }else{
            status ="Error";
        }
        return status;
    }

    public String getOrbit(String satname) {

        Satellite st=repo.getSatelliteByName(satname);
        String location= "Location : ("+st.getXaxis() +","+st.getYaxis()+","+st.getZaxis()+")";
        return location;
    }

    public String disconnectSatellite(String satname) {
        Satellite st=repo.getSatelliteByName(satname);
        if(st.isConnected()){
            st.setConnected(false);
            return satname+" is disconnected";
        }else{
            return satname+" is already disconnected";
        }
    }

    public String connectSatellite(String satname) {
        Satellite st=repo.getSatelliteByName(satname);
        if(!st.isConnected()){
            st.setConnected(true);
            return satname+" is connected";
        }else{
            return satname+" is already connected";
        }
    }

    public Satellite changeOrbit(Satellite satellite, String satname) {
        Satellite st=repo.getSatelliteByName(satname);
        st.setXaxis(satellite.getXaxis());
        st.setYaxis(satellite.getYaxis());
        st.setZaxis(satellite.getZaxis());
        return st;
    }
}
