# Shape Area Calculator

A small Java program that uses an **abstract `Shape` class** and **polymorphism** to calculate the area and perimeter of different shapes (circles, rectangles and triangles) through one shared interface

## Features

- Abstract base class `Shape` that cannot be instantiated and forces every subclass to implement `getArea()` and `getPerimeter()`
- Three concrete subclasses: `Circle`, `Rectangle` and `Triangle` (area via Heron's formula)
- A single `Shape[]` array holding different shape types, processed with one polymorphic loop
- `findLargestShape()` returns the shape with the largest area
- `calculateTotalArea()` sums the area of all shapes
- Manual PASS/FAIL tests that compare `double` values with a tolerance instead of `==`

## Project Structure

```
shape-area-calculator/
├── .gitignore
├── README.md
└── src/
    ├── Shape.java            # abstract base class
    ├── Circle.java           # Circle extends Shape
    ├── Rectangle.java        # Rectangle extends Shape
    ├──ShapeCalculator.java  # main program, helper methods, tests
    └──  Triangle.java         # Triangle extends Shape (Heron's formula)
```
## How to Run

Requires Java (JDK 8 or newer)

```bash
# from the project root
javac src/*.java
java -cp src ShapeCalculator
```

## Sample Output

```
Circle | Area: 12.57 | Perimeter: 12.57
Rectangle | Area: 12.00 | Perimeter: 14.00
Circle | Area: 7.07 | Perimeter: 9.42
Triangle | Area: 6.00 | Perimeter: 12.00
Largest shape: Circle (12.57)
Total area: 37.63

--- Manual Tests ---
PASS: Circle area with radius 1
PASS: Rectangle perimeter 3x4
PASS: Triangle area 3-4-5 (Heron)
PASS: Total area of two rectangles
```
## Complexity Analysis

Let *n* be the number of shapes in the array

| Operation | Time | Space | Notes |
|---|---|---|---|
| `getArea()` / `getPerimeter()` | O(1) | O(1) | a fixed formula per shape |
| Polymorphic print loop | O(n) | O(1) | visits each shape once |
| `findLargestShape()` | O(n) | O(1) | one pass, keeps a single reference to the current largest |
| `calculateTotalArea()` | O(n) | O(1) | one pass, keeps a running total |

## What I Learned

- **Abstract classes:** `abstract` on a class means it cannot be created with `new`. `abstract` on a method means it has no body, and every concrete subclass *must* override it. I tested this on purpose: removing `getPerimeter()` from `Circle` made `javac` fail with *"Circle is not abstract and does not override abstract method getPerimeter() in Shape"*. The mistake is caught at compile time instead of at runtime.
- **Polymorphism / dynamic dispatch:** a `Shape[]` array can hold both `Circle` and `Rectangle` objects. When I call `shape.getArea()`, Java picks the correct subclass method at runtime, so one loop handles every shape type without any `if/else` on the type
- **`super(...)` in constructors:** each subclass passes its own name up to the `Shape` constructor. It must be the first line of the constructor.
- **Comparing `double` values:** floating-point numbers are not stored exactly (for example, `0.1 + 0.2` gives `0.30000000000000004`), so my tests check `Math.abs(actual - expected) < 0.0001` instead of using `==`
- **Round at the end, not in the middle:** the rounded areas add up to 31.64, but the real total printed is 31.63, because Java adds the unrounded values and only formats the final result.
- **Open/Closed Principle:** adding `Triangle` only required a new class and one new array entry. The print loop, `findLargestShape()` and `calculateTotalArea()` did not change at all, because they only depend on the abstract `Shape` type. The code is open for extension but closed for modification

## Future Improvements

- Handle an empty array in `findLargestShape()`, which currently throws `ArrayIndexOutOfBoundsException`
- Validate input so a radius, width or length cannot be zero or negative
- Replace the manual tests with JUnit
- Reject side lengths that cannot form a triangle (e.g. 1, 2, 10), which currently make Heron's formula return `NaN`
