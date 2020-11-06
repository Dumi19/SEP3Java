package client.core;

import client.view.adminLogin.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory vmf;
  private Stage mainStage;

  public ViewHandler(ViewModelFactory vmf)
  {
    mainStage = new Stage();
    this.vmf = vmf;
  }

  public void start()
  {
    openLoginView();
    mainStage.show();
  }

  private void openLoginView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/adminLogin/Login.fxml"));
    try
    {
      Parent root = loader.load();
      LoginController ctrl = loader.getController();
      ctrl.init(vmf.getLoginVm(), this);
      mainStage.setTitle("Login");
      Scene loginScene = new Scene(root);
      mainStage.setScene(loginScene);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
