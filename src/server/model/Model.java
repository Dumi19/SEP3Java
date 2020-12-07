package server.model;

import java.io.IOException;

public interface Model
{
  String getObject(String toFetch) throws IOException;
  String sendObject(Object object, String toDo)throws IOException;
}
