import java.util.Scanner;

public class bill {
    public static void main(String[] args) {
        System.out.println("Welcome to bill calculator.");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the price of first item: ");
        int item1 = input.nextInt();
        System.out.print("Enter the price of second item: ");
        int item2 = input.nextInt();
        System.out.print("Enter the price of third item: ");
        int item3 = input.nextInt();
        int sum =( item1 + item2 + item3);
        int gst = ( sum * 18)/100;
        System.out.println("Total gst apply is : " + gst);
        int total = sum + gst;
        System.out.println("Total Amount is : " + total);
        input.close();



    }
    
}
