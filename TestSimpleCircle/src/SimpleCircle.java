// Define the circle class with two constructors
class SimpleCircle {
    double radius;

    // class SimpleCircle
    // data field
    /** Construct a circle with radius 1 */
    SimpleCircle() {
        radius = 1;
    }

    // no-arg constructor
    /** Construct a circle with a specified radius */
    SimpleCircle(double newRadius) {
        radius = newRadius;
    }

    // second constructor
    /** Return the area of this circle */
    double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return the perimeter of this circle */
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /** Set a new radius for this circle */
    void setRadius(double newRadius) {
        radius = newRadius;
    }
}