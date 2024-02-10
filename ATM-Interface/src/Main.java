import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static Scanner sc;
    private  static  List<UserDetails> details;
    private  static  UserDetails currentUser;
    public static void main(String[] args)
    {
        sc = new Scanner(System.in);
        details = new ArrayList<>();
        _createUser();
        _menu("MAIN");
    }

    private static void _createUser() {
        UserDetails userDetails1 = new UserDetails("Akshaya","9999999999","888888888888","7777",1000.0,"SAVINGS");
        UserDetails userDetails2 = new UserDetails("Aswin","6666666666","555555555555","4444",10000.0,"CURRENT");
        UserDetails userDetails3 = new UserDetails("Snegha","3333333333","222222222222","1111",100000.0,"SAVINGS");
        details.add(userDetails1);
        details.add(userDetails2);
        details.add(userDetails3);
    }

    private static void _menu(String menuName) {
        switch (menuName)
        {
            case "MAIN":
                System.out.println("Welcome to ATM Service!");
                System.out.println("------------------------------------------");
                System.out.print("Enter your card number: ");
                String cardNumber =  sc.nextLine();
                int customerNo = _validateCard(cardNumber);
                if(customerNo!=-1) {
                    currentUser = details.get(customerNo);
                    System.out.println("Welcome " + currentUser.getName()+"...\n");
                    System.out.print("Enter 4 digit PIN: ");
                    String pin = sc.nextLine();
                    if(pin.length()==4 && pin.equals(currentUser.getPin()))
                    {
                        System.out.println("Login Success!!!\n");
                        System.out.println("Account Number : "+currentUser.getAccountNo());
                        System.out.println("Account Type : "+currentUser.getAccountType());
                        _menu("ATM");
                    }
                }
                else {
                    System.out.println("User not Found!");
                }
                break;
            case "ATM":
               ATM atm = new ATM(currentUser);
                break;
        }
    }

    private static int _validateCard(String cardNumber) {
        if(cardNumber.length()==12)
        {
            for(UserDetails user : details)
            {
                if(user.cardNumber.equals(cardNumber))
                {
                    return details.indexOf(user);
                }
            }
        }
        return -1;
    }
}