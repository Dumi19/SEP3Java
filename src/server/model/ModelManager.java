package server.model;

import client.networking.Client;
import server.socketsToDatabase.SocketInterface;
import shared.User;

public class ModelManager implements Model
{
  private SocketInterface socketInterface;

  public ModelManager(SocketInterface socketInterface){
    this.socketInterface = socketInterface;
  }
  @Override public User getUsername()
  {
    return socketInterface.getUsername();
  }
}
