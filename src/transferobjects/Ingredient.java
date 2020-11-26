package transferobjects;

import java.io.Serializable;

public class Ingredient implements Serializable {
    public int ingredientId;
    public String ingredientName;
    public Amount Amount;

    public Ingredient(){}

    public Ingredient(String name, Amount amount, int ingredientId){
        this.ingredientName = name;
        this.Amount = amount;
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return ingredientName;
    }

    public Amount getAmount() {
        return Amount;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setName(String name) {
        this.ingredientName = name;
    }

    public void setAmount(Amount amount) {
        this.Amount = amount;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String toString(){
        return ingredientName + " (" + Amount.number + "/" + Amount.unitType + ")";
    }
}
