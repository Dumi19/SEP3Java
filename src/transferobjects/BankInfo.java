package transferobjects;

import transferobjects.AccountRelated.AccountBankInfo;

import java.util.List;

public class BankInfo {
    public long cardNumber;
    public String cardHolder;
    public List<AccountBankInfo> accountBankInfoList;

    public List<AccountBankInfo> getAccountBankInfoList() {
        return accountBankInfoList;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setAccountBankInfoList(List<AccountBankInfo> accountBankInfoList) {
        this.accountBankInfoList = accountBankInfoList;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
