import Animals.Animal;
import Animals.BowlFood;
import Animals.Cat;
import Animals.Dog;
import Shapes.Circle;
import Shapes.Color;
import Shapes.Rectangle;
import Shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 3, 1, 3, Color.RED, Color.GREEN);
        Triangle triangle = new Triangle(29, 29, 29, 12, Color.YELLOW, Color.GREEN);
        Circle circle = new Circle(13, Color.GREEN, Color.RED);

        System.out.println(rectangle);
        System.out.println(triangle);
        System.out.println(circle);

        System.out.println("\tAnimals.Dog test");
        Dog dogChop = new Dog("Chop");
        dogChop.run(300);
        dogChop.run(300);
        dogChop.run(1);
        dogChop.swim(9);
        dogChop.swim(1);
        dogChop.swim(1);
        System.out.println();

        System.out.println("\tAnimals.Cat test");
        Cat catBerlios = new Cat("Берлиоз");
        catBerlios.run(100);
        catBerlios.run(101);
        catBerlios.run(1);
        System.out.println();

        System.out.println("\tAnimals.Cat eat test");
        BowlFood bowlFood = new BowlFood(31);
        List<Cat> catList = initCatList(bowlFood);

        catList.forEach(cat -> cat.eat(15));
        catList.forEach(cat -> System.out.println(cat.isSatietyInfo()));
        System.out.println();

        bowlFood.addFood(100);
        catList.get(2).eat(15);
        catList.forEach(cat -> System.out.println(cat.isSatietyInfo()));

        System.out.println("\n\t Count Animals test");
        System.out.println("Всего создано собак - " + Dog.countDogs);
        System.out.println("Всего создано котов - " + Cat.countCats);
        System.out.println("Всего создано животных - " + Animal.contAnimals);
    }

    public static List<Cat> initCatList(BowlFood bowlFood) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Mikel", bowlFood));
        catList.add(new Cat("Trevor Filips", bowlFood));
        catList.add(new Cat("Franklin", bowlFood));
        return catList;
    }
}

