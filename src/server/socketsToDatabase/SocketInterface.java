package server.socketsToDatabase;

import java.io.IOException;

public interface SocketInterface
{
  String getObject(String toFetch) throws IOException;
  String sendObject(Object object, String toDo)throws IOException;
}
