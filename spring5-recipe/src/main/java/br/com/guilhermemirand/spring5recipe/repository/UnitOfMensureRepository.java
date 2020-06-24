package br.com.guilhermemirand.spring5recipe.repository;

import br.com.guilhermemirand.spring5recipe.domain.UnitOfMensure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMensureRepository extends CrudRepository<UnitOfMensure, Long> {

    Optional<UnitOfMensure> findByDescription(String description);
}
