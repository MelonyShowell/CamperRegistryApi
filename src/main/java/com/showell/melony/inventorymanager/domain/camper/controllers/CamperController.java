package com.showell.melony.inventorymanager.domain.camper.controllers;

import com.showell.melony.inventorymanager.domain.camper.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/campers")
public class CamperController {
    private CamperService camperService;

    @Autowired
    public CamperController(CamperService camperService) {
        this.camperService = camperService;
    }
}
