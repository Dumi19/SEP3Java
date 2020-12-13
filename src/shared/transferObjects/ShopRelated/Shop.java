package shared.transferObjects.ShopRelated;

import shared.transferObjects.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable {
    public int shopId;
    public String shopName;
    public List<ShopIngredient> vares = new ArrayList<>();
    public shared.transferObjects.Address shopAddress;
    public List<ShopVare> shopVares;

    public Shop(){}

    public Shop(int id, String shopName, List<ShopIngredient> vares, Address address, List<ShopVare> shopVares){
        this. shopId = id;
        this.shopName = shopName;
        this.vares = vares;
        this.shopAddress = address;
        this.shopVares = shopVares;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public List<ShopIngredient> getVares() {
        return vares;
    }

    public String getShopName() {
        return shopName;
    }

    public int getId() { return  shopId; }

    public shared.transferObjects.Address getAddress() { return shopAddress; }

    public List<ShopVare> getShopVares() { return shopVares; }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setVares(List<ShopIngredient> vares) {
        this.vares = vares;
    }

    public void setId(int id) {  shopId = id; }

    public void setAddress(shared.transferObjects.Address address) { shopAddress = address; }

    public void setShopVares(List<ShopVare> shopVares) { this.shopVares = shopVares; }

    @Override
    public String toString() {
        return shopName + " (" + shopAddress.Street + ")";
    }
}
