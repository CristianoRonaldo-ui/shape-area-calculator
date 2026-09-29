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

        System.out.println();
        System.out.println("--- Manual Tests ---");
        checkTest("Circle area with radius 1", new Circle(1.0).getArea(), Math.PI);
        checkTest("Rectangle perimeter 3x4", new Rectangle(3.0, 4.0).getPerimeter(), 14.0);

        Shape[] testShapes = { new Rectangle(2.0, 5.0), new Rectangle(1.0, 1.0) };
        checkTest("Total area of two rectangles", calculateTotalArea(testShapes), 11.0);
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

    public static void checkTest(String testName, double actual, double expected) {
        if (Math.abs(actual - expected) < 0.0001) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName
                    + " (expected " + expected + ", got " + actual + ")");
        }
    }
}