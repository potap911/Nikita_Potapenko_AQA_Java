public interface FigureCalc {

    double perimeterCalc();
    double squareCalc();
    default double perimeterCalc(double a, double b, double c, double d) {
        return a + b + c + d;
    }
    default double perimeterCalc(double a, double b, double c) {
        return a + b + c;
    }
    default double perimeterCalc(double r) {
        return 2 * Math.PI * r;
    }

    default double squareCalc(double a, double h) {
        return a * h;
    }

    default double squareCalc(double r) {
        return Math.PI * Math.pow(r, 2);
    }


}
