package com.udemy.petclinic.services.springdatajpa;

import com.udemy.petclinic.model.Owner;
import com.udemy.petclinic.repositories.OwnerRepo;
import com.udemy.petclinic.repositories.PetRepo;
import com.udemy.petclinic.repositories.PetTypeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
  
  @Mock
  OwnerRepo ownerRepo;
  @Mock
  PetRepo petRepo;
  @Mock
  PetTypeRepo petTypeRepo;
  @InjectMocks
  OwnerJpaService ownerJpaService;
  private final String LAST_NAME = "Singh";
  Owner returnOwner;
  
  @BeforeEach
  void setUp() {
    returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
  }
  
  @Test
  void findAll() {
    Set<Owner> set = new HashSet<>();
    Owner o = Owner.builder().id(1L).lastName(LAST_NAME).build();
    Owner o2 = Owner.builder().id(2L).lastName(LAST_NAME).build();
    set.add(o);
    set.add(o2);
    when(ownerRepo.findAll()).thenReturn(set);
    assertEquals(2, ownerJpaService.findAll().size());
    assertNotNull(set);
  }
  
  @Test
  void findById() {
    when(ownerRepo.findById(1L)).thenReturn(java.util.Optional.ofNullable(returnOwner));
    Owner res = ownerJpaService.findById(1L);
    assertEquals(1L, res.getId());
  }
  
  @Test
  void save() {
    Owner o = Owner.builder().id(1L).lastName(LAST_NAME).build();
    when(ownerRepo.save(any())).thenReturn(returnOwner);
    Owner returnOwner = ownerJpaService.save(o);
    assertEquals(1L, returnOwner.getId());
    assertEquals(LAST_NAME, returnOwner.getLastName());
    verify(ownerRepo).save(any());
  }
  
  @Test
  void delete() {
    ownerJpaService.delete(returnOwner);
    verify(ownerRepo).delete(any());
  }
  
  @Test
  void deleteById() {
    ownerJpaService.deleteById(1L);
    verify(ownerRepo).deleteById(any());
  }
  
  @Test
  void findByLastName() {
    Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    when(ownerRepo.findByLastName(any())).thenReturn(returnOwner);
    Owner owner = ownerJpaService.findByLastName(LAST_NAME);
    assertEquals(LAST_NAME, owner.getLastName());
  }
}