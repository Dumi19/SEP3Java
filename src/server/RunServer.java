package server;

import server.model.ModelManager;
import server.networking.SocketServer;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
    SocketServer socketServer = new SocketServer(new ModelManager());
    socketServer.startServer();
  }
}
