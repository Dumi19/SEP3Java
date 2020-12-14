package shared.transferObjects.OrderRelated;

import shared.transferObjects.AccountRelated.Account;
import shared.transferObjects.RecipeRelated.Recipe;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    public int orderId;
    public Date dateTime;
    public double orderPrice;
    public int recipeId;
    public String username;
    public Recipe recipe;
    public Account account;
    public List<OrderedShopIngredients> OrderedShopIngredients;

    public Order(){
    }

    public String toString(){
        return "[Id: " + orderId + "]" + "\n" + "UserName: " +username + "\n" + "Recipe: " + recipe.recipeName + "\n" + "Date: " + dateTime.toString();
    }
}
