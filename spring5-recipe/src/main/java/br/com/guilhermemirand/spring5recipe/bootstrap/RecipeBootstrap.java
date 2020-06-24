package br.com.guilhermemirand.spring5recipe.bootstrap;

import br.com.guilhermemirand.spring5recipe.domain.*;
import br.com.guilhermemirand.spring5recipe.repository.CategoryRepository;
import br.com.guilhermemirand.spring5recipe.repository.IngredientRepository;
import br.com.guilhermemirand.spring5recipe.repository.RecipeRepository;
import br.com.guilhermemirand.spring5recipe.repository.UnitOfMensureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class RecipeBootstrap implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitOfMensureRepository unitOfMensureRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void run(String... args) throws Exception {
        this.loadOmelettes();
    }

    private void loadOmelettes() {
        Ingredient eggs = new Ingredient();
        eggs.setDescription("Eggs");
        eggs.setUnitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null));
        eggs.setAmount(BigDecimal.valueOf(3l));

        Ingredient butter = new Ingredient();
        butter.setDescription("Butter");
        butter.setUnitOfMensure(this.unitOfMensureRepository.findByDescription("Tablespoon").orElse(null));
        butter.setAmount(BigDecimal.valueOf(1l));

        Recipe omelettes = new Recipe();
        omelettes.setDescription("Omelette");
        omelettes.setCategories(new HashSet<>());
        omelettes.getCategories().add(this.categoryRepository.findByDescription("French").orElse(null));
        omelettes.setCookTime(5);
        omelettes.setDifficulty(Difficulty.EASY);
        omelettes.setServings(2);
        omelettes.setPrepTime(1);
        omelettes.setUrl("https://www.simplyrecipes.com/recipes/how_to_make_an_omelet/");
        omelettes.setIngredients(new HashSet<>());
        omelettes.getIngredients().add(eggs);
        omelettes.getIngredients().add(butter);
        eggs.setRecipe(omelettes);
        butter.setRecipe(omelettes);
        omelettes.setDirections("1. Beat the eggs: Use two or three eggs per omelette, depending on how hungry you are. Beat the eggs lightly with a fork.\n" +
                "2. Melt the butter: Use an 8-inch nonstick skillet for a 2-egg omelette, a 9-inch skillet for 3 eggs. Melt the butter over medium-low heat, and keep the temperature low and slow when cooking the eggs so the bottom doesn’t get too brown or overcooked.\n" +
                "3. Add the eggs: Let the eggs sit for a minute, then use a heatproof silicone spatula to gently lift the cooked eggs from the edges of the pan. Tilt the pan to allow the uncooked eggs to flow to the edge of the pan.\n" +
                "4. Fill the omelette: Add the filling—but don’t overstuff the omelette—when the eggs begin to set. Cook for a few more seconds\n" +
                "5. Fold and serve: Fold the omelette in half. Slide it onto a plate with the help of a silicone spatula.");

        Notes notes = new Notes();
        notes.setRecipe(omelettes);
        notes.setRecipeNotes("Channel your inner elegant French cook and don’t overstuff the omelette! You should have enough filling to make the omelette tasty, but not so much that it’s bursting and spilling out of the eggs. With practice, you will be able to eyeball how much to put in the omelette.");
        omelettes.setNotes(notes);

        this.recipeRepository.save(omelettes);

    }
}
