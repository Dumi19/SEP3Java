package server.socketsToDatabase;

import java.io.IOException;

public interface SocketInterface
{
  String getObject(String toFetch) throws IOException;
  String addObject(Object object, String toAdd) throws IOException;
  String removeObject(Object object, String toRemove) throws IOException;
}
