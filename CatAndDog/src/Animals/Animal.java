package Animals;

public abstract class Animal {
    public static int contAnimals = 0;

    void run(int distance) {
        System.out.printf("Животное пробежало %d метров%n", distance);
    }

    void swim(int distance) {
        System.out.printf("Животное проплыло %d метров%n", distance);
    }
}
