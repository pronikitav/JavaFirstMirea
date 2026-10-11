import java.util.Random;

public class Increasing {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(90) + 10;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        boolean increasing = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) {
                increasing = false;
            }
        }
        if (increasing) {
            System.out.println("Массив строго возрастающая последовательность");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }
    }
}