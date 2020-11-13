package server.model;

import client.networking.Client;
import server.socketsToDatabase.SocketInterface;
import shared.User;

import java.io.IOException;

public class ModelManager implements Model
{
  private SocketInterface socketInterface;

  public ModelManager(SocketInterface socketInterface){
    this.socketInterface = socketInterface;
  }
  @Override public String getUsername() throws IOException
  {
    return socketInterface.getUsername();
  }
}
