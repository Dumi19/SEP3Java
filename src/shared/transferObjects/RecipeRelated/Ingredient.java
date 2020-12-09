package shared.transferObjects.RecipeRelated;

import java.io.Serializable;
import java.util.List;

public class Ingredient implements Serializable {
    public int ingredientId;
    public String ingredientName;
    public double number;
    public String amountUnitType;
    public List<IngredientRecipe> IngredientRecipes;

    public Ingredient(){}

    public Ingredient(String name, double amountNumber, String amountUnitType, int ingredientId){
        this.ingredientName = name;
        this.number = amountNumber;
        this.amountUnitType = amountUnitType;
        this.ingredientId = ingredientId;
    }
    public String toString(){
        return ingredientName + " (" + number + amountUnitType + ")";
    }
}
