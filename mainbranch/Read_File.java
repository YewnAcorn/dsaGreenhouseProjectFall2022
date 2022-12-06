import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Read_File {   
  
  // Create array of Strings for storing the data we read in
  public List<String> lines;
  
  Read_File(){
  // Initializing file Path with some conditions
  Path inputFilePath = Paths.get(".", "weather_data.txt");
  Charset charset = StandardCharsets.UTF_8;
  

  
    // Try to read in the lines
    try {
      // read content from file
      lines = Files.readAllLines(inputFilePath, charset);
      for(String line: lines) {
        System.out.println(line);
      }
    }

    // Catch possible errors so it doesn't crash the program
    // Might want to decide to take further action here
//* // Maybe want to write the exception to the file?
    catch (IOException e) {
      // Failsafe in case writing to file fails
      System.out.println("Exception caught.");
      e.printStackTrace();
    }
  }

  public String getLastLine(){
    // returns the last line of the file, which is a string representing
    // a node of our data:  date, weather id, temp
    return lines.get(lines.size() - 1);
  }

//   public static void main(String[] args){
    
//     // Example of how to call class and use function
//     Read_File read = new Read_File();
//     System.out.println("read.lines.size(): " + read.lines.size());
//     System.out.println("read.getLastLine(): " + read.getLastLine());
//     String[] lastLineAsArray =  read.getLastLine().split(",");
//     for(String item : lastLineAsArray){
//       System.out.println(item);
//     }

//   }
}
