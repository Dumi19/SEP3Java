package client.view.Delivery;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import shared.transferObjects.OrderRelated.Order;
import java.util.List;

public class DeliveryController implements ViewController {

    @FXML private ListView<Order> orders;
    private ViewHandler vh;
    private DeliveryVM vm;
    private ObservableList<Order> observableList = FXCollections.observableArrayList();


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getDeliveryVM();
        updateList();
    }

    public void updateList(){
        List<Order> orderList = vm.getOrders();
        observableList.setAll(orderList);
        orders.setItems(observableList);
    }

    public void onBack(){
        vh.openNavigationView();
    }
}
