package transferobjects;

import java.io.Serializable;

public class Address implements Serializable {
    public String street;
    public String streetNUmber;
    public String city;
    public int zipCode;

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNUmber() {
        return streetNUmber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNUmber(String streetNUmber) {
        this.streetNUmber = streetNUmber;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
