package br.com.guilhermemirand.petclinic.services;

import br.com.guilhermemirand.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
