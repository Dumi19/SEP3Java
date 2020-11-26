package transferobjects;

import java.io.Serializable;

public class Amount implements Serializable {
    public double number;
    public String unitType;

    public Amount(){}

    public Amount(double number, String unitType){
        this.number = number;
        this.unitType = unitType;
    }

    public double getNumber() {
        return number;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
