package client.view;

import client.core.ViewHandler;
import client.core.ViewModelFactory;

public interface ViewController {
    public void init(ViewHandler vh, ViewModelFactory vmf);
}
