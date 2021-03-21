package com.udemy.petclinic.repositories;

import com.udemy.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepo extends CrudRepository<Speciality, Long> {
}
