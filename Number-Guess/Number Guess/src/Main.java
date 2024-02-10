import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static int score = 0;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcomme to Number Guess Game...");
        main_Menu();
    }

    private static void main_Menu() {
        System.out.println("");
        System.out.println("   Main Menu   ");
        System.out.println("1.Start");
        System.out.println("2.Exit");
        choice("MAIN");
    }

    private static void choice(String val) {
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        switch (ch){
            case 1:
                int num = (int) (Math.random()*100+1);
                System.out.println("Find the number with 3 attempts...");
                System.out.println("The Number is in between 1 and 100");
                start_Game(num);
                break;
            case 2:
                if(val=="MAIN"){
                    System.out.println("Thank You...");
                }
                else{
                    main_Menu();
                }
                break;
            default:
                System.out.println("Invalid input...");
                if(val=="MAIN"){
                    choice("Main");
                }
                else{
                    choice("NXT");
                }
        }
    }
    static int attempt = 1;
    private static void start_Game(int num) {
        if(attempt<4){
            System.out.println("Number of attempt left : "+(4-attempt));
            System.out.print("Attempt "+attempt+" : ");
            int a_num = sc.nextInt();
            compare_Res(a_num,num);
        }
    }

    private static void compare_Res(int aNum, int num) {
        if(aNum<num){
            if (attempt!=3){
                System.out.println("The number XXX is greater than "+aNum);
                attempt++;
                start_Game(num);
            }
            else {
                System.out.println("Oops!!!, Better luck next time...");
                System.out.println("The number is : "+num);
                System.out.println("Your Score: "+ score);
                main_Menu();
            }
        } else if (aNum==num) {
            System.out.println("Hurrah!!!, You found the number...");
            if(attempt==1)
                score+=100;
            else if (attempt==2)
                score+=75;
            else
                score+=50;
            System.out.println("Your score: "+score );
            attempt=1;
            nxt_Menu();

        }
       else {
            if (attempt!=3){
                System.out.println("The number XXX is lesser than "+aNum);
                attempt++;
                start_Game(num);
            }
            else {
                System.out.println("Oops!!!, Better luck next time...");
                System.out.println("The number is : "+num);
                System.out.println("Your Score: "+ score);
                main_Menu();
            }
        }
    }

    private static void nxt_Menu() {
        System.out.println("");
        System.out.println("1.Next Round");
        System.out.println("2.Main Menu");
        choice("NXT");
    }
}