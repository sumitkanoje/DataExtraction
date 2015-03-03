import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseTwo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc;
		
		doc = Jsoup.connect("http://www.4icu.org/in/indian-universities.htm").userAgent("Mozilla").get();
		
		String title = doc.title();
		System.out.println(title);
		
		Elements table = doc.select("table[width=100%]");
		Elements links = table.select("a[href]");
		//Elements loc = table.select("h5");
		int linkcount=0;
		for(Element link: links){
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
			linkcount++;
		}
		System.out.println(linkcount);

	}

}
