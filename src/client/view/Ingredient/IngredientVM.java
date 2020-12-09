package client.view.Ingredient;

import client.model.Model;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Json;
import shared.transferObjects.RecipeRelated.Ingredient;
import shared.transferObjects.RecipeRelated.IngredientRecipe;

import java.io.IOException;
import java.util.ArrayList;
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
        ingrTemp.IngredientRecipes = new ArrayList<IngredientRecipe>();
        return model.sendObject(ingrTemp,"addIngredient");
    }

    public String removeIngredient(Ingredient toBeRemoved) {
        ingredients.remove(toBeRemoved);
        return model.sendObject(toBeRemoved, "removeIngredient");
    }

    public int getId() {
        getIngredient();
        return ingredients.size();
    }
}
