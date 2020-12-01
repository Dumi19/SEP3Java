package transferobjects;

import java.io.Serializable;

public class Ingredient implements Serializable {
    public int ingredientId;
    public String ingredientName;
    public double amountNumber;
    public String amountUnitType;

    public Ingredient(){}

    public Ingredient(String name, double amountNumber, String amountUnitType, int ingredientId){
        this.ingredientName = name;
        this.amountNumber = amountNumber;
        this.amountUnitType = amountUnitType;
        this.ingredientId = ingredientId;
    }
    public String getName() {
        return ingredientName;
    }
    public int getIngredientId() {
        return ingredientId;
    }
    public double getAmountNumber() { return amountNumber; }
    public String getAmountUnitType() { return amountUnitType; }
    public void setName(String name) {
        this.ingredientName = name;
    }
    public void setAmountNumber(double amountNumber) { this.amountNumber = amountNumber; }
    public void setAmountUnitType(String amountUnitType) { this.amountUnitType = amountUnitType; }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String toString(){
        return ingredientName + " (" + amountNumber + amountUnitType + ")";
    }
}
