import java.util.Arrays;
import java.util.Random;

public class RandomArrays {
    public static void main(String[] args) {
        double[] a = new double[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random() * 100;
        }
        System.out.println("Math.random до сортировки:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("После сортировки:");
        System.out.println(Arrays.toString(a));

        Random rand = new Random();
        double[] b = new double[5];
        for (int i = 0; i < b.length; i++) {
            b[i] = rand.nextDouble() * 100;
        }
        System.out.println("Random до сортировки:");
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println("После сортировки:");
        System.out.println(Arrays.toString(b));
    }
}