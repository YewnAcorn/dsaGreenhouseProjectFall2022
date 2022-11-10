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
//    Example of the formate for writing out to file.
//     public static void main(String[] args){
//       // Reverse_Lines_Template myInstance = new Reverse_Lines_Template();
//       Write_Out.addLineToFile("date_time,\t temp,\t time_watered\n");
//       Write_Out.addLineToFile("2022-11-10-15-51,\t 280,\t 40\n");
    }
}
