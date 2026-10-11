interface MathCalculable {
    double PI = 3.14159265358979;

    double power(double base, int exp);

    double abs(double re, double im);
}

class MathFunc implements MathCalculable {
    public double power(double base, int exp) {
        if (exp < 0) {
            return 1 / power(base, -exp);
        }
        double result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public double abs(double re, double im) {
        return Math.sqrt(re * re + im * im);
    }

    public double circleLength(double r) {
        return 2 * PI * r;
    }
}

public class MathTest {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc();
        System.out.println("2 в степени 10 = " + mc1.power(2, 10));
        System.out.println("2 в степени -2 = " + mc1.power(2, -2));
        System.out.println("Модуль 3+4i = " + mc1.abs(3, 4));
        System.out.println("PI = " + MathCalculable.PI);

        MathFunc f = new MathFunc();
        System.out.println("Длина окружности r=5: " + f.circleLength(5));
    }
}