import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class InsSortInt {

    private ArrayList<Integer> intList; 
    private String filePath; 

    // Constructor
    public InsSortInt(String filePath) {
        this.filePath = filePath; 
        this.intList = new ArrayList<>();
        try {
            loadIntegersFromFile(); 
        } catch (NumberFormatException e) {
            System.err.println("Error: Non-integer value found in file.");
            System.exit(1); 
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1); 
        }
    }

    // Method to load integers from the file
    private void loadIntegersFromFile() throws NumberFormatException, IOException {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); 
                intList.add(Integer.parseInt(line)); 
            }
        }
    }

    
    private void sort() {
        for (int i = 1; i < intList.size(); i++) {
            int j = i;
            while (j > 0 && intList.get(j) < intList.get(j - 1)) {
                Integer temp = intList.get(j);
                intList.set(j, intList.get(j - 1));
                intList.set(j - 1, temp);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "randInts.txt"; 
        InsSortInt sorter = new InsSortInt(filePath); 
        sorter.sort(); // Sort the list
        for (int i = 0; i < sorter.intList.size(); i++) {
            System.out.println(sorter.intList.get(i));
        }
    }
}