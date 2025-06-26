import java.util.Scanner;

public class table {
    public static void main(String[] args) {
        System.out.println("Welcome to table maker");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number you want to learn: ");
        int num = input.nextInt();
        int value = 10;

        for(int i= 1;i<=value ; i++){

        
        System.out.println(num + " x " + i + " = " + (i*num));
        }
        input.close();
    }
    
}
