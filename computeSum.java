import java.util.Scanner;

public class computeSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your NUmber: ");
        int digit = input.nextInt();
        System.out.println(Compute(digit));
        input.close();

    }
    
    public static int Compute(int number){
        //int sum =0;
        int last = 0;
        while (number >0) {
            int remainder = number % 10;
            last = last + remainder;
            number /=10;
        }
        return last;
    }
}
