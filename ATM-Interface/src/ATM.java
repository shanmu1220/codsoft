import java.util.List;
import java.util.Scanner;

public class ATM
{
    UserDetails userDetails;
    private Scanner sc;
    public ATM(UserDetails details)
    {
        sc = new Scanner(System.in);
        this.userDetails = details;
        _showMenu();
    }

    private void _showMenu() {
        System.out.println();
        System.out.println("Avilable Services...");
        System.out.println("------------------------------------------");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("------------------------------------------");
        System.out.print("Enter your Choice : ");
        int ch = sc.nextInt();
        switch (ch)
        {
            case 1:
                System.out.println("\nBalance Amount : "+ userDetails.getBalance());
                System.out.print("Enter Withdraw Amount : ");
                Double wAmount = sc.nextDouble();
                _withdraw(wAmount);
                break;
            case 2:
                System.out.print("Enter Deposit Amount : ");
                Double dAmount = sc.nextDouble();
                _deposit(dAmount);
                break;
            case 3:
                _checkBalance();
                break;
            case 4:
                System.out.println("Thank you... " + userDetails.getName());
                break;
            default:
                System.out.println("Enter valid Choice...");
                _showMenu();
        }
    }

    public void _withdraw(Double amount) {
        Double currBalance = userDetails.getBalance();
        if(amount<=currBalance)
        {
            currBalance -= amount;
            System.out.println("\nAmount withdraw successfully!!!");
            System.out.println("Collect your cash...");
            System.out.println("Available Balance : "+currBalance);
            userDetails.setBalance(currBalance);
            _showMenu();
        }
        else
        {
            System.out.println("Insufficient Balance!!!");
        }
    }
    public void _deposit(Double amount) {
        Double currBalance = userDetails.getBalance();
        if(amount>0)
        {
            currBalance+=amount;
            System.out.println("\nAmount deposited successfully!!!");
            System.out.println("Available Balance : "+currBalance);
            userDetails.setBalance(currBalance);
            _showMenu();
        }
    }
    public void _checkBalance() {
        Double currBalance = userDetails.getBalance();
        System.out.println("Available Balance : "+currBalance);
        _showMenu();
    }
}
