import java.util.Scanner;

public class dayFinder {
    public static void main(String[] args) {
        System.out.println("Enter your number:");
        Scanner input = new Scanner(System.in);
        int day = input.nextInt();
        switch (day) {
            case 1:System.out.println("Monday");
                break;
            case 2:System.out.println("Tuesday");
                break;
            case 3:System.out.println("Wednesday");
                break;
            case 4:System.out.println("Thursday");
                break;
            case 5:System.out.println("Friday");
                break;
            case 6:System.out.println("Saturday");
                break;
            case 7:System.out.println("Sunday");
                break;
        
            default:System.out.println("One Week Only Contain 7 Days.");
                break;
        }
        input.close();
    }
}
