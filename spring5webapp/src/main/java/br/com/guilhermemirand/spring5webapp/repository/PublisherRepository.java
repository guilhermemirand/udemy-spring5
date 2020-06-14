package br.com.guilhermemirand.spring5webapp.repository;

import br.com.guilhermemirand.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
