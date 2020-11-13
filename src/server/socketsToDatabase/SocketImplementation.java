package server.socketsToDatabase;

import shared.User;
import transferobjects.Request;

import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class SocketImplementation implements SocketInterface
{
  private PropertyChangeSupport support;

  public SocketImplementation() {
    support = new PropertyChangeSupport(this);
  }

  @Override public String getUsername() throws IOException
  {
    Socket socket = new Socket("localhost", 2920);
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
    DataInputStream is = new DataInputStream(socket.getInputStream());

    // Sending
    String toSend = "Echo: " ;
    byte[] toSendBytes = toSend.getBytes();
    os.write(toSendBytes);

    // Receiving
    byte[] message = new byte[24000];
    is.read(message, 0, message.length); // read the message

    String received = new String(message, StandardCharsets.UTF_8);

    System.out.println("Server received: " + received);

    socket.close();

    return received;
  }

}
