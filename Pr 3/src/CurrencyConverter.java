import java.util.Scanner;

public class CurrencyConverter {
    private static final String[] names = {"RUB", "USD", "EUR"};
    private static final double[] inRub = {1.0, 90.0, 98.0};

    public static double convert(double amount, int from, int to) {
        double rub = amount * inRub[from];
        return rub / inRub[to];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Сумма: ");
        double amount = sc.nextDouble();
        System.out.println("Из какой валюты: 0 - RUB, 1 - USD, 2 - EUR");
        int from = sc.nextInt();
        System.out.println("В какую валюту: 0 - RUB, 1 - USD, 2 - EUR");
        int to = sc.nextInt();
        double result = convert(amount, from, to);
        System.out.printf("%.2f %s = %.2f %s%n", amount, names[from], result, names[to]);
    }
}