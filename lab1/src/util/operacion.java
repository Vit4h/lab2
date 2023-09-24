package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class operacion {
    public List<CsvReader> reader(String path) {
        List<CsvReader> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                CsvReader record = new CSVRecord(parts[0], parts[1]);
                result.add(record);
                    
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
