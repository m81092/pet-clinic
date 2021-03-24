package com.udemy.petclinic.services.map;

import com.udemy.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {
  
  OwnerMapService ownerMapService;
  
  @BeforeEach
  void setUp() {
    ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
    ownerMapService.save(Owner.builder().id(1L).lastName("Singh").build());
  }
  
  @Test
  void findAll() {
    Set<Owner> set = ownerMapService.findAll();
    assertEquals(1, set.size());
  }
  
  @Test
  void deleteById() {
    ownerMapService.deleteById(1L);
    assertEquals(0, ownerMapService.findAll().size());
  }
  
  @Test
  void delete() {
    ownerMapService.delete(ownerMapService.findById(1L));
    assertEquals(0, ownerMapService.findAll().size());
  }
  
  @Test
  void save() {
    Owner owner = Owner.builder().id(2L).build();
    ownerMapService.save(owner);
    assertEquals(2L, owner.getId());
  }
  
  @Test
  void saveNoId() {
    Owner owner = ownerMapService.save(Owner.builder().build());
    assertNotNull(owner);
    assertNotNull(owner.getId());
  }
  
  @Test
  void findById() {
    Owner owner = ownerMapService.findById(1L);
    assertEquals(1L, owner.getId());
  }
  
  @Test
  void findByLastName() {
    Owner owner = ownerMapService.findByLastName("Singh");
    assertNotNull(owner);
    assertEquals(1L, owner.getId());
    assertEquals("Singh", owner.getLastName());
  }
}