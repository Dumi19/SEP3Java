package client.networking;

public interface Client
{
  String getObject(String toFetch);
  String addObject(Object object, String toAdd);
  String removeObject(Object object, String toRemoce);
}
