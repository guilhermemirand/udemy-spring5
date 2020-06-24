package br.com.guilhermemirand.spring5recipe.repository;

import br.com.guilhermemirand.spring5recipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
