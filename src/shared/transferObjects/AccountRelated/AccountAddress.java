package shared.transferObjects.AccountRelated;

import shared.transferObjects.Address;

import java.io.Serializable;

public class AccountAddress implements Serializable{
    public String username;
    public Account account;
    public String street;
    public Address address;
}
