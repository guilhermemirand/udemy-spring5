package br.com.guilhermemirand.spring5webapp.bootstrap;

import br.com.guilhermemirand.spring5webapp.domain.Author;
import br.com.guilhermemirand.spring5webapp.domain.Book;
import br.com.guilhermemirand.spring5webapp.domain.Publisher;
import br.com.guilhermemirand.spring5webapp.repository.AuthorRepository;
import br.com.guilhermemirand.spring5webapp.repository.BookRepository;
import br.com.guilhermemirand.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Publisher 01", "Brasil, RS");
        this.publisherRepository.save(publisher);
        Author machadoAssis = new Author("Machado de", "Assis");
        Author lauraCarvalho = new Author("Laura", "Carvalho");
        Book oAnalista = new Book("O Analista", "1234", publisher);
        Book memoriasPostumas = new Book("Memórias Póstumas de Brás Cubas", "1235", publisher);
        Book valsaBrasileira = new Book("Valsa Brasileira", "5678", publisher);

        oAnalista.getAuthors().add(machadoAssis);
        memoriasPostumas.getAuthors().add(machadoAssis);
        valsaBrasileira.getAuthors().add(lauraCarvalho);
        publisher.getBooks().add(oAnalista);
        publisher.getBooks().add(memoriasPostumas);
        publisher.getBooks().add(valsaBrasileira);

        this.authorRepository.save(machadoAssis);
        this.authorRepository.save(lauraCarvalho);
        this.bookRepository.save(oAnalista);
        this.bookRepository.save(memoriasPostumas);
        this.bookRepository.save(valsaBrasileira);
        this.publisherRepository.save(publisher);

        System.out.println("Autores: " + this.authorRepository.count());
        System.out.println("Livros: " + this.bookRepository.count());
        System.out.println("Editoras: " + this.publisherRepository.count());

    }
}
