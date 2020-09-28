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

	public static ArrayList display(int times)
	{
		
		URL url;
		//String status="initial";
		ArrayList<String> status=new ArrayList();
		
		try {
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
			url = new URL(infurl);			
			
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
