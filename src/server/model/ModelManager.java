package server.model;

import client.networking.Client;
import server.socketsToDatabase.SocketInterface;

public class ModelManager implements Model
{
  private SocketInterface socketInterface;

  public ModelManager(SocketInterface socketInterface){
    this.socketInterface = socketInterface;
  }
  @Override public String getUsername()
  {
    return socketInterface.getUsername();
  }
}
