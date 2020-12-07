package client.networking;

import transferobjects.Request;
import transferobjects.ShopRelated.Shop;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public SocketClient() {
    support = new PropertyChangeSupport(this);
  }

  private Request request(Object arg, String type) throws IOException, ClassNotFoundException {
    Socket socket = new Socket("localhost", 2910);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
  }

  @Override
  public String getObject(String toFetch) {
    try{
      Request response = request(null,toFetch);
      return (String)response.getArg();
    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String sendObject(Object object, String toDo) {
    try{
      Request response = request(object,toDo);
      return (String)response.getArg();
    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
    return null;
  }
}
