/*
 * this program takes in the weather code
 * and decides if that means rain or not
 * the codes that are rain are:
 * 200, 201, 202
 * 230, 231, 232
 * 3xx
 * 5xx
 *
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.SimpleDateFormat;

public class shotcaller
{
	public static boolean read(String recentData) throws FileNotFoundException 
	{
		
		// Reading the JSON Parser output file (weather_data.txt)
		// File raincode = new File("/home/pi/Gardenbot/dsaGreenhouseProjectFall2022/testing-api/raincode.txt"); 
		
		// passing in the object made from readin in the file
		//Scanner scnr = new Scanner(raincode);
		 
		// cast line to array, read index 1?
		// int code = scnr.nextInt(); 
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		
		String returnDate = dateFormat.format(date);
		
		int code = (int)recentData;
		if((code == 200) || (code == 201) || (code == 202) || (code == 230) || (code == 231) || (code == 232) || ((code >= 300) && (code < 400)) || ((code >= 500) && (code < 600))) 
		{
			System.out.println("rain");
			Write_Out.addLineToFile(returnDate + ", False\n","activity_log.txt");
			// write out that we didn't water
			// do we water?
			return false;
		}
		else
		{
			System.out.println("nope");
			Write_Out.addLineToFile(returnDate + ", True\n","activity_log.txt");

			// tell it to water
			// write out that we watered
			// do we water?
			return true;
		}
	}
}

