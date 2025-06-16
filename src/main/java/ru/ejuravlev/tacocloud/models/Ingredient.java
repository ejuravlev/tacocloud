package ru.ejuravlev.tacocloud.models;

import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final String type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type.toString();
    }
}
