import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsDlt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = {0, 10, 20, 30, 40, 50};
        int currentSize = numbers.length;

        while (true) {
            // Will show the current array.
            System.out.println("\nCurrent Array: " + Arrays.toString(numbers));
            System.out.print("Choose an action (Insert / Delete / Exit): ");
            String choice = input.next().toLowerCase();

            // Handle the user's choice.
            if (choice.equals("insert")) {
                System.out.print("Enter number to insert: ");
                int numberToInsert = input.nextInt();

                System.out.print("Where to insert? (Front / End): ");
                String positionChoice = input.next().toLowerCase();

                int insertPosition;
                if (positionChoice.equals("front")) {
                    insertPosition = 0;
                } else if (positionChoice.equals("end")) {
                    insertPosition = currentSize;
                } else {
                    System.out.println("Invalid choice. Please type 'Front' or 'End'.");
                    continue;
                }

                int[] newArray = new int[currentSize + 1];
                int steps = 0;

                for (int i = 0, j = 0; i < newArray.length; i++) {
                    if (i == insertPosition) {
                        newArray[i] = numberToInsert;
                        steps++;
                    } else {
                        newArray[i] = numbers[j++];
                        steps++;
                    }
                }

                numbers = newArray;
                currentSize = numbers.length;

                System.out.println("Steps taken to insert: " + steps);
                System.out.println("Array after insertion: " + Arrays.toString(numbers));

            } else if (choice.equals("delete")) {
                if (currentSize == 0) {
                    System.out.println("Array is empty. Cannot delete.");
                    continue;
                }

                System.out.println("Current Array: " + Arrays.toString(numbers));
                System.out.print("Enter index to delete (0 to " + (currentSize - 1) + "): ");
                int deletePosition = input.nextInt();

                if (deletePosition < 0 || deletePosition >= currentSize) {
                    System.out.println("Invalid position.");
                    continue;
                }

                int[] newArray = new int[currentSize - 1];
                int steps = 0;

                for (int i = 0, j = 0; i < currentSize; i++) {
                    if (i != deletePosition) {
                        newArray[j++] = numbers[i];
                        steps++;
                    } else {
                        steps++;
                    }
                }

                numbers = newArray;
                currentSize = numbers.length;

                System.out.println("Steps taken to delete: " + steps);
                System.out.println("Array after deletion: " + Arrays.toString(numbers));

            } else if (choice.equals("exit")) {
                System.out.println("Exiting the program . . . ended successfully.");
                break;

            } else {
                System.out.println("Invalid choice. Please choose insert, delete, or exit.");
            }
        }

        input.close();
    }
}