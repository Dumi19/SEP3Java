package server.socketsToDatabase;

import client.model.Json;

import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketImplementation implements SocketInterface
{
  private PropertyChangeSupport support;

  public SocketImplementation() {
    support = new PropertyChangeSupport(this);
  }

  @Override public String getObject(String toFetch) throws IOException
  {
    Socket socket = new Socket("localhost", 2921);
    DataInputStream is = new DataInputStream(socket.getInputStream());
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());

    String received = "";
    sendMessage(toFetch,os);
    byte[] message = new byte[24000];
    is.read(message, 0, message.length); // read the message
    received = new String(message, StandardCharsets.UTF_8);
    System.out.println(received);
    socket.close();
    return received;
  }

  @Override
  public String sendObject(Object object, String toDo) throws IOException {
    Socket socket = new Socket("localhost", 2921);
    DataInputStream is = new DataInputStream(socket.getInputStream());
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());

    //Asking if its ready
    String rcv = "";
    sendMessage(toDo,os);
    byte[] message = new byte[24000];
    is.read(message,0,message.length);
    rcv = new String(message,StandardCharsets.UTF_8);

    //Answer from server if ready
    if(rcv.contains("Ready")){
      //Send object to server, receiving an "object updated/removed/Added" message
      String toSend = Json.convertObjectToString(object);
      sendMessage(toSend,os);
      byte[] message2 = new byte[24000];
      is.read(message2,0,message2.length);
      rcv = new String(message2,StandardCharsets.UTF_8);
      socket.close();
      return rcv;
    }else{
      socket.close();
      return "Server connection failed";
    }
  }


  private void sendMessage(String toSend, DataOutputStream os) throws IOException{
    byte[] toSendBytes = toSend.getBytes();
    System.out.println("Sending: " + toSend + " to serve");
    os.write(toSendBytes);
  }
}
