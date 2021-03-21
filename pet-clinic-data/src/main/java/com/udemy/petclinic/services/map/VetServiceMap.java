package com.udemy.petclinic.services.map;

import com.udemy.petclinic.model.Speciality;
import com.udemy.petclinic.model.Vet;
import com.udemy.petclinic.services.SpecialtyService;
import com.udemy.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
  
  private final SpecialtyService specialtyService;
  
  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }
  
  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }
  
  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
  
  @Override
  public void delete(Vet object) {
    super.delete(object);
  }
  
  @Override
  public Vet save(Vet object) {
    if (object.getSpecialities().size() > 0) {
      object.getSpecialities().forEach(s -> {
        if (s.getId() == null) {
          Speciality savedSpecialty = specialtyService.save(s);
          s.setId(savedSpecialty.getId());
        }
      });
    }
    return super.save(object);
  }
  
  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
