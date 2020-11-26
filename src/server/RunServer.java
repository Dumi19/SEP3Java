package server;

import org.codehaus.jackson.JsonNode;
import server.model.ModelManager;
import server.networking.SocketServer;
import server.socketsToDatabase.SocketImplementation;
import server.socketsToDatabase.SocketInterface;
import shared.Json;
import transferobjects.Account;

import java.io.IOException;
import java.util.List;

public class RunServer
{
  public static void main(String[] args) throws IOException
  {
    SocketInterface socketInterface = new SocketImplementation();
    SocketServer socketServer = new SocketServer(new ModelManager(socketInterface));
    socketServer.startServer();
  }
}
