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
  public String addObject(Object object, String toAdd) throws IOException {
    return socketInterface.addObject(object,toAdd);
  }

  @Override
  public String removeObject(Object object, String toRemove)throws IOException {
    return socketInterface.removeObject(object,toRemove);
  }
}
