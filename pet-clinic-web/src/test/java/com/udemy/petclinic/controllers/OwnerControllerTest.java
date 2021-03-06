package com.udemy.petclinic.controllers;

import com.udemy.petclinic.model.Owner;
import com.udemy.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
  
  @Mock
  OwnerService service;
  @InjectMocks
  OwnerController controller;
  Set<Owner> owners;
  
  MockMvc mockMvc;
  
  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(Owner.builder().id(1L).lastName("M").build());
    owners.add(Owner.builder().id(2L).lastName("S").build());
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }
  
  @Test
  void listOwners() throws Exception {
    when(service.findAll()).thenReturn(owners);
    mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", hasSize(2)));
  }
}