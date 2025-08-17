import java.util.Scanner;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter size of array (n+1): ");
            int size = sc.nextInt();

            if (size < 2) {
                System.out.println("Error: Size must be at least 2.");
                return;
            }

            int[] arr = new int[size];
            System.out.println("Enter array elements:");

            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] < 1 || arr[i] > size - 1) {
                    System.out.println("Error: Array elements must be in range [1, " + (size - 1) + "]");
                    return;
                }
            }

            int duplicate = findDuplicate(arr);
            System.out.println("Duplicate number: " + duplicate);

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        }
    }

    static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        // Phase 1: Detect cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance (duplicate number)
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
