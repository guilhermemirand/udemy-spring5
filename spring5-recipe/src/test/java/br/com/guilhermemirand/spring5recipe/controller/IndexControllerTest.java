package br.com.guilhermemirand.spring5recipe.controller;

import br.com.guilhermemirand.spring5recipe.service.RecipeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexControllerTest {

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    private IndexController indexController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.indexController = new IndexController(this.recipeService);
    }

    @Test
    public void indexTestLoads() {
        String retorno = this.indexController.getIndex(this.model);
        assertEquals("index", retorno);
    }

}
