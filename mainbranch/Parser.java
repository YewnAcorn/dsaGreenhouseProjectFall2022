import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.date;
public class Parser {
    
    public static String[] read(String fpath) throws IOException {
        
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
        
        //Using JSONArray
        JSONArray arrObj = jsonObj.getJSONArray("main");
        
        double temp = arrObj.getJSONObject(0).getDouble("temp");
        System.out.println(temp);
        
	Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
	String returnDate = dateFormat.format(currentDate);
	    
	//convert to strings    
	String weatheridee = (String)weatherID;
	String tempString = (String)temp;
	String[] returnArray = {returnDate, weatheridee, tempString};
	
	for(int b = 0; b < returnArray.length - 1; b++)
	{
		Write_Out.addLineToFile(returnArray[b] + ", ", "weather_data.txt");
	}
	Write_Out.addLineToFile(returnArray[2] + "\n", "weather_data.txt");
	    
	
	return returnArray;
		

	//write to file
	//format: mm/dd/yy, string id
	//are there / between month, day, year?



    }
}
