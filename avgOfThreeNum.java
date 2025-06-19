import java.util.Scanner;

public class avgOfThreeNum {

    public static void main(String[] args) {
        System.out.println("Welcome to sum of three number.");
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = input.nextInt();
        int avg = (num1 + num2 + num3)/3;
        System.out.println("Average of three number is :" + avg);
        input.close();
    }
}