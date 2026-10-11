class Ball {
    private double x = 0.0;
    private double y = 0.0;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ball() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double xDisp, double yDisp) {
        x += xDisp;
        y += yDisp;
    }

    public String toString() {
        return "Ball (" + x + "," + y + ")";
    }
}

public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball(1.5, 2.5);
        System.out.println(b1);
        Ball b2 = new Ball();
        System.out.println(b2);
        b2.setXY(10, 20);
        b2.move(3, -5);
        System.out.println(b2);
    }
}