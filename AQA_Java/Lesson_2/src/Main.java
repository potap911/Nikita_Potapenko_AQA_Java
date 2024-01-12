import java.util.Random;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();
        int sum = a + b;
        if (sum > 0) System.out.println(a + " + " + b + " - " + "сумма положительная");
        else System.out.println(a + " + " + b + " - " + "сумма отрицательная");
    }

    public static void printColor() {
        Random random = new Random();
        int value = random.nextInt();
        System.out.print("value: " + value + ": ");
        if (value <= 0) System.out.println("Красный");
        if (value > 0 && value <= 100) System.out.println("Желтый");
        if (value > 100) System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();;
        if (a >= b) System.out.println(a + " and " + b + ": " + "a >= b");
        if (a < b) System.out.println(a + " and " + b + ": " + "a < b");
    }

}

