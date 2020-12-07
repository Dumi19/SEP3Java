package client.view.Navigation;

import client.model.Model;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Json;
import transferobjects.ShopRelated.Shop;

import java.io.IOException;
import java.util.List;

public class NavigationVM {
    private Model model;
    private ListProperty<Shop> shopList;

    public NavigationVM(Model model){
        this.model = model;
        shopList = new SimpleListProperty<Shop>();
    }

    ListProperty<Shop> shopListProperty(){
        return shopList;
    }

    public void getShops() {
        String shopInJsonString = model.getObject("getShops");
        ObservableList<Shop> obsListShops = FXCollections.observableArrayList();
        try {
            List<Shop> shops = Json.parseShopList(shopInJsonString);
            obsListShops.addAll(shops);
            shopList.setValue(obsListShops);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
