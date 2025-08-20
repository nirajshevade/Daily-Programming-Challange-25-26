import java.util.Scanner;

public class ZeroSumSubarrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter size of array (n): ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Array size must be positive.");
                return;
            }

            int[] arr = new int[n];

            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            findZeroSumSubarrays(arr, n);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter integers only.");
        } finally {
            sc.close();
        }
    }

    public static void findZeroSumSubarrays(int[] arr, int n) {
        boolean found = false;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum == 0) {
                    found = true;
                    System.out.println("(" + start + ", " + end + ")");
                }
            }
        }
        if (!found) {
            System.out.println("[]  No subarray with zero sum found.");
        }
    }
}
