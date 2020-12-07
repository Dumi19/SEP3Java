package server.networking;

import server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private Model model;

  public SocketServer(Model model) {
    this.model = model;
  }

  public void startServer() {
    try {
      ServerSocket welcomeSocket = new ServerSocket(2910);
      while(true) {
        Socket socket = welcomeSocket.accept();
        new Thread(new Handler(socket, model)).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
