package com.udemy.petclinic.bootstrap;

import com.udemy.petclinic.services.OwnerService;
import com.udemy.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  
  private final OwnerService ownerService;
  private final VetService vetService;
  
  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }
  
  @Override
  public void run(String... args) throws Exception {
  
  }
}
