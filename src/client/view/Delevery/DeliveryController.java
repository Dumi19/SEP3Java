package client.view.Delevery;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObjects.OrderRelated.Order;
import shared.transferObjects.RecipeRelated.Recipe;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryController implements ViewController {

    @FXML public TableColumn<Order, Integer> orderIdColumn;
    @FXML public TableView<Order> orderTable;
    @FXML public TableColumn<Order, String> usernameColumn;
    @FXML public TableColumn<Order, Recipe> recipeColumn;
    @FXML public TableColumn<Order, LocalDateTime> dateColumn;


    private ViewHandler vh;
    private DeliveryVM vm;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getDeliveryVM();
        List<Order> orderList = vm.getOrders();
        for (int i = 0; i < orderList.size(); i++){
            orderIdColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("" + orderList.get(i).orderId));
            usernameColumn.setCellValueFactory(new PropertyValueFactory(orderList.get(i).username));
            recipeColumn.setCellValueFactory(new PropertyValueFactory(orderList.get(i).recipe.toString()));
            dateColumn.setCellValueFactory(new PropertyValueFactory(orderList.get(i).dateTime.toString()));
        }
    }

    public void onBack(){
        vh.openNavigationView();
    }
}
