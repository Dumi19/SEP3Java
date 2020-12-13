package shared.transferObjects;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    public String Street;
    public String City;
    public int ZipCode;

    public Address(){}

    public Address(String street, String city, int zipCode){
        this.Street = street;
        this.City = city;
        this.ZipCode = zipCode;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public void setZipCode(int zipCode) {
        this.ZipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Address){
            Address temp = (Address)o;
            if(temp.City.equals(this.City) && temp.ZipCode == this.ZipCode && temp.Street.equals(this.Street)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
