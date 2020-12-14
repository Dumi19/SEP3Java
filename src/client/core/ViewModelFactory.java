package client.core;

import client.view.Delivery.DeliveryVM;
import client.view.Navigation.NavigationVM;
import client.view.Recipe.RecipeVM;
import client.view.Shop.ShopVM;

public class ViewModelFactory
{
  private NavigationVM navigationVM;
  private ShopVM shopVM;
  private RecipeVM recipeVM;
  private DeliveryVM deliveryVM;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf){
    this.mf = mf;
  }

  public NavigationVM getNavigationVM(){
    if(navigationVM == null){
      navigationVM = new NavigationVM(mf.getModel());
    }
    return navigationVM;
  }

  public RecipeVM getRecipeVM(){
    if(recipeVM == null){
      recipeVM = new RecipeVM(mf.getModel());
    }
    return recipeVM;
  }

  public ShopVM getShopVM(){
    if(shopVM == null){
      shopVM = new ShopVM(mf.getModel());
    }
    return shopVM;
  }

  public DeliveryVM getDeliveryVM(){
    if (deliveryVM == null){
      deliveryVM = new DeliveryVM(mf.getModel());
    }
    return deliveryVM;
  }
}
