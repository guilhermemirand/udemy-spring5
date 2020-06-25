package br.com.guilhermemirand.petclinic.repository;

import br.com.guilhermemirand.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
