import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main
{
	private static HttpURLConnection connection;

	public static void main(String args[])
	{
		//method 1: java.net.HttpURLConnection
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
	try{
		

		URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=47.10&lon=-123.05&appid=2509420cdb43a79b9f4fe083772cfe0c");
		connection = (HttpURLConnection) url.openConnection();

		//request set up
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		int status = connection.getResponseCode();
		//System.out.println(status);
		
		if (status > 299)
		{
			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line);
			}
			reader.close();
		} else
		{
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line);
			}
			reader.close();
		}
		System.out.println(responseContent.toString());

	} catch (MalformedURLException e) {
			
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
				
	} 
	finally 
	{
		connection.disconnect();
	}

	}
}
