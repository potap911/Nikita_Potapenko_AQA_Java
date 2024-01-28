package Shapes;

public class Rectangle implements FigureCalc {

    private double a;
    private double b;
    private double c;
    private double d;

    private Color backgroundColor;
    private Color borderColor;


    public Rectangle(double a, double b, double c, double d, Color backgroundColor, Color borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeterCalc() {
        return FigureCalc.super.perimeterCalc(a, b, c, d);
    }

    @Override
    public double squareCalc() {
        return FigureCalc.super.squareCalc(a, b);
    }

    @Override
    public String toString() {
        return "Shapes.Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", backgroundColor=" + backgroundColor +
                ", borderColor=" + borderColor +
                '}' + "\n" +
                String.format("Периметр прямоугольника: %.2f\n", perimeterCalc()) +
                String.format("Площадь прямоугольника: %.2f\n", squareCalc());
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

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
}
