import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Class for analyzing data
class DataAnalyzer {
    private ArrayList<Double> data;

    // Constructor to initialize data
    public DataAnalyzer(ArrayList<Double> data) {
        this.data = data;
    }

    // Method to calculate the minimum value
    public double minValue() {
        return data.stream().min(Double::compare).orElse(Double.NaN);
    }

    // Method to calculate the maximum value
    public double maxValue() {
        return data.stream().max(Double::compare).orElse(Double.NaN);
    }

    // Method to calculate the average value
    public double avgValue() {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return data.isEmpty() ? Double.NaN : sum / data.size();
    }
}

// Class for testing the DataAnalyzer
class DataAnalyzerTester {
    // Method to read data from a file
    public static ArrayList<Double> readFile(String fileName) {
        ArrayList<Double> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextDouble()) {
                data.add(scanner.nextDouble());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File '" + fileName + "' not found.");
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return data;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Assuming the data file is named 'Lab1.dat'
        String dataFileName = "Lab1.dat.txt";

        // Read data from the file using DataAnalyzerTester
        ArrayList<Double> data = readFile(dataFileName);

        if (!data.isEmpty()) {
            // Create an instance of DataAnalyzer
            DataAnalyzer analyzer = new DataAnalyzer(data);

            // Print the results
            System.out.println("Minimum value: " + analyzer.minValue());
            System.out.println("Maximum value: " + analyzer.maxValue());
            System.out.println("Average value: " + analyzer.avgValue());
        }
    }
}
