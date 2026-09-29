public class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0);
        shapes[1] = new Rectangle(3.0, 4.0);
        shapes[2] = new Circle(1.5);

        for (Shape shape : shapes) {
            System.out.println(shape.getName()
                + " | Area: " + String.format("%.2f", shape.getArea())
                + " | Perimeter: " + String.format("%.2f", shape.getPerimeter()));
        }
    }
} 