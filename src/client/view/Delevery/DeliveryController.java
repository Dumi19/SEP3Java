package client.view.Delevery;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;

public class DeliveryController implements ViewController {

    private ViewHandler vh;
    private DeliveryVM deliveryVM;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        deliveryVM = vmf.getDeliveryVM();
    }

    public void onBack(){
        vh.openNavigationView();
    }
}
