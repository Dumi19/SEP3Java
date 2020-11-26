package server.model;

import java.io.IOException;

public interface Model
{
  String getObject(String toFetch) throws IOException;
  String addObject(Object object, String toAdd)throws IOException;
  String removeObject(Object arg, String type) throws IOException;
}
