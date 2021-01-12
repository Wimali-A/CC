package com.satellite.starlink;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatelliteRepository extends MongoRepository<Satellite,String> {

    public Satellite getSatelliteByName(String satname);

}
