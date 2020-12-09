package shared.transferObjects.OrderRelated;

import shared.transferObjects.ShopRelated.ShopIngredient;

import java.io.Serializable;

public class OrderedShopIngredients implements Serializable {
    public int osId;
    public double totalPrice;
    public int amount;
    public ShopIngredient shopIngredient;
}
