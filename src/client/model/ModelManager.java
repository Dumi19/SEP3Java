package client.model;

import client.networking.Client;
import transferobjects.ShopRelated.Shop;

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
  public String sendObject(Object object, String toDo) { return client.sendObject(object,toDo);}
}
