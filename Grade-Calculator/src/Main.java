import java.util.Scanner;

public class Main {
    private static Scanner sc;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        int[] marks = new int[5];
        for(int i=1;i<=marks.length;i++){
            System.out.print("Enter mark of Subject "+i+": ");
            marks[i-1]=sc.nextInt();
        }
        int sum=0;
        for (int val: marks) {
            sum+=val;
        }
        int avg =sum/marks.length;
        System.out.println("Total marks obtained = "+sum);
        System.out.println("Average Percentage = "+(avg)+"%");

        String grade = "";
        if(avg>95){
            grade="O";
        } else if (avg>90&&avg<=95){
            grade = "A";
        } else if (avg > 80 && avg <= 90) {
            grade="B";
        }
        else if (avg>60&&avg<=80){
            grade="C";
        }
        else {
            grade = "F";
        }
        System.out.println("Grade: "+grade);
    }
}