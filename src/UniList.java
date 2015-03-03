import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class UniList {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc;
		
		doc = Jsoup.connect("http://www.4icu.org/in/index.htm").userAgent("Mozilla").get();
		
		String title = doc.title();
		System.out.println(title);
		
		
		Elements table = doc.select("table[width=100%]");
		Elements links = table.select("tr");
		//Elements loc = table.select("h5");
		int linkcount=0;
		for(Element link: links){
			
			System.out.println("\nText : " + link.select("span").text() +","+link.select("a[href]").text()+",http://www.4icu.org"+link.select("a[href]").attr("href")+","+link.select("td.i h5").text());
			linkcount++;
		}
		System.out.println(linkcount);

	}

}
