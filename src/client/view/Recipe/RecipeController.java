package client.view.Recipe;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import com.sun.jdi.InvocationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import transferobjects.Ingredient;
import transferobjects.Recipe;

import javax.swing.*;


public class RecipeController implements ViewController {

    @FXML private ListView<Ingredient> existingIngredients;
    @FXML private ListView<Ingredient> recipeIngredients;
    @FXML private ListView<Recipe> existingRecipies;
    @FXML private TextField recipeName;
    @FXML private TextField cookingTime;
    @FXML private TextField ingrName;
    @FXML private TextField ingrNumber;
    @FXML private TextField ingrunitType;
    @FXML private TextField categoryName;
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
        categoryName.textProperty().bindBidirectional(vm.getCategoryName());
        vm.getIngredients();
        vm.getRecipies();
    }

    public void updateRecipe(){
        try{
            vm.updateRecipe(existingRecipies.getSelectionModel().getSelectedItem());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void removeRecipe(){ }

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

    public void addRecipy(){
        JOptionPane.showMessageDialog(frame,vm.addRecipy());
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
