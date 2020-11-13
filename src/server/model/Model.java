package server.model;

import shared.User;

import java.io.IOException;

public interface Model
{
  String getUsername() throws IOException;
}
