package ru.ejuravlev.tacocloud;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.ejuravlev.tacocloud.models.Ingredient;
import ru.ejuravlev.tacocloud.repository.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private final IngredientRepository ingredientRepo;

  public IngredientByIdConverter(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }

  @Override
  public Ingredient convert(@NonNull String id) {
    return ingredientRepo.findById(id).orElse(null);
  }
}
