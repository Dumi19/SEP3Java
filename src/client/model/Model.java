package client.model;

public interface Model
{
  String getObject(String toFetch);
  String sendObject(Object object, String toDo);
}
