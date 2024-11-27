import java.io.*;
import java.util.ArrayList;

public class FileHandling {

    static public void writeFile(String expression) {
        File filePath = new File("/media/safi-khan/NOT UBUNTU/Calculator-GUI/src/Data/Calculations.txt");

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(expression + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static public ArrayList<String> readFile() {
        String filePath = "/media/safi-khan/NOT UBUNTU/Calculator-GUI/src/Data/Calculations.txt";
        ArrayList<String> expressionsArray = new ArrayList<>();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                expressionsArray.add(line);
            }


        } catch (IOException e) {
            expressionsArray.add("THERE IS NO HISTORY.");
        }
        return expressionsArray;
    }

    static public void deleteFile() {
        File filePath = new File("/media/safi-khan/NOT UBUNTU/Calculator-GUI/src/Data/Calculations.txt");
        filePath.delete();
    }

}
