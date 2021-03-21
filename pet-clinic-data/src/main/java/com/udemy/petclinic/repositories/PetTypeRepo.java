package com.udemy.petclinic.repositories;

import com.udemy.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
