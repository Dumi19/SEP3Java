package client.networking;

import shared.User;
import transferobjects.Request;

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


  @Override public String getUsername()
  {
    try {
      Request response = request(null, "Username");
      return (String)response.getArg();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  private Request request(String arg, String type) throws IOException, ClassNotFoundException {
    Socket socket = new Socket("localhost", 2910);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
  }
}
