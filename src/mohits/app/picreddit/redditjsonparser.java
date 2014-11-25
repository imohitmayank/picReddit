/**@Mohit
 * 
 */
package mohits.app.picreddit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mohit
 *
 *In a json there are a ttl of 25 data elements, so all the dataIDs we want are used
 *25 times in a json file.
 * This parser is specially designed for reddit related parsing.
 *Data we want:-- title,url,domain,author,score,over_18,thumbnail,created,num_comments.
 */
public class redditjsonparser 
{
	String data;
	public void getInfo(String path) throws FileNotFoundException
	{
		path="C:\\picreddit\\nsfw_json.txt";
		File file = new File(path);
		Scanner scan = new Scanner(file);
		 data = null;
		
		while(scan.hasNextLine())
		{
			data+=scan.nextLine();
		}
		
		ArrayList<ArrayList<String>> collection = new  ArrayList<ArrayList<String>>();
		ArrayList<String> element = new ArrayList<String>();
		
		String[] code = new String[]{"title", "url", "domain","author","score","over_18"
				,"thumbnail","created","num_comments"};
		
		
		for(int i=0;i<9;i++)
		{
			int startpoint=0,len=0,newstartpoint=0,endpoint;
			String word="";
			for(int j=0;j<25;j++)
			{
			newstartpoint = data.indexOf(code[i], startpoint);
			len=code[i].length()+4;
			endpoint=newstartpoint+len;
			while(data.charAt(endpoint)!='"')
			{
				endpoint++;
			}
			word= data.substring(newstartpoint,endpoint);
			element.add(i, word);
			collection.add(j, element);
			startpoint=endpoint;
			
			}
		}
		
		for(int i=0;i<25;i++)
		{
			System.out.println("\n--------\nData Element: "+i+"\n---------\n");

			for(int j=0;j<9;j++)
			{
				System.out.println(code[j]+":- "+(collection.get(j)).get(i));
			}
		}
	}
	

}
