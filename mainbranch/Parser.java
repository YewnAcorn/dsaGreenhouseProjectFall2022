import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;

public class Parser {
    
    public static void read(String fpath) throws IOException {
        
    	//creates new buffered reader to read WeatherReportJSON.txt
	//give relative path as argument
        BufferedReader br = new BufferedReader(new FileReader(fpath));            
        String line; //holds line

        //declare string builder object
        StringBuilder sbuilderObj = new StringBuilder();
        
	//loop through JSON file using the readLine method and
        //appends lines to sbuilderObj
	while((line=br.readLine()) !=null){
            sbuilderObj.append(line);
        }
        //test print out string builder contents
        //System.out.println("Original Json :: "+sbuilderObj.toString());
       
        //creates JSONObject using sbuilderObj
        JSONObject jsonObj = new JSONObject(sbuilderObj.toString());
     
	//creates JSONArray to hold weather data
        JSONArray weather = jsonObj.getJSONArray("weather");
	
	//parses jsonObj, accesses element in "weather" array
	JSONObject id = weather.getJSONObject(0);
	
	//gets weather id and stores it in an int weatherID
	int weatherID = id.getInt("id");
       
	//test print weatherID
	//System.out.println(weatherID);

        
        /*
        //Using JSONArray
        JSONArray arrObj = jsonObj.getJSONArray("main");
        
        double temp = arrObj.getJSONObject(0).getDouble("temp");
        System.out.println(temp);
        */

	//get date
	//java.util.date	

	//write to file
	//format: mm/dd/yy, string id
	//are there / between month, day, year?



    }
}
