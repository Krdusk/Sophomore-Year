import java.util.Arrays;
import java.util.Scanner;

public class ArrayRdSrch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = {0, 10, 20, 30, 40, 50};
        int currentSize = numbers.length;

        while (true) {
            // Will show the current array.
            System.out.println("\nCurrent Array: " + Arrays.toString(numbers));
            System.out.print("Choose an action (Read / Search / Exit): ");
            String choice = input.next().toLowerCase();

            // Handle the user's choice.
            if (choice.equals("read")) {
                System.out.println("Reading array elements one by one:");
                for (int i = 0; i < currentSize; i++) {
                    System.out.println("Index " + i + " = " + numbers[i]);
                }

            } else if (choice.equals("search")) {
                System.out.print("Enter number to search: ");
                int toSearch = input.nextInt();
                boolean found = false;

                for (int i = 0; i < currentSize; i++) {
                    if (numbers[i] == toSearch) {
                        System.out.println("Number " + toSearch + " found at index " + i);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Number " + toSearch + " not found in the array.");
                }

            } else if (choice.equals("exit")) {
                System.out.println("Exiting the program . . . exit successfully.");
                break;

            } else {
                System.out.println("Invalid choice. Please choose read, search, or exit.");
            }
        }

        input.close();
    }
}