import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Write_Out {
  static Path outputFilePath;
  
    public static void addLineToFile(String dataLine){

      // Initializing file Path with some conditions
      outputFilePath = Paths.get(".", "action_log.txt");
      try {
        Files.writeString(outputFilePath, dataLine + "\n", StandardOpenOption.APPEND);
        System.out.println(dataLine);
        }
  
      catch (IOException e) {
        // Failsafe in case writing to file fails
        System.out.println("Exception caught.");
        e.printStackTrace();
      }
    }
}
