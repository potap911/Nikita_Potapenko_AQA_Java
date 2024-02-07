import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class AppData {
    private final String[] header;
    private final int[][] data;
    private static final int cntSave = 0;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public static void saveToCSV(AppData appData) {
        String path;
        try {
            if (cntSave == 0) path = "AppData.csv";
            else path = "AppData" + cntSave + ".csw";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();

            String[] header = appData.getHeader();
            for (int i = 0; i < header.length; i++) {
                if (i == header.length - 1) builder.append(header[i]);
                else builder.append(header[i]).append(';');
            }

            builder.append('\n');

            int[][] data = appData.getData();
            for (int[] line : data) {
                for (int j = 0; j < line.length; j++) {
                    if (j == line.length - 1) builder.append(line[j]);
                    else builder.append(line[j]).append(';');
                }
                builder.append('\n');
            }

            bw.write(builder.toString());
            bw.newLine();
            bw.flush();
            bw.close();

            //cntSave++;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AppData readCSV(String path) {
        AppData appData = null;
        String[] header = null;
        int[][] data = null;

        try {
            BufferedReader csvReader = Files.newBufferedReader(Paths.get(path));
            if (!csvReader.ready()) return null;

            String line;
            int lineIndex = -1;

            if ((line = csvReader.readLine()) != null) {
                header = line.split(";");
                int row = (int) csvReader.lines().count() - 1;
                int col = header.length;
                data = new int[row][col];
                csvReader.close();
            }

            csvReader = Files.newBufferedReader(Paths.get("AppData.csv"));

            while ((line = csvReader.readLine()) != null) {
                if (lineIndex == -1) {
                    lineIndex++;
                    continue;
                }
                    for (int i = lineIndex; i <= lineIndex && i < data.length; i++) {
                        String[] lineValue = line.split(";");
                        for (int j = 0; j < data[i].length; j++) {
                            data[i][j] = Integer.parseInt(lineValue[j]);
                        }
                    }
                lineIndex++;
            }
            appData = new AppData(header, data);
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appData;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("header=").append(Arrays.toString(header)).append("\n");
        for (int[] lineData : data) {
            builder.append("data=").append(Arrays.toString(lineData)).append("\n");
        }
        return builder.toString();
    }

}
