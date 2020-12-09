package client.view.Recipe;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.transferObjects.RecipeRelated.Category;
import shared.transferObjects.RecipeRelated.Ingredient;
import shared.transferObjects.RecipeRelated.Recipe;

import javax.swing.*;


public class RecipeController implements ViewController {

    @FXML private ListView<Ingredient> existingIngredients;
    @FXML private ListView<Ingredient> recipeIngredients;
    @FXML private ListView<Recipe> existingRecipies;
    @FXML private ChoiceBox<Category> categoryCB;
    @FXML private TextField recipeName;
    @FXML private TextField cookingTime;
    @FXML private TextField ingrName;
    @FXML private TextField ingrNumber;
    @FXML private TextField ingrunitType;
    @FXML private TextArea instructions;

    private RecipeVM vm;
    private ViewHandler vh;
    private JFrame frame;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getRecipeVM();
        existingIngredients.itemsProperty().bind(vm.getExistingIngredients());
        recipeIngredients.itemsProperty().bind(vm.getRecipeIngredients());
        existingRecipies.itemsProperty().bind(vm.getExistingRecipes());
        recipeName.textProperty().bindBidirectional(vm.getRecipeName());
        cookingTime.textProperty().bindBidirectional(vm.getCookingTime());
        ingrName.textProperty().bindBidirectional(vm.getIngredientName());
        ingrNumber.textProperty().bindBidirectional(vm.getIngrNumber());
        ingrunitType.textProperty().bindBidirectional(vm.getIngrUnitType());
        instructions.textProperty().bindBidirectional(vm.getInstructions());
        categoryCB.setItems(vm.getCategoriesList());
        vm.getIngredients();
        vm.getRecipies();
        vm.getCategories();
    }

    public void updateRecipe(){
        try{
            vm.updateRecipe(existingRecipies.getSelectionModel().getSelectedItem());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void removeRecipe(){
        if(existingRecipies.getSelectionModel().getSelectedItem() != null){
            try{
                Recipe toRemove = existingRecipies.getSelectionModel().getSelectedItem();
                String removed = vm.removeRecipe(toRemove);
                JOptionPane.showMessageDialog(frame,removed);
            }catch (NullPointerException e){}
        }else{
            JOptionPane.showMessageDialog(frame,"No recipe selected");
        }
    }

    public void addToRecipe(){
        if(existingIngredients.getSelectionModel().getSelectedItem() != null){
            try{
                Ingredient toAdd = existingIngredients.getSelectionModel().getSelectedItem();
                vm.addIngredientToRecipe(toAdd);
            }catch (NullPointerException e){
            }
        }else{
            JOptionPane.showMessageDialog(frame,"No ingredient selected");
        }
    }

    public void addRecipe(){
        if(categoryCB.getSelectionModel().getSelectedItem() != null && recipeIngredients.getSelectionModel().getSelectedItems().size() > 2){
            JOptionPane.showMessageDialog(frame,vm.addRecipe(categoryCB.getSelectionModel().getSelectedItem(),recipeIngredients.getSelectionModel().getSelectedItems()));
        }else{
            JOptionPane.showMessageDialog(frame, "No Category");
        }
    }

    public void addIngredient(){
        vm.addIngredient();
    }

    public void removeIngredient() {
        if(recipeIngredients.getSelectionModel().getSelectedItem() != null){
            vm.removeIngredient(recipeIngredients.getSelectionModel().getSelectedItem());
        }else{
            JOptionPane.showMessageDialog(frame,"No ingredient selected");
        }
    }

    public void openNavigation(){
        vh.openNavigationView();
    }
}
