package br.com.guilhermemirand.petclinic.repository;

import br.com.guilhermemirand.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
