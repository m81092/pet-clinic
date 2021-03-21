package com.udemy.petclinic.services.springdatajpa;

import com.udemy.petclinic.model.Visit;
import com.udemy.petclinic.repositories.VisitRepo;
import com.udemy.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {
  
  private final VisitRepo visitRepo;
  
  public VisitJpaService(VisitRepo visitRepo) {
    this.visitRepo = visitRepo;
  }
  
  @Override
  public Set<Visit> findAll() {
    Set<Visit> visits = new HashSet<>();
    visitRepo.findAll().forEach(visits::add);
    return visits;
  }
  
  @Override
  public Visit findById(Long aLong) {
    return visitRepo.findById(aLong).orElse(null);
  }
  
  @Override
  public Visit save(Visit object) {
    return visitRepo.save(object);
  }
  
  @Override
  public void delete(Visit object) {
    visitRepo.delete(object);
  }
  
  @Override
  public void deleteById(Long aLong) {
    visitRepo.deleteById(aLong);
  }
}
