package shared.transferObjects.AccountRelated;

import shared.transferObjects.BankInfo;

import java.io.Serializable;

public class AccountBankInfo implements Serializable{
    public String username;
    public Account account;
    public long cardNumber;
    public BankInfo bankInfo;

    public long getCardNumber() {
        return cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }
}
