package com.udemy.petclinic.services.springdatajpa;

import com.udemy.petclinic.model.PetType;
import com.udemy.petclinic.repositories.PetTypeRepo;
import com.udemy.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {
  
  private final PetTypeRepo petTypeRepo;
  
  public PetTypeJpaService(PetTypeRepo petTypeRepo) {
    this.petTypeRepo = petTypeRepo;
  }
  
  @Override
  public Set<PetType> findAll() {
    Set<PetType> petTypes = new HashSet<>();
    petTypeRepo.findAll().forEach(petTypes::add);
    return petTypes;
  }
  
  @Override
  public PetType findById(Long aLong) {
    return petTypeRepo.findById(aLong).orElse(null);
  }
  
  @Override
  public PetType save(PetType object) {
    return petTypeRepo.save(object);
  }
  
  @Override
  public void delete(PetType object) {
    petTypeRepo.delete(object);
  }
  
  @Override
  public void deleteById(Long aLong) {
    petTypeRepo.deleteById(aLong);
  }
}
