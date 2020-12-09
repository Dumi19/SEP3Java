package shared.transferObjects.OrderRelated;

import shared.transferObjects.AccountRelated.Account;
import shared.transferObjects.RecipeRelated.Recipe;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    public int orderId;
    public LocalDateTime dateTime;
    public double orderPrice;
    public int recipeId;
    public String username;
    public Recipe recipe;
    public Account account;
    public List<OrderedShopIngredients> OrderedShopIngredients;

    public Order(){
    }

    public String toString(){
        return "[" + recipeId + "] " + username + " (" + recipe.toString() + ") " + dateTime.toString();
    }
}
