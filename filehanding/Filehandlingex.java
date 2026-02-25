package filehanding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filehandlingex {

    public static void main(String[] args) {

        File file = new File("Demo.txt");

        // 1️⃣ CREATE FILE
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2️⃣ WRITE DATA INTO FILE
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Java file handling example");
            System.out.println("Data written into file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
