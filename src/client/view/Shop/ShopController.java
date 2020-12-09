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
    @FXML private ListView<ShopIngredient> ingredientsInShop;
    @FXML private ListView<ShopIngredient> existingShopIngredients;
    @FXML private ListView<ShopIngredient> shopIngredients1;
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
        existingShopIngredients.itemsProperty().bind(vm.getExistingShopIngredients());
        ingredientsInShop.itemsProperty().bind(vm.getIngredientsInShop());
        shops.itemsProperty().bind(vm.getShops());
        cbShops.setItems(vm.setChoiceBox());
        shopIngredients1.itemsProperty().bind(vm.getExistingShopIngredients());
        shopName.textProperty().bindBidirectional(vm.getShopName());
        streetStreetNumber.textProperty().bindBidirectional(vm.getStreetStreetNumber());
        zipCode.textProperty().bindBidirectional(vm.getZipCode());
        city.textProperty().bindBidirectional(vm.getCity());
        ingredientName.textProperty().bindBidirectional(vm.getIngredientName());
        price.textProperty().bindBidirectional(vm.getPrice());
        amount.textProperty().bindBidirectional(vm.getAmount());
        unitType.textProperty().bindBidirectional(vm.getUnitType());
    }

    public void setSelectedShop(){
        if(shops.getSelectionModel().getSelectedItem() != null){
            vm.setSelectedShopForVares(shops.getSelectionModel().getSelectedItem());
        }
    }

    public void setSelectShopCB(){
        if(cbShops.getSelectionModel().getSelectedItem() != null){
            vm.setSelectedShop(cbShops.getSelectionModel().getSelectedItem());
        }
    }

    public void addShop(){
        String response = vm.addShop();
        JOptionPane.showMessageDialog(frame,response);
        vm.getAllData();
    }

    public void updateShop(){
        String response = vm.updateShop();
        JOptionPane.showMessageDialog(frame,response);
    }

    public void removeShop(){
        if(shops.getSelectionModel().getSelectedItem() != null){
            String response = vm.removeShop(shops.getSelectionModel().getSelectedItem());
            JOptionPane.showMessageDialog(frame,response);
        }else{
            JOptionPane.showMessageDialog(frame,"No shop selected");
        }
    }

    public void addExistingShopIngredient(){
        String response = vm.addExistingShopIngredient();
        JOptionPane.showMessageDialog(frame,response);
    }

    public void updateExistingShopIngredient(){

    }

    public void removeExistingShopIngredient(){
        if(shopIngredients1.getSelectionModel().getSelectedItem() != null){
            String response = vm.removeShopIngredient(shopIngredients1.getSelectionModel().getSelectedItem());
            JOptionPane.showMessageDialog(frame,response);
        }else{
            JOptionPane.showMessageDialog(frame,"No Shop Ingredient selected");
        }
    }

    public void linkShopIngredientToShop(){
        if(cbShops.getSelectionModel().getSelectedItem() != null && existingShopIngredients.getSelectionModel().getSelectedItem() != null){
            vm.linkShopIngredientToShop(cbShops.getSelectionModel().getSelectedItem(),existingShopIngredients.getSelectionModel().getSelectedItem());
        }else{
            JOptionPane.showMessageDialog(frame,"Missing selected Shop or ShopIngredient");
        }
    }
}
