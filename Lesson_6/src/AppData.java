import java.io.*;
import java.nio.charset.StandardCharsets;

public class AppData {
    private final String[] header;
    private final int[][] data;
    private static final int cntSave = 0;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public static void saveToCSW(AppData appData) {
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

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}
