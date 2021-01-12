package com.satellite.starlink;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StarlinkApplication implements CommandLineRunner {
    @Autowired
    private SatelliteRepository satRepository;
    public static void main(String[] args) {
        SpringApplication.run(StarlinkApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        //MongoClient mongo = MongoClients.create(new ConnectionString("mongodb://mongo:27017"));
        Satellite s1 =new Satellite("St1",true,2,4,5,true);
        Satellite s2 =new Satellite("St2",true,3,4,10,true);
        Satellite s3 =new Satellite("St3",false,7,9,1,true);

        //drop satellites
        this.satRepository.deleteAll();

        //add satellites
        this.satRepository.save(s1);
        this.satRepository.save(s2);
        this.satRepository.save(s3);
    }
}
