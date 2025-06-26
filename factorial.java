import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        System.out.println("Welcome To factorial finder");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int fact = 1;

        int number = input.nextInt();
        for(int i = 1;i<=number;i++){
            fact *= i;
           


        }
        System.out.println(fact);
        input.close();

    }
    
}
