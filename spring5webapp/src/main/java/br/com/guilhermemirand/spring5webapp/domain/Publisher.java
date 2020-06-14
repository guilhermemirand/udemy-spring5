package br.com.guilhermemirand.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String andress;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books;

    public Publisher() {
    }

    public Publisher(String name, String andress) {
        this.name = name;
        this.andress = andress;
        this.books = new HashSet<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAndress() {
        return this.andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(this.id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                '}';
    }
}
