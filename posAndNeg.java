import java.util.Scanner;

public class posAndNeg {

    public static void main(String[] args) {
        System.out.println("Welcome to number Checker.");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        if (num1>0) {
            System.out.println("It is positive");  
        }else{
            System.out.println("It is negative");
        }
        input.close();
    }
}