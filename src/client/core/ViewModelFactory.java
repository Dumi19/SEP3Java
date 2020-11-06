package client.core;

import client.view.adminLogin.LoginVM;

public class ViewModelFactory
{
  private LoginVM loginVm;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf){
    this.mf = mf;
  }

  public LoginVM getLoginVm(){
    if(loginVm == null){
      loginVm = new LoginVM(mf.getModel());
    }
    return loginVm;
  }
}
