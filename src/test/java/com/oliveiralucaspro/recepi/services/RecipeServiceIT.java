package com.oliveiralucaspro.recepi.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oliveiralucaspro.recepi.commands.RecipeCommand;
import com.oliveiralucaspro.recepi.converters.RecipeCommandToRecipe;
import com.oliveiralucaspro.recepi.converters.RecipeToRecipeCommand;
import com.oliveiralucaspro.recepi.domain.Recipe;
import com.oliveiralucaspro.recepi.repositories.RecipeRepository;

//@DataMongoTest
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

//  @Transactional
    @Test
    public void testSaveOfDescription() throws Exception {
	// given
	Iterable<Recipe> recipes = recipeRepository.findAll();
	Recipe testRecipe = recipes.iterator().next();
	RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

	// when
	testRecipeCommand.setDescription(NEW_DESCRIPTION);
	RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

	// then
	assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
	assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
	assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
	assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
    }
}
