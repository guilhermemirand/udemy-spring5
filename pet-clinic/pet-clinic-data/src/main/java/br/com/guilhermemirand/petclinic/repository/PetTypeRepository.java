package br.com.guilhermemirand.petclinic.repository;

import br.com.guilhermemirand.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
