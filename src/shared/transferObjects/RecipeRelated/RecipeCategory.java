package shared.transferObjects.RecipeRelated;

import java.io.Serializable;

public class RecipeCategory implements Serializable{
    public int recipeId;
    public Recipe recipe;
    public String categoryName;
    public Category category;

    public RecipeCategory(int recipeId, Recipe recipe, String categoryName, Category category){
        this.recipeId = recipeId;
        this.recipe = recipe;
        this.categoryName = categoryName;
        this.category = category;
    }
}
