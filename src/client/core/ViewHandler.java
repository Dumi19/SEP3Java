package client.core;

import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene navigationScene;
  private Scene shopScene;
  private Scene ingredientScene;
  private Scene recipeScene;
  private Scene deliveryScene;

  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    stage = new Stage();
    openNavigationView();
  }

  public void openNavigationView(){
    if(navigationScene == null){
      try{
        Parent root = loadFXML("../view/Navigation/NavigationView.fxml");
        navigationScene = new Scene(root);
        stage.setTitle("Navigation");
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    stage.setScene(navigationScene);
    stage.show();
  }

  public void openShopView() {
    if(shopScene == null){
      try {
        Parent root = loadFXML("../view/Shop/ShopView.fxml");
        shopScene = new Scene(root);
        stage.setTitle("Shop");
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    stage.setScene(shopScene);
    stage.show();
  }

  public void openIngredientView(){
    if(ingredientScene == null){
      try {
        Parent root = loadFXML("../view/Ingredient/IngredientView.fxml");
        ingredientScene = new Scene(root);
        stage.setTitle("Ingredient");
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    stage.setScene(ingredientScene);
    stage.show();
  }

  public void openRecipeView(){
    if(recipeScene == null){
      try{
        Parent root = loadFXML("../view/Recipe/RecipeView.fxml");
        recipeScene = new Scene(root);
        stage.setTitle("Recipe");
      }catch (IOException e){
        e.printStackTrace();;
      }
    }
    stage.setScene(recipeScene);
    stage.show();
  }

  public void openDeliveryView(){
    if(deliveryScene == null){
      try{
        Parent root = loadFXML("../view/Delivery/DeliveryView.fxml");
        deliveryScene = new Scene(root);
        stage.setTitle("Delivery");
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    stage.setScene(deliveryScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();
    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
