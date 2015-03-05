import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GetAllUniData {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("console.txt"))));
		
		Document doc;
		
		doc = Jsoup.connect("http://www.4icu.org/in/index.htm").userAgent("Mozilla").get();
		
		Elements table = doc.select("table[width=100%]");
		Elements links = table.select("tr");

		int linkcount=0;
		for(Element link: links){
			
			System.out.print("\nUni : " + link.select("span").text() +","+link.select("a[href]").text()+","+link.select("td.i h5").text());
			try{
				GetOneUniInfo.main("http://www.4icu.org"+link.select("a[href]").attr("href")); 
			}catch(Exception e){
				System.out.print("?");
			}
			linkcount++;
		}
		System.out.println(linkcount);

	}

}
