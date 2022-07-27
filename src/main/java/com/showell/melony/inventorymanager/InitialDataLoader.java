package com.showell.melony.inventorymanager;

import com.showell.melony.inventorymanager.domain.camper.models.Camper;
import com.showell.melony.inventorymanager.domain.camper.models.CamperType;
import com.showell.melony.inventorymanager.domain.camper.service.CamperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private CamperService camperService;

    @Override
    public void run(String... args) throws Exception {
        Camper camper = new Camper("Melony", "Showell", "mjshowell@gmail.com", CamperType.GIRLSCOUT);
        camper = camperService.create(camper);
        log.info("Created a new camper {}",camper.toString());
    }

}

