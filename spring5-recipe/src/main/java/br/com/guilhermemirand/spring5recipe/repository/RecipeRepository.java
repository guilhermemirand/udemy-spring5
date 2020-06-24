package br.com.guilhermemirand.spring5recipe.repository;

import br.com.guilhermemirand.spring5recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
