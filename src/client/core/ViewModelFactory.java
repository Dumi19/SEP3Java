package client.core;

import client.view.Ingredient.IngredientVM;
import client.view.Navigation.NavigationVM;

public class ViewModelFactory
{
  private NavigationVM navigationVM;
  private IngredientVM ingredientVM;
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
}
