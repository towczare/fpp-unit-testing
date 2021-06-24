package foo.bar;

public class Circle implements Figure{

    private int radius;
    private final double PI = 3.14;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }

    @Override
    public int circumference() {
        return 0;
    }
}
