class Circlee {
    private double radius;

    public Circlee(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public int compare(Circlee other) {
        return Double.compare(radius, other.radius);
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circlee c1 = new Circlee(3);
        Circlee c2 = new Circlee(5);
        System.out.printf("Площадь c1: %.2f%n", c1.getArea());
        System.out.printf("Длина c1: %.2f%n", c1.getLength());
        int result = c1.compare(c2);
        if (result < 0) {
            System.out.println("c1 меньше c2");
        } else if (result > 0) {
            System.out.println("c1 больше c2");
        } else {
            System.out.println("Окружности равны");
        }
        c1.setRadius(5);
        System.out.println(c1.compare(c2));
    }
}
