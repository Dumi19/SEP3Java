package client.view.Navigation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import transferobjects.Shop;

public class NavigationController implements ViewController {

    @FXML private Button goToAccountsButton;
    @FXML private Button goToShopButton;
    @FXML private Button goToIngredientButton;
    @FXML private ChoiceBox<Shop> shopChoiceBox;

    private NavigationVM nvm;
    private ViewHandler vh;
    private Shop selectShop;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.vh = viewHandler;
        nvm = vmf.getNavigationVM();
        //shopChoiceBox.setItems(nvm.shopListProperty());
        //nvm.getShops();
    }

    public void onShopAction(){
        selectShop = shopChoiceBox.getValue();
        if(selectShop != null){
            nvm.setShop(selectShop);
            vh.openShopView();
        }
    }

    public void goToRecipe(){
        vh.openRecipeView();
    }

    public void goToIngredient(){
        vh.openIngredientView();
    }
}
