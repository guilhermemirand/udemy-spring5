package br.com.guilhermemirand.spring5webapp.repository;

import br.com.guilhermemirand.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
