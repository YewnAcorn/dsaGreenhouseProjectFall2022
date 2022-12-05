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

public class shotcaller
{
	public static void main(String args[]) throws FileNotFoundException 
	{
		
		// Reading the JSON Parser output file (weather_data.txt)
		File raincode = new File("/home/pi/Gardenbot/dsaGreenhouseProjectFall2022/testing-api/raincode.txt"); 
		
		// passing in the object made from readin in the file
		Scanner scnr = new Scanner(raincode);
		
		// cast line to array, read index 1?
		int code = scnr.nextInt(); 

		if((code == 200) || (code == 201) || (code == 202) || (code == 230) || (code == 231) || (code == 232) || ((code >= 300) && (code < 400)) || ((code >= 500) && (code < 600))) 
		{
			System.out.println("rain");
			// write out that we didn't water
		}
		else
		{
			System.out.println("nope");
			// tell it to water
			// write out that we watered
		}
	}
}

