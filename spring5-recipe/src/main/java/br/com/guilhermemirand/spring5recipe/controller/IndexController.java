package br.com.guilhermemirand.spring5recipe.controller;

import br.com.guilhermemirand.spring5recipe.domain.Category;
import br.com.guilhermemirand.spring5recipe.repository.CategoryRepository;
import br.com.guilhermemirand.spring5recipe.repository.UnitOfMensureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UnitOfMensureRepository unitOfMensureRepository;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndex() {
        Optional<Category> italian = this.categoryRepository.findByDescription("Italian");
        System.out.println("Categoria: " + italian.orElse(null));
        return "index";
    }
}
