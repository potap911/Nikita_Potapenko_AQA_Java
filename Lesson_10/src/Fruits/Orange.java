package Fruits;

public class Orange extends Fruit {
    private final float weight;

    public Orange() {
        weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
