package transferobjects;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    public String recipeName;
    public String Instructions;
    public double cookingTime;
    public List<Ingredient> ingredients;
    public Category category;

    public String getName() {
        return recipeName;
    }

    public Category getCategory() {
        return category;
    }

    public double getCookingTime() {
        return cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setName(String name) {
        this.recipeName = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCookingTime(double cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.Instructions = instructions;
    }

    public String toString(){
        return recipeName + "(" + cookingTime + "/" + category.categoryName + ")";
    }
}
