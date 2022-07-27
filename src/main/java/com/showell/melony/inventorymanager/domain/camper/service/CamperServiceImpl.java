package com.showell.melony.inventorymanager.domain.camper.service;

import com.showell.melony.inventorymanager.domain.camper.models.Camper;
import com.showell.melony.inventorymanager.domain.camper.models.CamperType;
import com.showell.melony.inventorymanager.domain.camper.repos.CamperRepo;
import com.showell.melony.inventorymanager.domain.core.ResourceCreationException;
import com.showell.melony.inventorymanager.domain.core.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamperServiceImpl implements CamperService{
    private CamperRepo camperRepo;

    public CamperServiceImpl(CamperRepo camperRepo) {
        this.camperRepo = camperRepo;
    }

    @Override
    public Camper create(Camper camper) throws ResourceCreationException {
        Optional<Camper> optional = camperRepo.findByEmail(camper.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Camper by Email exist." + camper.getEmail());
        camper = camperRepo.save(camper);
        return camper;
    }

    @Override
    public List<Camper> getAll() {
        return (List<Camper>)camperRepo.findAll(); //cast Optional to List
    }

    @Override
    public List<Camper> getByLastName(String lastName) throws ResourceNotFoundException {;
        return (List<Camper>)camperRepo.findByLastName(lastName);
    }

    @Override
    public Camper getByEmail(String email) throws ResourceNotFoundException {
        Camper camper = camperRepo.findByEmail(email)
        .orElseThrow(()->new ResourceNotFoundException("No Camper with this email." + email));
        return camper;
    }

    @Override
    public List<Camper> getByCamperType(CamperType camperType) throws ResourceNotFoundException{
        return camperRepo.findByCamperType(camperType);
    }

    @Override
    public Camper getById(Long id) throws ResourceNotFoundException {
        Camper camper = camperRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Camper with this id" +id));
        return camper;
    }

    @Override
    public Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException {
        Camper camper = getById(id);
        camper.setFirstName(camperDetail.getFirstName());
        camper.setLastName(camperDetail.getLastName());
        camper.setEmail(camperDetail.getEmail());
        camper.setCamperType(camperDetail.getCamperType());
        camper = camperRepo.save(camper);
        return camper;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Camper camper = getById(id);
        camperRepo.delete(camper);

    }
}
