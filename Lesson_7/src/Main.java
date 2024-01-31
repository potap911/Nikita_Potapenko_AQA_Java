public class Main {
    public static void main(String[] args) {
        getSumElemTest1();
        getSumElemTest2();
        getSumElemTest3();
        getSumElemTest4();
    }


    public static int getSumElem(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (matrix.length != 4) {
            throw new MyArraySizeException("Не корректный размер матрицы. \n\tmatrix.length = " + matrix.length);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 4) {
                throw new MyArraySizeException("Не корректный размер матрицы. \n\tmatrix[" + i + "].length = " + matrix[i].length);
            }
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ignored) {
                    throw new MyArrayDataException("Некорректное значение в матрице. \n\tmatrix[" + i + "][" + j + "] = " + matrix[i][j]);
                }
            }
        }

        return sum;
    }

    public static void getSumElemTest1() {
        System.out.println("\tTest: Некорректный ввод размера матрицы");
        String[][] matrix = {
                {"1", "0", "0", "1"}
        };

        try {
            getSumElem(matrix);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getSumElemTest2() {
        System.out.println("\tTest: Некорректного ввод размера матрицы");
        String[][] matrix = {
                {"1", "0", "0", "1"},
                {"1", "0", "0", "1"},
                {"1", "0", "0", "1", "1", "0"},
                {"1", "0", "0", "1"}
        };

        try {
            getSumElem(matrix);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getSumElemTest3() {
        System.out.println("\tTest: Некорректное значение в матрице");
        String[][] matrix = {
                {"1", "0", "0", "1"},
                {"1", "0", "s", "1"},
                {"1", "1", "0", "1"},
                {"1", "s", "1", "1"}
        };

        try {
            getSumElem(matrix);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getSumElemTest4() {
        System.out.println("\tTest: Корректная матрица");
        int sum  = 0;
        String[][] matrix = {
                {"1", "0", "0", "1"},
                {"1", "0", "1", "1"},
                {"1", "1", "0", "1"},
                {"1", "0", "1", "1"}
        };

        try {
            sum = getSumElem(matrix);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        if (sum == 11) System.out.println("sum = " + sum +  ": passed");
        else System.out.println("sum = " + sum +  ": false");
    }
}