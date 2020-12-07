package server;

import server.model.ModelManager;
import server.networking.SocketServer;
import server.socketsToDatabase.SocketImplementation;
import server.socketsToDatabase.SocketInterface;

import java.io.IOException;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
    SocketInterface socketInterface = new SocketImplementation();
    SocketServer socketServer = new SocketServer(new ModelManager(socketInterface));
    socketServer.startServer();
  }
}
