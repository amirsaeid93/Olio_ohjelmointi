import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemperatureReader {
    private static final String CSV_URL = "https://users.metropolia.fi/~jarkkov/temploki.csv";
    private static final char DELIMITER = ';';

    public static void main(String[] args) {
        try {
            List<Double> temperatures = readTemperatures();
            double averageTemperature = calculateAverageTemperature(temperatures);
            System.out.println("Average temperature for 1st January 2023: " + averageTemperature);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static List<Double> readTemperatures() throws IOException, CsvException {
        List<Double> temperatures = new ArrayList<>();
        URL url = new URL(CSV_URL);
        try (CSVReader reader = new CSVReaderBuilder(new InputStreamReader(url.openStream(), "UTF-8"))
                .withCSVParser(new com.opencsv.CSVParserBuilder().withSeparator(DELIMITER).build())
                .build()) {
            String[] headers = reader.readNext();
            System.out.println("Headers: " + Arrays.toString(headers));
            int ulkoTaloIndex = -1;
            int dateIndex = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals("UlkoTalo")) {
                    ulkoTaloIndex = i;
                } else if (headers[i].equals("Aika")) {
                    dateIndex = i;
                }
            }

            if (ulkoTaloIndex == -1 || dateIndex == -1) {
                throw new IllegalArgumentException("Required columns not found in the CSV file");
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                String date = line[dateIndex];
                if (date.startsWith("2023-01-01")) {
                    temperatures.add(Double.parseDouble(line[ulkoTaloIndex]));
                }
            }
        }
        return temperatures;
    }

    private static double calculateAverageTemperature(List<Double> temperatures) {
        if (temperatures.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        return sum / temperatures.size();
    }
}