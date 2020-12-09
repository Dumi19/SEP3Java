package client.view.Shop;

import client.model.Model;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Json;
import shared.transferObjects.Address;
import shared.transferObjects.ShopRelated.Shop;
import shared.transferObjects.ShopRelated.ShopIngredient;
import shared.transferObjects.ShopRelated.ShopVare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopVM {

    private StringProperty shopName;
    private StringProperty streetStreetNumber;
    private StringProperty zipCode;
    private StringProperty city;
    private StringProperty ingredientName;
    private StringProperty price;
    private StringProperty amount;
    private StringProperty unitType;
    private ListProperty<ShopIngredient> ingredientsInShop;
    private ListProperty<ShopIngredient> existingShopIngredients;
    private ListProperty<Shop> shops;

    private ObservableList<Shop> shopsInObs = FXCollections.observableArrayList();
    private ObservableList<ShopIngredient> shopIngrInObs = FXCollections.observableArrayList();
    private ObservableList<ShopIngredient> existingShopIngrInObs = FXCollections.observableArrayList();

    private Model model;
    private Shop selectedShop = null;
    private Shop selectedShopForVares = null;

    public ShopVM(Model model) {
        this.model = model;
        shopName = new SimpleStringProperty();
        streetStreetNumber = new SimpleStringProperty();
        zipCode = new SimpleStringProperty();
        city = new SimpleStringProperty();
        ingredientName = new SimpleStringProperty();
        price = new SimpleStringProperty();
        amount = new SimpleStringProperty();
        unitType = new SimpleStringProperty();
        shops = new SimpleListProperty<>();
        ingredientsInShop = new SimpleListProperty<>();
        existingShopIngredients = new SimpleListProperty<>();
    }

    public void getAllData() {
        String existingShopIngredientsInJson = model.getObject("getShopIngredients");
        String shopsInJson = model.getObject("getShops");
        try{
            List<ShopIngredient> existingShopIngr = Json.parseShopIngredientList(existingShopIngredientsInJson);
            for(int i = 0; i < existingShopIngr.size(); i++){
                System.out.println(existingShopIngr);
            }
            List<Shop> shopsTemp = Json.parseShopList(shopsInJson);
            if(shopsTemp.size() != 0){
                shopsInObs.addAll(shopsTemp);
                shops.set(shopsInObs);
                existingShopIngrInObs.addAll(existingShopIngr);
                existingShopIngredients.setValue(existingShopIngrInObs);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Shop> setChoiceBox() {
        return shopsInObs;
    }

    public void setSelectedShop(Shop selectedItem) {
        this.selectedShop = selectedItem;
        shopIngrInObs.setAll(selectedShop.Vares);
        ingredientsInShop.setValue(shopIngrInObs);
    }

    public void setSelectedShopForVares(Shop selectedItem) {
        selectedShopForVares = selectedItem;
        shopIngrInObs.addAll(selectedShopForVares.Vares);
        ingredientsInShop.set(shopIngrInObs);
    }

    public String addShop() {
        Shop toAdd = new Shop();
        if(emptyInput()){
            return "Missing input";
        }else{
            int zip = checkZipCode();
            if(zip == 0){
                return "ZipCode must be 4 numbers and between 1000-9999";
            }else{
                toAdd.ShopName = shopName.get();
                toAdd.Address = new Address(streetStreetNumber.get(),city.get(),zip);
                toAdd.shopVares = new ArrayList<>();
                toAdd.Vares = new ArrayList<>();
                return model.sendObject(toAdd,"addShop");
            }
        }
    }

    public String updateShop(){
        if(selectedShop != null){
            if(emptyInput() && checkZipCode() != 0){
                selectedShop.ShopName = shopName.get();
                selectedShop.Address.Street = streetStreetNumber.get();
                selectedShop.Address.City = city.get();
                selectedShop.Address.ZipCode = checkZipCode();
                return model.sendObject(selectedShop,"updateShop");
            }else{
                return "Input error, missing or zipcode input wrong";
            }
        }else{
            return "No selected shop";
        }
    }

    public String addExistingShopIngredient(){
        if(!ingredientName.get().isEmpty() && !price.get().isEmpty() && !amount.get().isEmpty() && !unitType.get().isEmpty()){
            try{
                double priceToAdd = Double.parseDouble(price.get());
                double amountToAdd = Double.parseDouble(amount.get());
                List<ShopVare> shopVares = new ArrayList<>();
                ShopIngredient temp = new ShopIngredient(existingShopIngredients.size() + 1,ingredientName.get(),priceToAdd, amountToAdd, unitType.get(),shopVares);
                return model.sendObject(temp,"addNewShopIngredient");
            }catch (NumberFormatException e){
                return "Price and amount must be numbers";
            }
        }else{
            return "Missing input";
        }
    }

    public String removeShopIngredient(ShopIngredient selectedItem) {
        return model.sendObject(selectedItem,"removeShopIngredient");
    }

    public void linkShopIngredientToShop(Shop selectedItem, ShopIngredient selectedItem1) {
        if(!selectedItem.Vares.contains(selectedItem1)){
            String response1 = model.sendObject(selectedItem,"linkShopIngredientToShop1");
            if(response1.contains("received")){
                String response2 = model.sendObject(selectedItem1,"linkShopIngredientToShop2");
                if(response2.equals("linked")){
                    getAllData();
                    for(int i = 0; i < shops.size(); i++){
                        if(shops.get(i).Id == selectedItem.Id){
                            selectedShop = shops.get(i);
                            break;
                        }
                    }
                }
            }else{
                System.out.println("Object received error");
            }
        }
    }

    public String removeShop(Shop selectedItem) {
        return model.sendObject(selectedItem,"removeShop");
    }

    private boolean emptyInput() {
        if(shopName.get().isEmpty() || streetStreetNumber.get().isEmpty() || city.get().isEmpty() || zipCode.get().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private int checkZipCode(){
        if(zipCode.get().length() != 4){
            return 0;
        }else{
            try{
                int zip = Integer.parseInt(zipCode.get());
                if(zip < 1000){
                    return 0;
                }else{
                    return zip;
                }
            }catch (NumberFormatException e){
                return 0;
            }
        }
    }

    public StringProperty getShopName(){ return shopName; }
    public StringProperty getStreetStreetNumber(){ return streetStreetNumber; }
    public StringProperty getZipCode(){ return zipCode; }
    public StringProperty getCity(){ return city; }
    public StringProperty getIngredientName(){ return ingredientName; }
    public StringProperty getPrice(){ return price; }
    public StringProperty getAmount(){ return amount; }
    public StringProperty getUnitType(){ return unitType; }
    public ListProperty<Shop> getShops(){ return shops; }
    public ListProperty<ShopIngredient> getIngredientsInShop(){ return ingredientsInShop; }
    public ListProperty<ShopIngredient> getExistingShopIngredients(){ return existingShopIngredients;}
}
