package shared.transferObjects.RecipeRelated;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    public int recipeId;
    public String recipeName;
    public String description;
    public String instructions;
    public int cookingTime;
    public List<Ingredient> ingredients;
    public String imageName;
    public Category category;

    public List<RecipeCategory> RecipeCategories;
    public List<IngredientRecipe> IngredientRecipes;

    public Recipe(){}

    public Recipe(int IdRecipe, String recipeName, String instructions){
        this.recipeId = IdRecipe;
        this.recipeName = recipeName;
        this.instructions = instructions;
    }

    public String getName() {
        return recipeName;
    }

    public Category getCategory() {
        return category;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setName(String name) {
        this.recipeName = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String toString(){
        return recipeName + "(" + cookingTime + ")";
    }
}
