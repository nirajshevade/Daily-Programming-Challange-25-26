import java.util.Scanner;

public class MergeTwoSortedArrays {

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    private static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = m + n;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            int i, j;

            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            for (j = (gap > m) ? gap - m : 0; i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter size of first array (m): ");
            int m = sc.nextInt();
            if (m < 0) throw new Exception("Size cannot be negative.");

            int[] arr1 = new int[m];
            System.out.println("Enter " + m + " sorted elements of first array:");
            for (int i = 0; i < m; i++) {
                arr1[i] = sc.nextInt();
            }

            System.out.print("Enter size of second array (n): ");
            int n = sc.nextInt();
            if (n < 0) throw new Exception("Size cannot be negative.");
            int[] arr2 = new int[n];
            System.out.println("Enter " + n + " sorted elements of second array:");
            for (int i = 0; i < n; i++) {
                arr2[i] = sc.nextInt();
            }

            merge(arr1, arr2, m, n);

            System.out.println("\nMerged Arrays:");
            System.out.print("arr1 = ");
            for (int i = 0; i < m; i++) {
                System.out.print(arr1[i] + " ");
            }
            System.out.print("\narr2 = ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr2[i] + " ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
