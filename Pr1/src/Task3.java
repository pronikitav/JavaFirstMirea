public class Task3 {
    public static void main(String[] args) {
        int[] a = {4, 8, 15, 16, 23, 42};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        double avg = (double) sum / a.length;
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + avg);
    }
}