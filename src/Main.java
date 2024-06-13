import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an operation: 1) Search 2) Sort");
        int choice = scanner.nextInt();

        if (choice == 1) {
            handleSearch(scanner);
        } else if (choice == 2) {
            handleSort(scanner);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void handleSearch(Scanner scanner) {
        System.out.println("Choose a search algorithm: 1) Linear Search 2) Binary Search 3) Exponential Search 4) Interpolation Search");
        int choice = scanner.nextInt();
        SearchAlgorithm searchAlgorithm;

        if (choice == 1) {
            searchAlgorithm = new LinearSearch();
        } else if (choice == 2) {
            searchAlgorithm = new BinarySearch();
        } else if (choice == 3) {
            searchAlgorithm = new ExponentialSearch();
        } else if (choice == 4) {
            searchAlgorithm = new InterpolationSearch();
        } else {
            System.out.println("Invalid choice.");
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
    }

    private static void handleSort(Scanner scanner) {
        System.out.println("Choose a sorting algorithm: 1) Bubble Sort 2) Quick Sort 3) Insertion Sort 4) Merge Sort");
        int choice = scanner.nextInt();
        SortAlgorithm sortAlgorithm;

        if (choice == 1) {
            sortAlgorithm = new BubbleSort();
        } else if (choice == 2) {
            sortAlgorithm = new QuickSort();
        } else if (choice == 3) {
            sortAlgorithm = new InsertionSort();
        } else if (choice == 4) {
            sortAlgorithm = new MergeSort();
        } else {
            System.out.println("Invalid choice.");
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
    }
}