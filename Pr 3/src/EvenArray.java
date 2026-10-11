import java.util.Random;
import java.util.Scanner;

public class EvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (n <= 0) {
            System.out.print("Введите размер массива (натуральное число): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Число должно быть больше нуля, повторите ввод");
                }
            } else {
                sc.next();
                System.out.println("Это не число, повторите ввод");
            }
        }

        Random rand = new Random();
        int[] a = new int[n];
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n + 1);
            if (a[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println("Исходный массив:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        if (evenCount == 0) {
            System.out.println("Чётных элементов нет");
        } else {
            int[] even = new int[evenCount];
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    even[k] = a[i];
                    k++;
                }
            }
            System.out.println("Чётные элементы:");
            for (int i = 0; i < even.length; i++) {
                System.out.print(even[i] + " ");
            }
            System.out.println();
        }
    }
}