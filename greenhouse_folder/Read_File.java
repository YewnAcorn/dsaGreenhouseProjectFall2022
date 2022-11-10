import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Read_File {    
  Read_File(){
  // Initializing file Path with some conditions
  Path inputFilePath = Paths.get(".", "weather_data.txt");
  Charset charset = StandardCharsets.UTF_8;
  List<String> lines;  
    try {
      // read content from file
      lines = Files.readAllLines(inputFilePath, charset);
      for(String line: lines) {
        System.out.println(line);
      }
    }
    catch (IOException e) {
      // Failsafe in case writing to file fails
      System.out.println("Exception caught.");
      e.printStackTrace();
    }
  }
}
