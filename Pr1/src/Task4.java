import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько чисел: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        int sum1 = 0;
        int j = 0;
        while (j < n) {
            sum1 += a[j];
            j++;
        }

        int sum2 = 0;
        int k = 0;
        do {
            sum2 += a[k];
            k++;
        } while (k < n);

        int max = a[0];
        int min = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        System.out.println("Сумма (while): " + sum1);
        System.out.println("Сумма (do while): " + sum2);
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
    }
}