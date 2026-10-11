import java.util.Scanner;

interface Convertable {
    double convert(double celsius);
}

class ToKelvin implements Convertable {
    public double convert(double celsius) {
        return celsius + 273.15;
    }
}

class ToFahrenheit implements Convertable {
    public double convert(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}

public class TemperatureApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Температура в градусах Цельсия: ");
        double c = sc.nextDouble();
        Convertable k = new ToKelvin();
        Convertable f = new ToFahrenheit();
        System.out.printf("Кельвин: %.2f%n", k.convert(c));
        System.out.printf("Фаренгейт: %.2f%n", f.convert(c));
    }
}