package br.com.guilhermemirand.spring5webapp.controller;

import br.com.guilhermemirand.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", this.bookRepository.findAll());
        return "books/list";
    }
}
