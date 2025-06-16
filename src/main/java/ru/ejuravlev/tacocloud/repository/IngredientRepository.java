package ru.ejuravlev.tacocloud.repository;

import java.util.Optional;

import ru.ejuravlev.tacocloud.models.Ingredient;

public interface IngredientRepository {
  Iterable<Ingredient> findAll();
  Optional<Ingredient> findById(String id);
  Ingredient save(Ingredient ingredient);
}
