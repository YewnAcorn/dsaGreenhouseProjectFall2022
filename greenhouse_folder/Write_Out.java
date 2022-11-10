import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Write_Out {    
  Write_Out(){

    // Initializing file Path with some conditions
    Path outputFilePath = Paths.get(".", "action_log.txt");
    }
  
    public void addLineToFile(String dataLine){
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
