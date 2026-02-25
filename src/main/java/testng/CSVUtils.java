package testng;

import java.io.*;
import java.util.*;

public class CSVUtils {

    public static Object[][] getCSVData(String filePath) throws Exception {

        List<Object[]> dataList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        br.readLine(); // skip header

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

	public static Object[][] getCSVData1(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}
}
