import java.util.Random;

public class Main {
    Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public static boolean checkNumbers(int a, int b) {
        int sum = a + b;
        if (10 <= sum && sum <= 20) return true;
        else return false;
    }

    public static void printCheckSing(int number) {
        if (isPositiveSing(number)) System.out.println(number + " -> " + "Положительное!");
        else System.out.println(number + " -> " + "Отрицательное!");
    }

    public static boolean isPositiveSing(int number) {
        if (number >= 0) return true;
        else return false;
    }

    public static void printString(String string, int count) {
        while (count > 0) {
            System.out.println(string);
        }
    }

    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            if (array[i] == 1) array[i] = 0;
        }
    }

    public static void fillNumbersToArray(int[] array) {
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = ++value;
        }
    }

    public static void multiplyNumbersToArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 6;
        }
    }

    public static int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

}