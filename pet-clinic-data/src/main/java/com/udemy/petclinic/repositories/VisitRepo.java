package com.udemy.petclinic.repositories;

import com.udemy.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {
}
