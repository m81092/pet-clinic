package com.udemy.petclinic.services.springdatajpa;

import com.udemy.petclinic.model.Owner;
import com.udemy.petclinic.repositories.OwnerRepo;
import com.udemy.petclinic.repositories.PetRepo;
import com.udemy.petclinic.repositories.PetTypeRepo;
import com.udemy.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {
  
  private final OwnerRepo ownerRepo;
  private final PetRepo petRepo;
  private final PetTypeRepo petTypeRepo;
  
  public OwnerJpaService(OwnerRepo ownerRepo, PetRepo petRepo, PetTypeRepo petTypeRepo) {
    this.ownerRepo = ownerRepo;
    this.petRepo = petRepo;
    this.petTypeRepo = petTypeRepo;
  }
  
  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepo.findAll().forEach(owners::add);
    return owners;
  }
  
  @Override
  public Owner findById(Long aLong) {
    return ownerRepo.findById(aLong).orElse(null);
  }
  
  @Override
  public Owner save(Owner object) {
    return ownerRepo.save(object);
  }
  
  @Override
  public void delete(Owner object) {
    ownerRepo.delete(object);
  }
  
  @Override
  public void deleteById(Long aLong) {
    ownerRepo.deleteById(aLong);
  }
  
  @Override
  public Owner findByLastName(String name) {
    return ownerRepo.findByLastName(name);
  }
}
