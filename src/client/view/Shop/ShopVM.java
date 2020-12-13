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
    private ListProperty<Shop> shops;

    private ObservableList<Shop> shopsInObs = FXCollections.observableArrayList();
    private ObservableList<ShopIngredient> shopIngrInObs = FXCollections.observableArrayList();

    private List<ShopIngredient> shopIngredients;

    private Model model;
    private Shop selectedShop = null;
    private boolean shopSelected;

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
    }

    public void getAllData() {
        String shopIngredient = model.getObject("getShopIngredients");
        String shopsInJson = model.getObject("getShops");
        try{
            shopIngredients = Json.parseShopIngredientList(shopIngredient);
            List<Shop> shopsTemp = Json.parseShopList(shopsInJson);
            if(shopsTemp.size() != 0){
                shopsInObs.addAll(shopsTemp);
                shops.set(shopsInObs);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getNewShops() {
        String shopsInJson = model.getObject("getShops");
        try{
            List<Shop> shopsTemp = Json.parseShopList(shopsInJson);
            if(shopsTemp.size() != 0){
                shopsInObs.clear();
                shopsInObs.addAll(shopsTemp);
                shops.set(shopsInObs);
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
        shopSelected = true;
        shopIngrInObs.setAll(selectedShop.vares);
        ingredientsInShop.setValue(shopIngrInObs);
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
                toAdd.shopId = shops.getSize() +1;
                toAdd.shopName = shopName.get();
                toAdd.shopAddress = new Address(streetStreetNumber.get(),city.get(),zip);
                toAdd.shopVares = null;
                toAdd.vares = new ArrayList<>();
                return model.sendObject(toAdd,"addShop");
            }
        }
    }

    public String addShopIngredient(){
        if(!ingredientName.get().isEmpty() && !price.get().isEmpty() && !amount.get().isEmpty() && !unitType.get().isEmpty() && selectedShop != null){
            try{
                double priceToAdd = Double.parseDouble(price.get());
                double amountToAdd = Double.parseDouble(amount.get());
                List<ShopVare> shopVares = new ArrayList<>();
                ShopIngredient temp = new ShopIngredient(shopIngredients.size() + 1,ingredientName.get(),priceToAdd, amountToAdd, unitType.get(),shopVares);
                return linkShopIngredientToShop(temp);
            }catch (NumberFormatException e){
                return "Price and amount must be numbers";
            }
        }else{
            return "Missing input";
        }
    }

    public String linkShopIngredientToShop(ShopIngredient selectedItem2) {
        if(!selectedShop.vares.contains(selectedItem2)){
            selectedShop.vares.add(selectedItem2);
            ingredientsInShop.add(selectedItem2);
            String respone1 = model.sendObject(selectedShop,"linkShopIngredientToShop1");
            if(respone1.contains("received")){
                return model.sendObject(selectedItem2,"linkShopIngredientToShop2");
            }else{
                return "Failed connection";
            }
        }else{
            return "Shop ingredient already exists";
        }
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
    public ListProperty<ShopIngredient> getIngredientsInShop(){return ingredientsInShop;}
}
