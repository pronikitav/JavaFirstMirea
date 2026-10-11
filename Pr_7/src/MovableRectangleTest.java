interface Movable {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();
}

class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void moveUp() {
        y -= ySpeed;
    }

    public void moveDown() {
        y += ySpeed;
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }
}

class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public boolean SpeedTest() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    public String toString() {
        return "Прямоугольник: верхняя левая " + topLeft + ", нижняя правая " + bottomRight;
    }

    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }
}

public class MovableRectangleTest {
    public static void main(String[] args) {
        MovableRectangle r1 = new MovableRectangle(0, 0, 10, 5, 2, 3);
        System.out.println(r1);
        System.out.println("Скорости одинаковые: " + r1.SpeedTest());
        r1.moveRight();
        r1.moveDown();
        System.out.println(r1);

        MovablePoint p1 = new MovablePoint(1, 1, 1, 1);
        MovablePoint p2 = new MovablePoint(8, 6, 5, 5);
        MovableRectangle r2 = new MovableRectangle(p1, p2);
        System.out.println(r2);
        System.out.println("Скорости одинаковые: " + r2.SpeedTest());
    }
}