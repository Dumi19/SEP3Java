package client.view.adminLogin;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController
{
  @FXML
  public Label username;

  private LoginVM loginVM;
  private ViewHandler viewHandler;

  public void init(LoginVM loginVm, ViewHandler viewHandler)
  {
    this.loginVM = loginVm;
    this.viewHandler = viewHandler;
    username.textProperty().bindBidirectional(loginVm.usernameProperty());
  }

  public void getUsername(ActionEvent actionEvent)
  {
    loginVM.getUsername();
  }
}
