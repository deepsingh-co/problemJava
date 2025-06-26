import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Number: ");
        int palindrome = input.nextInt();
        if (isPlindrome(palindrome)) {
            System.out.println("Number: " + palindrome + " is a palindrome ");
            
        }else{
            System.out.println("NUmber is  : " + palindrome + " is not a palindrome") ;
        }
        input.close();
        
    }
    public static boolean isPlindrome( int number){
        int palindrome = number;
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome %10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome/10;
            
        }
        if (number == reverse) {
            return true;
            
        }
        return false;
        

    }

    
}