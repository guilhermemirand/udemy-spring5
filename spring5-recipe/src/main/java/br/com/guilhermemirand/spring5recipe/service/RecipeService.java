package br.com.guilhermemirand.spring5recipe.service;

import br.com.guilhermemirand.spring5recipe.domain.Recipe;
import br.com.guilhermemirand.spring5recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        this.recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
