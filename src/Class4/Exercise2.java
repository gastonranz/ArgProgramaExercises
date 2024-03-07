package Class4;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

public class Exercise2 {
    public static void main(String[] args) {
        try {
            Path archive = Paths.get("C:\\Users\\Gastón\\Documeants\\Ex2.txt");
            Files.readAllLines(archive);
        } catch (Exception e) {
            System.out.println("The file doesn't exist");
        }

    }
}
