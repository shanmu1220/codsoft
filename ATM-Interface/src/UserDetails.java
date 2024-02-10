import java.util.ArrayList;

public class UserDetails
{
    String name,accountNo,cardNumber,pin,accountType;
    Double balance;

    public UserDetails(String name, String accountNo, String cardNumber, String pin, Double balance,String accountType) {
        this.name = name;
        this.accountNo = accountNo;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.accountType = accountType;
    }

    public UserDetails()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
