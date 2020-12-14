package client.core;

import client.view.Delivery.DeliveryVM;
import client.view.Ingredient.IngredientVM;
import client.view.Navigation.NavigationVM;
import client.view.Recipe.RecipeVM;
import client.view.Shop.ShopVM;

public class ViewModelFactory
{
  private NavigationVM navigationVM;
  private IngredientVM ingredientVM;
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

  public IngredientVM getIngredientVM() {
    if(ingredientVM == null){
      ingredientVM = new IngredientVM(mf.getModel());
    }
    return ingredientVM;
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
