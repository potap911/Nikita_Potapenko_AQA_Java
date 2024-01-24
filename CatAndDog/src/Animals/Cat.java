package Animals;

public class Cat extends Animal {
    private String name;
    public static int countCats = 0;
    private BowlFood bowlFood;
    private boolean isSatiety;
    private static final int RUN_DISTANCE_LIMIT = 200;
    private int runCountDistance;


    public Cat(String name, BowlFood bowlFood) {
        this.name = name;
        this.runCountDistance = 0;
        this.bowlFood = bowlFood;
        this.isSatiety = false;
        countCats++;
        contAnimals++;
    }

    public Cat(String name) {
        this.name = name;
        this.runCountDistance = 0;
        this.isSatiety = false;
        countCats++;
        contAnimals++;
    }

    @Override
    public void run(int distance) {
        if (runCountDistance < RUN_DISTANCE_LIMIT) {
            runCountDistance += distance;
            if (runCountDistance > RUN_DISTANCE_LIMIT) {
                distance -= runCountDistance - RUN_DISTANCE_LIMIT;
                System.out.printf("Кот %s пробежал %dм. и устал%n", name, distance);
            } else System.out.printf("Кот %s пробежал %dм.%n", name, distance);
        } else System.out.println("Кот устал");
    }

    public void eat(int byteFood) {
        if (bowlFood.getCountFoods() - byteFood >= 0) {
            System.out.printf("Кот %s поел %d еды%n", name, byteFood);
            bowlFood.subFood(byteFood);
            isSatiety = true;
        } else System.out.printf("Кот %s пытается поесть %d еды. Но еды в миске совсем мало, всего: %d%n", name, byteFood, bowlFood.getCountFoods());
    }

    public String isSatietyInfo() {
        return this.isSatiety() ? "Кот " + this.getName() + " - сытый" : "Кот " + this.getName() + " - не сытый";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunCountDistance() {
        return runCountDistance;
    }

    public void setRunCountDistance(int runCountDistance) {
        this.runCountDistance = runCountDistance;
    }

    public boolean isSatiety() {
        return isSatiety;
    }

    public void setSatiety(boolean satiety) {
        isSatiety = satiety;
    }

    public static int getCountCats() {
        return countCats;
    }

    public static void setCountCats(int countCats) {
        Cat.countCats = countCats;
    }
}
