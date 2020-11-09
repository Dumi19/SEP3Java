package server.networking;

import server.model.Model;
import shared.User;
import transferobjects.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Handler implements Runnable
{
  private Socket socket;
  private Model model;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;

  public Handler(Socket socket, Model model) {
    this.socket = socket;
    this.model = model;

    try {
      outToClient = new ObjectOutputStream(socket.getOutputStream());
      inFromClient = new ObjectInputStream(socket.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      Request request = (Request) inFromClient.readObject();
      if("Username".equals(request.getType())) {
        User result = model.getUsername();
        outToClient.writeObject(new Request("Username", result));
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
