package client.view.Ingredient;

import client.model.Model;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Json;
import transferobjects.Ingredient;

import java.io.IOException;
import java.util.List;

public class IngredientVM {
    private Model model;
    private ListProperty<Ingredient> ingredients;

    public IngredientVM(Model model){
        this.model = model;
        ingredients = new SimpleListProperty<Ingredient>();
    }

    public void getIngredient(){
        String ingrInJsonString = model.getObject("getIngredients");
        ObservableList<Ingredient> obsListIngr = FXCollections.observableArrayList();
        try{
            List<Ingredient> ingredientList = Json.parseIngredientList(ingrInJsonString);
            obsListIngr.addAll(ingredientList);
            ingredients.setValue(obsListIngr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    ListProperty<Ingredient> ingredientListProperty(){return ingredients;}

    public String addIngredient(Ingredient ingrTemp) {
        ingrTemp.ingredientId = ingredients.size() + 1;
        return model.addObject(ingrTemp,"addIngredient");
    }

    public String removeIngredient(Ingredient toBeRemoved) {
        ingredients.remove(toBeRemoved);
        return model.removeObject(toBeRemoved, "removeIngredient");
    }

    public int getId() {
        getIngredient();
        return ingredients.size();
    }
}
