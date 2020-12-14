package client.view.Recipe;

import client.model.Model;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Json;
import shared.transferObjects.RecipeRelated.*;

import java.io.IOException;
import java.util.List;

public class RecipeVM {
    private Model model;
    private ListProperty<Ingredient> existingIngredients;
    private ListProperty<Ingredient> recipeIngredients;
    private ListProperty<Recipe> existingRecipes;
    private StringProperty recipeName;
    private StringProperty instructions;
    private StringProperty cookingTime;
    private StringProperty ingredientName;
    private StringProperty ingrNumber;
    private StringProperty ingrUnitType;
    private StringProperty categoryName;
    private StringProperty description;
    private StringProperty imageName;
    private ObservableList<Ingredient> ingredientsInRecipeObs = FXCollections.observableArrayList();
    private ObservableList<Recipe> obsListRecipe = FXCollections.observableArrayList();
    private ObservableList<Category> obsCategory = FXCollections.observableArrayList();

    public RecipeVM(Model model){
        this.model = model;
        existingIngredients = new SimpleListProperty<>();
        recipeIngredients = new SimpleListProperty<>();
        existingRecipes = new SimpleListProperty<>();
        recipeName = new SimpleStringProperty();
        instructions = new SimpleStringProperty();
        cookingTime = new SimpleStringProperty();
        ingredientName = new SimpleStringProperty();
        ingrNumber = new SimpleStringProperty();
        ingrUnitType = new SimpleStringProperty();
        categoryName = new SimpleStringProperty();
        description = new SimpleStringProperty();
        imageName = new SimpleStringProperty();
    }

    public void getIngredients(){
        String ingrInJsonString = model.getObject("getIngredients");
        ObservableList<Ingredient> obsListIngr = FXCollections.observableArrayList();
        try{
            List<Ingredient> ingredientList = Json.parseIngredientList(ingrInJsonString);
            obsListIngr.addAll(ingredientList);
            existingIngredients.setValue(obsListIngr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getRecipies(){
        String recipeInJsonString = model.getObject("getRecipes");
        try{
            List<Recipe> recipes = Json.parseRecipeList(recipeInJsonString);
            obsListRecipe.addAll(recipes);
            existingRecipes.setValue(obsListRecipe);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getCategories() {
        String categoryInJsonString = model.getObject("getCategories");
        try{
            System.out.println(categoryInJsonString);
            List<Category> categories = Json.parseCategoryList(categoryInJsonString);
            obsCategory.setAll(categories);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addIngredientToRecipe(Ingredient toAdd){
        ingredientsInRecipeObs.add(toAdd);
        recipeIngredients.set(ingredientsInRecipeObs);
    }

    public String addRecipe(Category category, List<Ingredient> ingredients){
        if(recipeIngredients.size() >= 2 && checkString()){
            try{
                Recipe toAdd = new Recipe(existingRecipes.size() +1,recipeName.get(),
                        instructions.get(),Double.parseDouble(cookingTime.get()));
                toAdd.ingredients = ingredients;
                toAdd.description = description.get();
                toAdd.imageName = imageName.get();
                toAdd.category = category;
                String addRecipe = model.sendObject(toAdd,"addRecipe");
                return addRecipe;
            }catch (NumberFormatException e){
                e.printStackTrace();
                return "Cooking time must be a number";
            }
        }else{
            return "Invalid Input: All input must be from the Alphabet and not empty";
        }
    }

    private boolean checkString() {
        if(!recipeName.get().isEmpty() && !instructions.get().isEmpty() && !cookingTime.get().isEmpty()
                && !categoryName.get().isEmpty() && description.get().isEmpty() && imageName.get().isEmpty()){
            String temp = recipeName.get() + instructions.get() + categoryName.get() + description.get() + imageName.get();
            return temp.matches("^[a-zA-Z0-9]*$");
        }else{
            return false;
        }
    }

    public void addIngredient(){
        try{
            Ingredient toAdd = new Ingredient();
            toAdd.ingredientName = ingredientName.get();
            double number = Double.parseDouble(ingrNumber.get());
            String unitType = ingrUnitType.get();
            toAdd.number = number;
            toAdd.unitType = unitType;
            ingredientsInRecipeObs.add(toAdd);
            recipeIngredients.set(ingredientsInRecipeObs);
            ingredientName.set("");
            ingrUnitType.set("");
            ingrNumber.set("");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    ListProperty<Ingredient> getExistingIngredients(){return existingIngredients;}
    ListProperty<Ingredient> getRecipeIngredients(){ return recipeIngredients; }
    ListProperty<Recipe> getExistingRecipes(){ return existingRecipes; }
    ObservableList<Category> getCategoriesList(){return obsCategory;}
    StringProperty getRecipeName(){ return recipeName; }
    StringProperty getInstructions(){ return instructions; }
    StringProperty getCookingTime(){ return cookingTime; }
    StringProperty getIngredientName(){ return ingredientName; }
    StringProperty getIngrNumber(){ return ingrNumber; }
    StringProperty getIngrUnitType(){ return ingrUnitType; }
    StringProperty getDescription(){return description;}
    StringProperty getImageName(){return imageName;}
}
