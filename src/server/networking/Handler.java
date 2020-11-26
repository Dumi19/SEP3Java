package server.networking;

import server.model.Model;
import transferobjects.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
      String result = "";
      if(request.getArg() != null){
        if(request.getType().contains("add")){
          result = model.addObject(request.getArg(),request.getType());
        }else if(request.getType().contains("remove")){
          result = model.removeObject(request.getArg(),request.getType());
        }
      }else{
        result = model.getObject(request.getType());
      }
      outToClient.writeObject(new Request(null,result));
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
