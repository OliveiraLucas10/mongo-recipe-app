package com.oliveiralucaspro.recepi.services;

import java.util.Set;

import com.oliveiralucaspro.recepi.commands.RecipeCommand;
import com.oliveiralucaspro.recepi.domain.Recipe;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String l);

    RecipeCommand findCommandById(String l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);

}
