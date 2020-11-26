package transferobjects;

import java.io.Serializable;
import java.util.List;

public class Shop implements Serializable {
    public String shopName;
    public List<ShopIngredient> vares;
    public Address shopAddress;

    public Address getShopAddress() {
        return shopAddress;
    }

    public List<ShopIngredient> getVares() {
        return vares;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setVares(List<ShopIngredient> vares) {
        this.vares = vares;
    }
}
