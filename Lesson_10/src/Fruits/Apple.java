package Fruits;

public class Apple extends Fruit {
    private final float weight;

    public Apple() {
        weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
