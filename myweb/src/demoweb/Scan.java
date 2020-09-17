package demoweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Scan {

	public static ArrayList display(int times)
	{
		
		URL url;
		//String status="initial";
		ArrayList<String> status=new ArrayList();
		
		try {
			url = new URL("http://localhost:8080/information/status");
			
			for (int i=0;i<times;i++)
			{
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				    for (String line; (line = reader.readLine()) != null;) {
				        System.out.println("status:"+line);
				        status.add(line);
				    }
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
