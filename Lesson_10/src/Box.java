import Fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit>{
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        if (fruits.isEmpty() || fruits.iterator().next().getClass() == fruit.getClass()) {
            fruits.add(fruit);
        }
    }

    public double getWeight() {
         return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public boolean compare(Box box) {
        return getWeight() == box.getWeight();
    }

    public void loadingTo(Box box) {
        if (!fruits.isEmpty() && fruits.iterator().next().getClass() == box.getFruits().iterator().next().getClass()) {
            box.getFruits().addAll(fruits);
            flashBox(this);
        }
    }

    public void loadingFrom(Box box) {
        if (!box.getFruits().isEmpty() && fruits.iterator().next().getClass() == box.getFruits().iterator().next().getClass()) {
            fruits.addAll(box.getFruits());
            flashBox(box);
        }
    }

    public static void flashBox(Box box) {
        box.setFruits(new ArrayList<>());
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }
}
