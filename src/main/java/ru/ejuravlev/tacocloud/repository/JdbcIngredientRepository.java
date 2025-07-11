package ru.ejuravlev.tacocloud.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.ejuravlev.tacocloud.models.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

  private final JdbcTemplate jdbcTemplate;

  public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
    return new Ingredient(
      row.getString("id"),
      row.getString("name"),
      Ingredient.Type.valueOf(row.getString("type"))
    );
  }

  @Override
  public Iterable<Ingredient> findAll() {
    return jdbcTemplate.query(
      "select id, name, type from Ingredient", this::mapRowToIngredient
    );
  }

  @Override
  public Optional<Ingredient> findById(String id) {
    List<Ingredient> results = jdbcTemplate.query(
      "select id, name, type from Ingredient where id=?",
      this::mapRowToIngredient,
      id
    );

    return results.isEmpty() ? Optional.empty() : Optional.of(results.getFirst());
  }

  @Override
  public Ingredient save(Ingredient ingredient) {
    jdbcTemplate.update(
      "insert into Ingredient (id, name, type) values (?, ?, ?)",
      ingredient.getId(),
      ingredient.getName(),
        ingredient.getType()
    );
    return ingredient;
  }
}
