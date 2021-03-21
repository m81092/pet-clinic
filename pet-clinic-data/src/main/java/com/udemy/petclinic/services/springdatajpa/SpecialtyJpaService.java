package com.udemy.petclinic.services.springdatajpa;

import com.udemy.petclinic.model.Speciality;
import com.udemy.petclinic.repositories.SpecialtyRepo;
import com.udemy.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService {
  
  private final SpecialtyRepo specialtyRepo;
  
  public SpecialtyJpaService(SpecialtyRepo specialtyRepo) {
    this.specialtyRepo = specialtyRepo;
  }
  
  @Override
  public Set<Speciality> findAll() {
    Set<Speciality> specialities = new HashSet<>();
    specialtyRepo.findAll().forEach(specialities::add);
    return specialities;
  }
  
  @Override
  public Speciality findById(Long aLong) {
    return specialtyRepo.findById(aLong).orElse(null);
  }
  
  @Override
  public Speciality save(Speciality object) {
    return specialtyRepo.save(object);
  }
  
  @Override
  public void delete(Speciality object) {
    specialtyRepo.delete(object);
  }
  
  @Override
  public void deleteById(Long aLong) {
    specialtyRepo.deleteById(aLong);
  }
}
