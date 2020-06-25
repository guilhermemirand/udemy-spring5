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
        this.loadPeperonata();
    }

    private void loadPeperonata() {
        Recipe peperonata = Recipe.builder()
                .description("Peperonata")
                .categories(new HashSet<>())
                .cookTime(15)
                .difficulty(Difficulty.EASY)
                .servings(6)
                .prepTime(15)
                .url("https://www.simplyrecipes.com/recipes/peperonata/")
                .ingredients(new HashSet<>())
                .directions("1 Sauté the onions: Heat olive oil in a large sauté pan on medium high heat. When the oil is shimmering, add the onions. Sprinkle with a little salt and sauté for 2-3 minutes, until the onions just begin to color.\n" +
                        "2 Add the peppers: Add the peppers and stir well to combine with the onions. Sauté for 4-5 minutes, stirring often. The peppers should be al dente—cooked, but with a little crunch left in them.\n" +
                        "3 Add the garlic: Add the garlic, and sauté another 1-2 minutes.\n" +
                        "4 Add salt, sugar, oregano: Sprinkle a little more salt over everything and add the sugar and dried oregano. Cook 1 minute.\n" +
                        "5 Add the diced tomatoes, and cook just one minute further.\n" +
                        "6 Add basil, black pepper, lemon juice: Turn off the heat and mix in the torn basil. Grind some black pepper over everything. Right before serving squeeze a little lemon juice over the dish.")
                .build();
        peperonata.getCategories().add(this.categoryRepository.findByDescription("Italian").orElse(null));
        Ingredient oliveOil = Ingredient.builder()
                .description("Extra virgin olive oil")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Cup").orElse(null))
                .amount(BigDecimal.valueOf(0.25))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(oliveOil);

        Ingredient redBell = Ingredient.builder()
                .description("Red bell peppers")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(2))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(redBell);

        Ingredient yellowBell = Ingredient.builder()
                .description("Yellow bell peppers")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(2))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(yellowBell);

        Ingredient orangeBell = Ingredient.builder()
                .description("Orange or Green bell peppers")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(2))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(orangeBell);

        Ingredient onion = Ingredient.builder()
                .description("Large onion")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(1))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(onion);

        Ingredient garlicCloves = Ingredient.builder()
                .description("Garlic cloves")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(4))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(garlicCloves);

        Ingredient oregano = Ingredient.builder()
                .description("Dried oregano")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Tablespoon").orElse(null))
                .amount(BigDecimal.valueOf(1))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(oregano);

        Ingredient sugar = Ingredient.builder()
                .description("Sugar")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Tablespoon").orElse(null))
                .amount(BigDecimal.valueOf(1))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(sugar);

        Ingredient tomatoes = Ingredient.builder()
                .description("Roma or other plum tomatoes")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(5))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(tomatoes);

        Ingredient salt = Ingredient.builder()
                .description("Salt and pepper")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Pinch").orElse(null))
                .amount(BigDecimal.valueOf(1))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(salt);

        Ingredient basil = Ingredient.builder()
                .description("Fresh basil")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Cup").orElse(null))
                .amount(BigDecimal.valueOf(0.5))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(basil);

        Ingredient lemonJuice = Ingredient.builder()
                .description("Lemon juice")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Cup").orElse(null))
                .amount(BigDecimal.valueOf(1))
                .recipe(peperonata)
                .build();
        peperonata.getIngredients().add(lemonJuice);

        Notes notes = Notes.builder().recipe(peperonata).recipeNotes("Peperonata recipes come in many versions; some get cooked a good long time, some get cooked with potatoes, or without tomatoes. This dish is certainly open-for-improvisation!").build();
        peperonata.setNotes(notes);
        this.recipeRepository.save(peperonata);
    }

    private void loadOmelettes() {
        Recipe omelettes = Recipe.builder()
                .description("Omelette")
                .categories(new HashSet<>())
                .cookTime(5)
                .difficulty(Difficulty.EASY)
                .servings(2)
                .prepTime(1)
                .url("https://www.simplyrecipes.com/recipes/how_to_make_an_omelet/")
                .ingredients(new HashSet<>())
                .directions("1. Beat the eggs: Use two or three eggs per omelette, depending on how hungry you are. Beat the eggs lightly with a fork.\n" +
                        "2. Melt the butter: Use an 8-inch nonstick skillet for a 2-egg omelette, a 9-inch skillet for 3 eggs. Melt the butter over medium-low heat, and keep the temperature low and slow when cooking the eggs so the bottom doesn’t get too brown or overcooked.\n" +
                        "3. Add the eggs: Let the eggs sit for a minute, then use a heatproof silicone spatula to gently lift the cooked eggs from the edges of the pan. Tilt the pan to allow the uncooked eggs to flow to the edge of the pan.\n" +
                        "4. Fill the omelette: Add the filling—but don’t overstuff the omelette—when the eggs begin to set. Cook for a few more seconds\n" +
                        "5. Fold and serve: Fold the omelette in half. Slide it onto a plate with the help of a silicone spatula.")
                .build();

        omelettes.getCategories().add(this.categoryRepository.findByDescription("French").orElse(null));

        Ingredient eggs = Ingredient.builder()
                .description("Eggs")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Unit").orElse(null))
                .amount(BigDecimal.valueOf(3l))
                .recipe(omelettes)
                .build();

        Ingredient butter = Ingredient.builder()
                .description("Butter")
                .unitOfMensure(this.unitOfMensureRepository.findByDescription("Tablespoon").orElse(null))
                .amount(BigDecimal.valueOf(1l))
                .recipe(omelettes)
                .build();

        Notes notes = Notes.builder().recipe(omelettes).recipeNotes("Channel your inner elegant French cook and don’t overstuff the omelette! You should have enough filling to make the omelette tasty, but not so much that it’s bursting and spilling out of the eggs. With practice, you will be able to eyeball how much to put in the omelette.").build();

        omelettes.getIngredients().add(eggs);
        omelettes.getIngredients().add(butter);
        omelettes.setNotes(notes);
        this.recipeRepository.save(omelettes);
    }
}
