package demoweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class Scan {
	public Scan()
	{
		
	}

	public ArrayList display(int times)
	{
		
		URL url;
		//String status="initial";
		ArrayList<String> status=new ArrayList();
		System.out.println("v0.3 scan time is "+times);
		
		Map<String, String> env = System.getenv();
		String infurl=env.get("INFO_URL");
		if (infurl==null)
		{
			infurl="http://127.0.0.1:8080/information/status";
			System.out.println("Can't find INFO_URL from the environment property, using the default one "+infurl);
		}
		else
		{
			System.out.println("found INFO_URL from the environment property, using the default one "+infurl);
		}
		
			
		for (int i=0;i<times;i++)
		{
				/*
				url = new URL(infurl);	
				System.out.println("try No. "+i+" to connect "+url);
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
				*/

			try {
				ProcessBuilder processBuilder = new ProcessBuilder();
	
			    processBuilder.command("curl", infurl);
	
			    Process process = processBuilder.start();
	
			    try (BufferedReader reader = new BufferedReader(
			            new InputStreamReader(process.getInputStream()))) {
	
			        String line;
	
			        while ((line = reader.readLine()) != null) {
			        	System.out.println(line);
			            status.add(line);
			        }
	
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		return status;
	}
}
