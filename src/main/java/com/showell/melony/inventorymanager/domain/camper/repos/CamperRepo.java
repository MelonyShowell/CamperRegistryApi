package com.showell.melony.inventorymanager.domain.camper.repos;

import com.showell.melony.inventorymanager.domain.camper.models.Camper;
import com.showell.melony.inventorymanager.domain.camper.models.CamperType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CamperRepo extends CrudRepository<Camper, Long> {
    Optional<Camper> findByEmail(String email);
    List<Camper> findByLastName(String lastName);
    List<Camper> findByCamperType(CamperType camperType);
}
