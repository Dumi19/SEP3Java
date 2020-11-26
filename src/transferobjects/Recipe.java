package transferobjects;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable {
    public String name;
    public String instructions;
    public double cookingTime;
    public List<Ingredient> ingredients;
    public Category category;

    public String getName() {
        return name;
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
        return instructions;
    }

    public void setName(String name) {
        this.name = name;
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
        this.instructions = instructions;
    }
}
