import java.util.Scanner;

public class leapYear {
    public static void main(String[] args) {
        System.out.println("Welcome to leap year checker.");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if ((year%400==0) || (year%100 != 0 && year%4==0)) {
            System.out.println("Is is  A leap Year");   
        }else{
            System.out.println("Its Is not A leap year.");
        }
        input.close();

    }
}
