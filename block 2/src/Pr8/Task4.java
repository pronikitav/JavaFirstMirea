import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    static long[][] memo;

    static long ways(int len, int sum) {
        if (sum < 0 || sum > 9 * len) {
            return 0;
        }
        if (len == 0) {
            return 1;
        }
        if (memo[len][sum] != -1) {
            return memo[len][sum];
        }
        long result = 0;
        for (int d = 0; d <= 9; d++) {
            result += ways(len - 1, sum - d);
        }
        memo[len][sum] = result;
        return result;
    }

    static long count(int k, int s) {
        long total = 0;
        for (int d = 1; d <= 9; d++) {
            total += ways(k - 1, s - d);
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("k = ");
        int k = sc.nextInt();
        System.out.print("s = ");
        int s = sc.nextInt();
        memo = new long[k + 1][s + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(count(k, s));
    }
}