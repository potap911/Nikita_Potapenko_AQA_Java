package Shapes;

public class Circle implements FigureCalc {
    private double r;
    private Color backgroundColor;
    private Color borderColor;

    public Circle(double r, Color backgroundColor, Color borderColor) {
        this.r = r;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeterCalc() {
        return FigureCalc.super.perimeterCalc(r);
    }

    @Override
    public double squareCalc() {
        return FigureCalc.super.squareCalc(r);
    }

    @Override
    public String toString() {
        return "Shapes.Circle{" +
                "r=" + r +
                ", backgroundColor=" + backgroundColor +
                ", borderColor=" + borderColor +
                '}' + "\n" +
                String.format("Периметр круга: %.2f\n", perimeterCalc()) +
                String.format("Площадь круга: %.2f\n", squareCalc());
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
