import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("This software gives you the option to choose the type of searching or sorting algorithm to work with");
                System.out.println("Choose an operation:");
                System.out.println("Choose 1 for SEARCH:");
                System.out.println("Choose 2 for SORT:");
                System.out.println("Choose 0 to EXIT:");

                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                }

                if (choice == 1) {
                    handleSearch(scanner);
                } else if (choice == 2) {
                    handleSort(scanner);
                } else {
                    System.out.println("Invalid choice. Please enter 1 for SEARCH, 2 for SORT, or 0 to EXIT.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void handleSearch(Scanner scanner) {
        try {
            System.out.println("Choose a search algorithm: 1) Linear Search 2) Binary Search 3) Jump Search 4) Interpolation Search");
            int choice = scanner.nextInt();
            SearchAlgorithm searchAlgorithm;

            switch (choice) {
                case 1:
                    searchAlgorithm = new LinearSearch();
                    break;
                case 2:
                    searchAlgorithm = new BinarySearch();
                    break;
                case 3:
                    searchAlgorithm = new JumpSearch();
                    break;
                case 4:
                    searchAlgorithm = new InterpolationSearch();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                    return;
            }

            int[] array = Utility.readArrayFromUser();
            System.out.println("Enter the target element to search for:");
            int target = scanner.nextInt();

            long startTime = System.nanoTime();
            int result = searchAlgorithm.search(array, target);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            if (result == -1) {
                System.out.println("Element not found.");
            } else {
                System.out.println("Element found at index: " + result);
            }
            System.out.println("Time taken: " + duration + " nanoseconds");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear the invalid input
        }
    }

    private static void handleSort(Scanner scanner) {
        try {
            System.out.println("Choose a sorting algorithm: 1) Bubble Sort 2) Quick Sort 3) Merge Sort 4) Insertion Sort");
            int choice = scanner.nextInt();
            SortAlgorithm sortAlgorithm;

            switch (choice) {
                case 1:
                    sortAlgorithm = new BubbleSort();
                    break;
                case 2:
                    sortAlgorithm = new QuickSort();
                    break;
                case 3:
                    sortAlgorithm = new MergeSort();
                    break;
                case 4:
                    sortAlgorithm = new InsertionSort();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
                    return;
            }

            int[] array = Utility.readArrayFromUser();

            long startTime = System.nanoTime();
            sortAlgorithm.sort(array);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Sorted array:");
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println("\nTime taken: " + duration + " nanoseconds");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear the invalid input
        }
    }
}
