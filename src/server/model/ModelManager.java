package server.model;

import server.socketsToDatabase.SocketInterface;

import java.io.IOException;

public class ModelManager implements Model
{
  private SocketInterface socketInterface;

  public ModelManager(SocketInterface socketInterface){
    this.socketInterface = socketInterface;
  }

  @Override public String getObject(String toFetch) throws IOException
  {
    return socketInterface.getObject(toFetch);
  }

  @Override
  public String sendObject(Object object, String toDo) throws IOException {
    return socketInterface.sendObject(object,toDo);
  }
}
