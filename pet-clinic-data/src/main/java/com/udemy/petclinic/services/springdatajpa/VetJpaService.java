package com.udemy.petclinic.services.springdatajpa;

import com.udemy.petclinic.model.Vet;
import com.udemy.petclinic.repositories.VetRepo;
import com.udemy.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {
  
  private final VetRepo vetRepo;
  
  public VetJpaService(VetRepo vetRepo) {
    this.vetRepo = vetRepo;
  }
  
  @Override
  public Set<Vet> findAll() {
    Set<Vet> vets = new HashSet<>();
    vetRepo.findAll().forEach(vets::add);
    return vets;
  }
  
  @Override
  public Vet findById(Long aLong) {
    return vetRepo.findById(aLong).orElse(null);
  }
  
  @Override
  public Vet save(Vet object) {
    return vetRepo.save(object);
  }
  
  @Override
  public void delete(Vet object) {
    vetRepo.delete(object);
  }
  
  @Override
  public void deleteById(Long aLong) {
    vetRepo.deleteById(aLong);
  }
}
