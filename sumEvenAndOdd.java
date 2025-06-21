import java.util.Scanner;

public class sumEvenAndOdd {

    public static void main(String[] args) {
        
        int number;
        int choice;
        int evenNum = 0;
        int oddNum = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Number: ");
        number = input.nextInt();

        do{
            System.out.print("Enter Your Number: ");
            number = input.nextInt();
            if (number % 2 == 0) {
                evenNum += number;  
            }else{
                oddNum +=number;
            }
            System.out.println("Do you want to continue press 1 Aur press 0 fro exit");
            choice = input.nextInt();
        }while(choice == 1);
            System.out.println("Sum of Even Number is " + evenNum);
            System.out.println("Sum of odd Number is " + oddNum);
            input.close();


        
    }
}