package br.com.guilhermemirand.petclinic.repository;

import br.com.guilhermemirand.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
