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

        Shape largest = findLargestShape(shapes);
        System.out.println("Largest shape: " + largest.getName()
                + " (" + String.format("%.2f", largest.getArea()) + ")");

        double totalArea = calculateTotalArea(shapes);
        System.out.println("Total area: " + String.format("%.2f", totalArea));
    }

    public static Shape findLargestShape(Shape[] shapes) {
        Shape largest = shapes[0];
        for (Shape shape : shapes) {
            if (shape.getArea() > largest.getArea()) {
                largest = shape;
            }
        }
        return largest;
    }

    public static double calculateTotalArea(Shape[] shapes) {
        double total = 0.0;
        for (Shape shape : shapes) {
            total += shape.getArea();
        }
        return total;
    }
}