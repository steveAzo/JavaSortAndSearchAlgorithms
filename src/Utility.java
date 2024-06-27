import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    public static int[] readArrayFromUser() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        
        // Loop until a valid number of elements is entered
        while (n <= 0) {
            try {
                System.out.println("Enter the number of elements (positive integer):");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        int[] array = new int[n];
        System.out.println("Enter the elements one by one and hit enter after each element:");

        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    array[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
        return array;
    }
}
