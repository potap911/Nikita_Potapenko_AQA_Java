package org.potapenko;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.testng.Assert.*;

public class FactorialCalcTest {

    @Test (description = "Переданное число: '0'")
    void getFactorialTest1() {
        assertEquals(1, FactorialCalc.getFactorial(0));
    }

    @Test (description = "Переданное число: '-5'")
    void getFactorialTest2() {
        assertEquals(-1, FactorialCalc.getFactorial(-5));
    }

    @Test (description = "Переданное число: '5'")
    void getFactorialTest3() {
        assertEquals(120, FactorialCalc.getFactorial(5));
    }

    @Test (description = "Ввод: 'one'")
    void inputArgTest1() {
        ByteArrayInputStream in = new ByteArrayInputStream("one".getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, FactorialCalc::inputArg);
    }

    @Test (description = "Ввод: '1.1'")
    void inputArgTest2() {
        ByteArrayInputStream in = new ByteArrayInputStream("1.1".getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, FactorialCalc::inputArg);
    }

    @Test (description = "Ввод: '5'")
    void inputArgTest3() {
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);

        assertEquals(5, FactorialCalc.inputArg());
    }
}