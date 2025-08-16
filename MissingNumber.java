import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the array (including missing one): ");
        int n = sc.nextInt();

        int[] arr = new int[n-1];
        System.out.println("Enter " + (n-1) + " elements of the array:");

        boolean[] seen = new boolean[n+1];
        boolean invalid = false;

        for (int i = 0; i < n-1; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] < 1 || arr[i] > n) {
                invalid = true;
            }
            if (seen[arr[i]]) {
                invalid = true;
            }
            seen[arr[i]] = true;
        }

        if (invalid) {
            System.out.println("Invalid input: numbers must be distinct and within range 1.." + n);
            return;
        }

        System.out.println("Initial input array:");
        for (int i = 0; i < n-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        long total = (long)n * (n + 1) / 2;
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum += arr[i];
        }

        System.out.println("Missing element: " + (total - sum));
        sc.close();
    }
}
