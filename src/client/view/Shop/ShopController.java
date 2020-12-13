package client.view.Shop;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.transferObjects.ShopRelated.Shop;
import shared.transferObjects.ShopRelated.ShopIngredient;

import javax.swing.*;


public class ShopController implements ViewController {

    @FXML private TextField shopName;
    @FXML private TextField streetStreetNumber;
    @FXML private TextField zipCode;
    @FXML private TextField city;
    @FXML private TextField ingredientName;
    @FXML private TextField price;
    @FXML private TextField amount;
    @FXML private TextField unitType;
    @FXML private ListView<ShopIngredient> shopIngredients;
    @FXML private ListView<Shop> shops;
    @FXML private ChoiceBox<Shop> cbShops;

    private ViewHandler vh;
    private ShopVM vm;
    private JFrame frame;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getShopVM();
        vm.getAllData();
        shops.itemsProperty().bind(vm.getShops());
        cbShops.setItems(vm.setChoiceBox());
        shopIngredients.itemsProperty().bind(vm.getIngredientsInShop());
        shopName.textProperty().bindBidirectional(vm.getShopName());
        streetStreetNumber.textProperty().bindBidirectional(vm.getStreetStreetNumber());
        zipCode.textProperty().bindBidirectional(vm.getZipCode());
        city.textProperty().bindBidirectional(vm.getCity());
        ingredientName.textProperty().bindBidirectional(vm.getIngredientName());
        price.textProperty().bindBidirectional(vm.getPrice());
        amount.textProperty().bindBidirectional(vm.getAmount());
        unitType.textProperty().bindBidirectional(vm.getUnitType());
    }

    public void setSelectShopCB(){
        if(cbShops.getSelectionModel().getSelectedItem() != null){
            vm.setSelectedShop(cbShops.getSelectionModel().getSelectedItem());
        }
    }

    public void addShop(){
        String response = vm.addShop();
        JOptionPane.showMessageDialog(frame,response);
        vm.getNewShops();
    }

    public void addExistingShopIngredient(){
        String response = vm.addShopIngredient();
        JOptionPane.showMessageDialog(frame,response);
    }

    public void onBack(){
        vh.openNavigationView();
    }
}
