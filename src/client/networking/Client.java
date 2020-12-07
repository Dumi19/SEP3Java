package client.networking;

public interface Client
{
  String getObject(String toFetch);
  String sendObject(Object object, String toDo);
}
