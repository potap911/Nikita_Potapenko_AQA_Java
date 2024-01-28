package Shapes;

public class Triangle implements FigureCalc {

    private double a;
    private double b;
    private double c;
    private double h;
    private Color backgroundColor;
    private Color borderColor;

    public Triangle(double a, double b, double c, double h, Color backgroundColor, Color borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeterCalc() {
        return FigureCalc.super.perimeterCalc(a, b, c);
    }

    @Override
    public double squareCalc() {
        return FigureCalc.super.squareCalc(a, h) * 0.5;
    }

    @Override
    public String toString() {
        return "Shapes.Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", h=" + h +
                ", backgroundColor=" + backgroundColor +
                ", borderColor=" + borderColor +
                '}' + "\n" +
                String.format("Периметр треугольник: %.2f\n", perimeterCalc()) +
                String.format("Площадь треугольник: %.2f\n", squareCalc());
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getH() {
        return h;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
