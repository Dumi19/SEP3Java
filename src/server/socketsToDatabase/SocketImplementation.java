package server.socketsToDatabase;

import shared.Json;

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
    Socket socket = new Socket("localhost", 2920);
    DataInputStream is = new DataInputStream(socket.getInputStream());
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());

    String received = "";
    sendMessage(toFetch,os);
    byte[] message = new byte[24000];
    is.read(message, 0, message.length); // read the message
    received = new String(message, StandardCharsets.UTF_8);

    socket.close();
    return received;
  }

  @Override
  public String addObject(Object object, String toAdd) throws IOException {
    Socket socket = new Socket("localhost", 2920);
    DataInputStream is = new DataInputStream(socket.getInputStream());
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());

    //Asking server if its ready
    String rcv = "";
    sendMessage(toAdd,os);
    byte[] message = new byte[24000];
    is.read(message, 0, message.length);
    rcv = new String(message,StandardCharsets.UTF_8);

    //Answer from server if ready
    if(rcv.contains("ready")){
      System.out.println("Server ready");
      //Send object to server, receiving an "object added" message
      System.out.println("trying to convert");
      String toSend = Json.convertObjectToString(object);
      sendMessage(toSend,os);
      byte[] message2 = new byte[24000];
      is.read(message2, 0, message2.length);
      rcv = new String(message2,StandardCharsets.UTF_8);
      socket.close();
      return rcv;
    }else{
      socket.close();
      return "Server connection failed";
    }
  }

  @Override
  public String removeObject(Object object, String toRemove)throws IOException {
    Socket socket = new Socket("localhost", 2920);
    DataInputStream is = new DataInputStream(socket.getInputStream());
    DataOutputStream os = new DataOutputStream(socket.getOutputStream());

    //Asking if its ready
    String rcv = "";
    sendMessage(toRemove,os);
    byte[] message = new byte[24000];
    is.read(message, 0, message.length);
    rcv = new String(message,StandardCharsets.UTF_8);

    //Answer from server if ready
    if(rcv.contains("ready")){
      //Send object to server, receiving an "object added" message
      String toSend = Json.convertObjectToString(object);
      System.out.println("\n" + toSend + "\n \nTo Server \n");
      sendMessage(toSend,os);
      byte[] message2 = new byte[24000];
      is.read(message2, 0, message2.length);
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
