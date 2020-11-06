package client.view.adminLogin;

import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginVM
{
  private StringProperty username;
  private Model model;

  public LoginVM(Model model)
  {
    this.model = model;
    username = new SimpleStringProperty();
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public void getUsername()
  {
    String result = model.getUsername();
    Platform.runLater(()->{
      username.set(result);
    });
  }
}
