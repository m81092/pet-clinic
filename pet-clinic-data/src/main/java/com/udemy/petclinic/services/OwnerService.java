package com.udemy.petclinic.services;

import com.udemy.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String name);
}
