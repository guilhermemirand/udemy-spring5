package br.com.guilhermemirand.petclinic.repository;

import br.com.guilhermemirand.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
