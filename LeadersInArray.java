import java.util.Scanner;

public class LeadersInArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter size of array (n): ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Error: Array size must be greater than 0.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " array elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] leaders = new int[n];
            int count = 0;

            int maxRight = arr[n - 1];
            leaders[count++] = maxRight;

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > maxRight) {
                    leaders[count++] = arr[i];
                    maxRight = arr[i];
                }
            }

            System.out.print("Leaders: [");
            for (int i = count - 1; i >= 0; i--) {
                System.out.print(leaders[i]);
                if (i != 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}
