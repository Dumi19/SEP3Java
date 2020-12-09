package client.view.Ingredient;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import shared.transferObjects.RecipeRelated.Ingredient;

import javax.swing.*;

public class IngredientController implements ViewController {
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private TextField nameTextField;
    @FXML private TextField numberTextField;
    @FXML private TextField unitTypeTextField;
    @FXML private ListView<Ingredient> ingredients;

    private IngredientVM ivm;
    private ViewHandler vh;
    private JFrame frame;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        ivm = vmf.getIngredientVM();
        this.vh = vh;
        ingredients.itemsProperty().bind(ivm.ingredientListProperty());
        ivm.getIngredient();
    }

    public void addIngredient(){
        if(!nameTextField.getText().isBlank() || !unitTypeTextField.getText().isEmpty()){
            try{
                double number = (Double.parseDouble(numberTextField.getText()));
                String amountUnit = unitTypeTextField.getText();
                Ingredient ingrTemp = new Ingredient(nameTextField.getText(),number,amountUnit,ivm.getId());
                String answer = ivm.addIngredient(ingrTemp);
                ivm.getIngredient();
                JOptionPane.showMessageDialog(frame,answer);
                nameTextField.setText("");
                numberTextField.setText("");
                unitTypeTextField.setText("");
            }catch (NullPointerException e){
                JOptionPane.showMessageDialog(frame,"Number input wrong");
            }
        }else{
            JOptionPane.showMessageDialog(frame,"Name or unitType input wrong");
        }
    }

    public void removeIngredient(){
       Ingredient toBeRemoved = ingredients.getSelectionModel().getSelectedItem();
       if(toBeRemoved != null){
           String result = ivm.removeIngredient(toBeRemoved);
           JOptionPane.showMessageDialog(frame,result);
       }else{
           JOptionPane.showMessageDialog(frame,"No selected Ingredient to remove");
       }
    }

    public void onBack(){
        vh.openNavigationView();
    }
}
