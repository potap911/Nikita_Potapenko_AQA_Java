package Animals;

import Animals.Animal;

public class Dog extends Animal {
    private final String name;
    public static int countDogs = 0;
    private static final int RUN_DISTANCE_LIMIT = 500;
    private static final int SWIM_DISTANCE_LIMIT = 10;
    private int runCountDistance;
    private int swimCountDistance;

    public Dog(String name) {
        this.name = name;
        this.runCountDistance = 0;
        this.swimCountDistance = 0;
        countDogs++;
        contAnimals++;
    }

    @Override
    public void run(int distance) {
        if (runCountDistance < RUN_DISTANCE_LIMIT) {
            runCountDistance += distance;
            if (runCountDistance > RUN_DISTANCE_LIMIT) {
                distance -= runCountDistance - RUN_DISTANCE_LIMIT;
                System.out.printf("Собака %s пробежала %dм. и устала%n", name, distance);
            } else System.out.printf("Собака %s пробежала %dм.%n", name, distance);
        } else System.out.println("Собака устала и не может больше бежать!");
    }

    @Override
    public void swim(int distance) {
        if (swimCountDistance < SWIM_DISTANCE_LIMIT) {
            swimCountDistance += distance;
            if (swimCountDistance > SWIM_DISTANCE_LIMIT) {
                distance -= swimCountDistance - RUN_DISTANCE_LIMIT;
                System.out.printf("Собака %s проплыла %dм. и устала%n", name, distance);
            } else System.out.printf("Собака %s проплыла %dм. метров%n", name, distance);
        } else System.out.println("Собака устала и не может больше плыть!");
    }

    public String getName() {
        return name;
    }

    public int getRunCountDistance() {
        return runCountDistance;
    }

    public void setRunCountDistance(int runCountDistance) {
        this.runCountDistance = runCountDistance;
    }

    public int getSwimCountDistance() {
        return swimCountDistance;
    }

    public void setSwimCountDistance(int swimCountDistance) {
        this.swimCountDistance = swimCountDistance;
    }
}
