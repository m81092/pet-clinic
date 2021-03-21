package com.udemy.petclinic.repositories;

import com.udemy.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet, Long> {
}
