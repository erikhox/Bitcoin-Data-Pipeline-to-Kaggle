import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createFile {
    public static void create(String name) {
        try {
            //setting the path for where the CSV file should be created
            String path = "src/main/csv_files/";

            //setting the name for the CSV file
            String title = name + ".csv";

            //preparing the CSV file to be created and creating its header
            File file = new File(path + title);
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            String[] header = {"DateTime", "Price", "Bid", "Ask"};
            writer.writeNext(header);
            writer.close();
        } catch (IOException e) {
            System.out.println("error with file writing");
        }
    }
}
