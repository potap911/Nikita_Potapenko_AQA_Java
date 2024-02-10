import Fruits.Apple;
import Fruits.Orange;

public class Main {
    public static void main(String[] args) {
        System.out.println("addFruitTest: " + addFruitTest() + "\n");
        System.out.println("getWeightTest: " + getWeightTest() + "\n");
        System.out.println("compareTest: " + compareTest() + "\n");
        System.out.println("loadingToTest: " + loadingToTest() + "\n");
        System.out.println("loadingFromTest: " + loadingFromTest() + "\n");
    }

    public static boolean addFruitTest() {
        System.out.println("Тест добавления фрукта в корзину");
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box box = new Box();
        box.addFruit(apple);
        box.addFruit(orange);

        return box.getFruits().size() == 1;
    }

    public static boolean getWeightTest() {
        System.out.println("Тест получения веса корзины");
        Box box = new Box();
        for (int i = 0; i < 10; i++) {
            box.addFruit(new Apple());
        }

        return box.getWeight() == 10.0f;
    }

    public static boolean compareTest() {
        System.out.println("Тест сравнения корзин");
        Box boxApples = new Box();
        for (int i = 0; i < 15; i++) {
            boxApples.addFruit(new Apple());
        }
        Box boxOranges = new Box();
        for (int i = 0; i < 10; i++) {
            boxOranges.addFruit(new Orange());
        }

        return boxApples.compare(boxOranges);
    }

    public static boolean loadingToTest() {
        System.out.println("Тест пересыпки из текущей коробки в переданную");
        Box boxApples1 = new Box();
        for (int i = 0; i < 15; i++) {
            boxApples1.addFruit(new Apple());
        }
        Box boxApples2 = new Box();
        for (int i = 0; i < 10; i++) {
            boxApples2.addFruit(new Apple());
        }
        Box boxOranges = new Box();
        for (int i = 0; i < 10; i++) {
            boxOranges.addFruit(new Orange());
        }
        boxApples1.loadingTo(boxApples2);
        boxApples1.loadingTo(boxOranges);

        return boxApples2.getFruits().size() == 25;
    }

    public static boolean loadingFromTest() {
        System.out.println("Тест пересыпки в текущую коробку из переданной");
        Box boxApples1 = new Box();
        for (int i = 0; i < 15; i++) {
            boxApples1.addFruit(new Apple());
        }
        Box boxApples2 = new Box();
        for (int i = 0; i < 10; i++) {
            boxApples2.addFruit(new Apple());
        }
        Box boxOranges = new Box();
        for (int i = 0; i < 10; i++) {
            boxOranges.addFruit(new Orange());
        }
        boxApples1.loadingFrom(boxApples2);
        boxApples1.loadingFrom(boxOranges);

        return boxApples1.getFruits().size() == 25;
    }
}