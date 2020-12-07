package transferobjects.RecipeRelated;

import java.io.Serializable;
import java.util.List;

public class Ingredient implements Serializable {
    public int IngredientId;
    public String IngredientName;
    public double number;
    public String amountUnitType;
    public List<IngredientRecipe> IngredientRecipes;

    public Ingredient(){}

    public Ingredient(String name, double amountNumber, String amountUnitType, int ingredientId){
        this.IngredientName = name;
        this.number = amountNumber;
        this.amountUnitType = amountUnitType;
        this.IngredientId = ingredientId;
    }
    public String toString(){
        return IngredientName + " (" + number + amountUnitType + ")";
    }
}
