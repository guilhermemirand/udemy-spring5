package br.com.guilhermemirand.petclinic.repository;

import br.com.guilhermemirand.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
