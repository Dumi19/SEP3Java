package client.view.Delevery;

import client.model.Model;
import client.model.Json;
import shared.transferObjects.OrderRelated.Order;

import java.io.IOException;
import java.util.List;

public class DeliveryVM {

    private Model model;


    public DeliveryVM(Model model){
        this.model = model;
    }

    public List<Order> getOrders() {
        try {
            List<Order> orders = Json.parseOrderList(model.getObject("getOrders"));
            return orders;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
