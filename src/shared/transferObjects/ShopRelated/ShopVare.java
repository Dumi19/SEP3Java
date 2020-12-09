package shared.transferObjects.ShopRelated;

public class ShopVare {
    public int shopId;
    public Shop shop;
    public int shopIngredientId;
    public ShopIngredient shopIngredient;

    public int getShopId() {
        return shopId;
    }

    public int getShopIngredientId() {
        return shopIngredientId;
    }

    public Shop getShop() {
        return shop;
    }

    public ShopIngredient getShopIngredient() {
        return shopIngredient;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setShopIngredient(ShopIngredient shopIngredient) {
        this.shopIngredient = shopIngredient;
    }

    public void setShopIngredientId(int shopIngredientId) {
        this.shopIngredientId = shopIngredientId;
    }
}
