public class Main {
    public static void main(String[] args) {
        AppData appDataReadTest;

        AppData.saveToCSW(getAppDataTest1());
        appDataReadTest = AppData.readCSW("AppData.csv");
        System.out.println(appDataReadTest.toString());

        AppData.saveToCSW(getAppDataTest2());
        appDataReadTest = AppData.readCSW("AppData.csv");
        System.out.println(appDataReadTest.toString());
    }

    public static AppData getAppDataTest1() {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {
                {1, 2, 3},
                {4, 5, 6}
        };

        return new AppData(header, data);
    }

    public static AppData getAppDataTest2() {
        String[] header = {"Value1", "Value2", "Value3", "Value4", "Value5"};
        int[][] data = {
                {1, 2, 3, 4, 5},
                {4, 5, 6, 4, 3},
                {7, 8, 9, 3 ,3}
        };

        return new AppData(header, data);
    }


}