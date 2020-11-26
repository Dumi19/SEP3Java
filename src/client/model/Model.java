package client.model;

import transferobjects.Ingredient;
import transferobjects.Shop;

public interface Model
{
  Shop getSelectedShop();
  void setSelectedShop(Shop selectedShop);
  String getObject(String toFetch);
  String addObject(Object object, String toAdd);
  String removeObject(Object object, String toRemove);
}
