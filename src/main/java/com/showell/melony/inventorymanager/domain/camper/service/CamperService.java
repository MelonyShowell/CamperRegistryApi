package com.showell.melony.inventorymanager.domain.camper.service;

import com.showell.melony.inventorymanager.domain.camper.models.Camper;
import com.showell.melony.inventorymanager.domain.camper.models.CamperType;
import com.showell.melony.inventorymanager.domain.core.ResourceCreationException;
import com.showell.melony.inventorymanager.domain.core.ResourceNotFoundException;

import java.util.List;


public interface CamperService {
    Camper create (Camper camper) throws ResourceCreationException;
    List<Camper> getAll();
    List<Camper> getByLastName(String lastName) throws ResourceNotFoundException;
    Camper getByEmail(String email) throws ResourceCreationException;
    List<Camper> getByCamperType(CamperType camperType) throws ResourceNotFoundException;
    Camper getById(Long id) throws ResourceNotFoundException;
    Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
