package client.view.Navigation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;

public class NavigationController implements ViewController {
    private NavigationVM nvm;
    private ViewHandler vh;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.vh = viewHandler;
        nvm = vmf.getNavigationVM();
    }

    public void goToRecipe(){
        vh.openRecipeView();
    }

    public void goToShop(){vh.openShopView();}

    public void goToDeliveries(){vh.openDeliveryView();}
}
