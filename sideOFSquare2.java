import java.util.Scanner;

public class sideOFSquare2 {
    public static void main(String[] args) {
        System.out.println("Welcome to Area of square.");
        Scanner input = new Scanner(System.in);
        System.out.println("IMP: SIDE OF ALL SIDE IS SAME.");
        System.out.println("Enter the Side of Square");
        int side = input.nextInt();
        int area = side * side;
        System.out.println("Area of Square is:" + area);
        input.close();
    }
}
