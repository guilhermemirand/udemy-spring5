package br.com.guilhermemirand.spring5recipe.controller;

import br.com.guilhermemirand.spring5recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("recipe", this.recipeService.findById(id));
        return "recipe/detail";
    }

}
