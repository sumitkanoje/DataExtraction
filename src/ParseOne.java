import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseOne {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc;
		
		doc = Jsoup.connect("http://www.google.com").userAgent("Mozilla").get();
		
		String title = doc.title();
		System.out.println(title);
		
		Elements links = doc.select("a[href]");
		for(Element link: links){
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
		}
		

	}

}
