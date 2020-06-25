package br.com.guilhermemirand.spring5recipe.controller;

import br.com.guilhermemirand.spring5recipe.domain.Category;
import br.com.guilhermemirand.spring5recipe.repository.CategoryRepository;
import br.com.guilhermemirand.spring5recipe.repository.UnitOfMensureRepository;
import br.com.guilhermemirand.spring5recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", this.recipeService.findAll());
        return "index";
    }
}
