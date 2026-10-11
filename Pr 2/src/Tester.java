class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Circle {
    private Point center;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle: центр " + center + ", радиус " + radius;
    }
}

public class Tester {
    private Circle[] circles = new Circle[10];
    private int count = 0;

    public void add(Circle c) {
        if (count < circles.length) {
            circles[count] = c;
            count++;
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(circles[i]);
        }
    }

    public static void main(String[] args) {
        Tester t = new Tester();
        t.add(new Circle(0, 0, 5));
        t.add(new Circle(2, 3, 1.5));
        t.add(new Circle(-1, 4, 10));
        t.print();
    }
}