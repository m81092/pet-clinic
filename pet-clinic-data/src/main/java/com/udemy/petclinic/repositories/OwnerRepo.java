package com.udemy.petclinic.repositories;

import com.udemy.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
  
  Owner findByLastName(String lastName);
  
}
