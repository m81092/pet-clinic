package com.udemy.petclinic.repositories;

import com.udemy.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {
}
