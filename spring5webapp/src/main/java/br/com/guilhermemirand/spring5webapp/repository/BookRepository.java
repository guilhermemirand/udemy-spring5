package br.com.guilhermemirand.spring5webapp.repository;

import br.com.guilhermemirand.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
