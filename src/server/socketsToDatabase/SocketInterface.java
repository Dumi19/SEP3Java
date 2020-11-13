package server.socketsToDatabase;

import shared.User;

import java.io.IOException;

public interface SocketInterface
{
  String getUsername() throws IOException;
}
