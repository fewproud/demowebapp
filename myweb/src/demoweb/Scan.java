package demoweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Scan {
	private ArrayList<String> status=new ArrayList();
	private ArrayList<String> pods=new ArrayList();
	private ArrayList<String> nums=new ArrayList();
	private HashMap map=new HashMap();
	private int times;

	public Scan(int times)
	{
		this.times=times;
		
		URL url;
		//String status="initial";
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
			            String pod=getPodName(line);
			            Integer time=(Integer)map.get(pod); 
			            if (time==null)
			            {
			            	time=new Integer(0);
			            }
			            map.put(pod,new Integer(time.intValue()+1));
			        }
	
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		Iterator it=map.keySet().iterator();
		
		while (it.hasNext())
		{
			String pod=(String)it.next();
			pods.add(pod);
			Integer num=(Integer)map.get(pod);
			nums.add(num.toString());
		}

	}
	
	private String getPodName(String line)
	{
		int pos=line.indexOf(" ");
		if (pos<0)
			return null;
		else
		{
			return line.substring(0,pos);
		}
	}

	public ArrayList getList()
	{
		return status;
	}
	
	public ArrayList getPods()
	{
		return pods;
	}
	
	public ArrayList getNums()
	{
		return nums;
	}
}
