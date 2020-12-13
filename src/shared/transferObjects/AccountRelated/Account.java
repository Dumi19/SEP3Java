package shared.transferObjects.AccountRelated;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    public String username;
    public String password;
    public String email;
    public List<AccountAddress> AccountAddressList;
    public List<AccountBankInfo> AccountBankInfos;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
