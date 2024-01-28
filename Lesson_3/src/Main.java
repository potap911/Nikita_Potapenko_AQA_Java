import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("\tHello world!");

        System.out.println("\n\tTask_1");
        System.out.println("Cумма \"10 + 10\" лежит в пределе 10 ... 20: " + checkNumbers(10, 10));
        System.out.println("Cумма \"11 + 10\" лежит в пределе 10 ... 20: " + checkNumbers(11, 10));
        System.out.println("Cумма \"-1 + 1\" лежит в пределе 10 ... 20: " + checkNumbers(-1, 1));

        System.out.println("\n\tTask_2");
        printCheckSing(10);
        printCheckSing(0);
        printCheckSing(-10);

        System.out.println("\n\tTask_3");
        System.out.println("Число \"10\" является положительным: " + isPositiveSing(10));
        System.out.println("Число \"0\" является положительным: " + isPositiveSing(0));
        System.out.println("Число \"-10\" является положительным: " + isPositiveSing(-10));

        System.out.println("\n\tTask_4");
        System.out.println("Строкка \"Hello!\" должно быть отпечатана 3 раза");
        printStrings("Hello!", 3);

        System.out.println("\n\tTask_5");
        System.out.println("Год \"10\" является високосным: " + isLeapYear(10));
        System.out.println("Год \"400\" является високосным: " + isLeapYear(400));
        System.out.println("Год \"100\" является високосным: " + isLeapYear(100));
        System.out.println("Год \"2024\" является високосным: " + isLeapYear(2024));
        System.out.println("Год \"800\" является високосным: " + isLeapYear(800));
        System.out.println("Год \"24\" является високосным: " + isLeapYear(24));
        System.out.println("Год \"22\" является високосным: " + isLeapYear(22));
        System.out.println("Год \"200\" является високосным: " + isLeapYear(200));

        System.out.println("\n\tTask_6");
        int[] array = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Expected: ");
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        changeArray(array);
        System.out.print("Actual:   ");
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));

        System.out.println("\n\tTask_7");
        array = new int[100];
        fillNumbersToArray(array);
        System.out.print("Result: ");
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));

        System.out.println("\n\tTask_8");
        array = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Input:  ");
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));
        multiplyNumbersToArray(array);
        System.out.println();
        System.out.print("Result: ");
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));

        System.out.println("\n\tTask_9");
        System.out.println("Заданная матрица со сторонами: " + 5 + " и " + 5);
        createDoubleArray(5, 5);
        System.out.println();
        System.out.println("Заданная матрица со сторонами: " + 11 + " и " + 11);
        createDoubleArray(11, 11);
        System.out.println();
        System.out.println("Заданная матрица со сторонами: " + 3 + " и " + 4);
        createDoubleArray(3, 4);

        System.out.println("\n\tTask_10");
        System.out.println("Заданный массив с длинной: " + 0);
        array = initArray(0, 1);
        System.out.println(Arrays.toString(array));
        System.out.println("Заданный массив с длинной: " + -1);
        array = initArray(-1, 1);
        System.out.println(Arrays.toString(array));
        System.out.println("Заданный массив с длинной: " + 5 + " и значением: " + 1);
        array = initArray(5, 1);
        Arrays.stream(array).forEach(elem -> System.out.print(elem + " "));
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
        return number < 0;
    }

    public static void printStrings(String string, int count) {
        while (count-- > 0) {
            System.out.println(string);
        }
    }

    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else if (array[i] == 1) array[i] = 0;
        }
    }

    public static void fillNumbersToArray(int[] array) {
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = value++;
        }
    }

    public static void multiplyNumbersToArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 6;
        }
    }

    public static int[] initArray(int len, int initialValue) {
        if (len <= 0) return null;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void createDoubleArray(int rows, int columns) {
        if (rows != columns) System.out.println("Заданная матрица со сторонами: " + rows + " и " + columns +  " - не квадратная!");
        else {
            int[][] doubleArray = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == j) doubleArray[i][j] = 1;
                }
            }

            for (int i = 0, j = columns - 1; i < rows && j >= 0; i++, j--) {
                doubleArray[i][j] = 1;
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (doubleArray[i][j] == 1) System.out.print(doubleArray[i][j] + " ");
                    else System.out.print("  ");
                }
                System.out.println();
            }
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }
}