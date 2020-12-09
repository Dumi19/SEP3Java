package shared.transferObjects.ShopRelated;

import shared.transferObjects.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable {
    public int Id;
    public String ShopName;
    public List<ShopIngredient> Vares = new ArrayList<>();
    public shared.transferObjects.Address Address;
    public List<ShopVare> shopVares;

    public Shop(){}

    public Shop(int id, String shopName, List<ShopIngredient> vares, Address address, List<ShopVare> shopVares){
        this.Id = id;
        this.ShopName = shopName;
        this.Vares = vares;
        this.Address = address;
        this.shopVares = shopVares;
    }

    public Address getShopAddress() {
        return Address;
    }

    public List<ShopIngredient> getVares() {
        return Vares;
    }

    public String getShopName() {
        return ShopName;
    }

    public int getId() { return Id; }

    public shared.transferObjects.Address getAddress() { return Address; }

    public List<ShopVare> getShopVares() { return shopVares; }

    public void setShopAddress(Address shopAddress) {
        this.Address = shopAddress;
    }

    public void setShopName(String shopName) {
        this.ShopName = shopName;
    }

    public void setVares(List<ShopIngredient> vares) {
        this.Vares = vares;
    }

    public void setId(int id) { Id = id; }

    public void setAddress(shared.transferObjects.Address address) { Address = address; }

    public void setShopVares(List<ShopVare> shopVares) { this.shopVares = shopVares; }

    @Override
    public String toString() {
        return ShopName + " (" + Address.Street + ")";
    }
}
