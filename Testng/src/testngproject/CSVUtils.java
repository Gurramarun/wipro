package testngproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static Object[][] getCSVData(String path) throws Exception {

        List<Object[]> dataList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        // Skip header row
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            dataList.add(values);
        }

        br.close();

        Object[][] data = new Object[dataList.size()][];

        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }
}
