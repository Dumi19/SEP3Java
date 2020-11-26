package client.model;

import client.networking.Client;
import transferobjects.Ingredient;
import transferobjects.Shop;

public class ModelManager implements Model
{
  private Client client;
  private Shop selectedShop;

  public ModelManager(Client client){
    this.client = client;
  }

  @Override public String getObject(String toFetch)
  {
    return client.getObject(toFetch);
  }

  @Override
  public String addObject(Object object, String toAdd) {
    return client.addObject(object,toAdd);
  }

  @Override
  public String removeObject(Object object, String toRemove) {
    return client.removeObject(object,toRemove);
  }

  public Shop getSelectedShop() {
    return selectedShop;
  }

  public void setSelectedShop(Shop selectedShop) {
    this.selectedShop = selectedShop;
  }
}
