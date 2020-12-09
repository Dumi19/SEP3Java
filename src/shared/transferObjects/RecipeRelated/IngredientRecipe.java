package shared.transferObjects.RecipeRelated;

import java.io.Serializable;

public class IngredientRecipe implements Serializable{
    public int recipeId;
    public Recipe recipe;
    public int ingredientId;
    public Ingredient ingredient;

    public int getIngredientId() {
        return ingredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
