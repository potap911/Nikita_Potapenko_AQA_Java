package org.potapenko;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Факториал числа
 *
 */
public class FactorialCalc
{
    public static void main( String[] args ) {
        try {
            int arg = inputArg();
            int res = getFactorial(arg);

            if (res < 0) System.out.println("Факториал числа " + arg + " - " + "не существует");
            else System.out.println("Факториал числа " + arg + " = " + getFactorial(arg));

        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
        }
    }

    public static int getFactorial(int arg) {
        if(arg < 0) return -1;
        int result = 1;
        for (int i = 1; i <= arg; i++) {
            result = result * i;
        }
        return result;
    }

    public static int inputArg() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите целое число:");
        return scan.nextInt();
    }
}
