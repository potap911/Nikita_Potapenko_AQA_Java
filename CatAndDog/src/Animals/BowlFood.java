package Animals;

public class BowlFood {
    private int countFoods;

    public BowlFood(int countFoods) {
        this.countFoods = countFoods;
    }

    public void addFood(int countFoods) {
        System.out.println("Добавили в миску " + countFoods + " еды");
        this.countFoods += countFoods;
    }

    public void subFood(int countFoods) {
        this.countFoods -= countFoods;
    }

    public void setCountFoods(int countFoods) {
        this.countFoods = countFoods;
    }
    public int getCountFoods() {
        return countFoods;
    }
}
