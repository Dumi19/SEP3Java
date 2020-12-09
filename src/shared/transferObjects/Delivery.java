package shared.transferObjects;

import shared.transferObjects.RecipeRelated.Recipe;

import java.io.Serializable;

public class Delivery implements Serializable{
    public int deliveryId;
    public String date;
    public double cost;
    public Recipe recipe;


    public double getCost() {
        return cost;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public String getDate() {
        return date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
}
