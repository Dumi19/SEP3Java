package shared.transferObjects.ShopRelated;

import java.io.Serializable;
import java.util.List;

public class ShopIngredient implements Serializable {
    public int id;
    public String name;
    public double price;
    public double amount;
    public String unitType;
    public List<ShopVare> ShopVares;

    public ShopIngredient(){}

    public ShopIngredient(int id, String name, double price, double amount, String unitType, List<ShopVare> shopVares){
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.unitType = unitType;
        this.ShopVares = shopVares;
    }

    public String getName() {
        return name;
    }

    public double getPrice() { return price; }

    public int getId() {
        return id;
    }

    public String getUnitType() { return unitType; }

    public double getAmount() { return amount; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) { this.amount = amount; }

    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String toString(){
        return name + " (" + amount + unitType + ")" + "[" + id + "]";
    }
}
