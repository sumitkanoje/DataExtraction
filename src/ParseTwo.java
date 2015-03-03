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
		
		Elements sections = doc.select("div.section.group");
		Element temp = sections.get(6);

		Elements links = temp.select("td.i a[href]");
		int linkcount=0;
		for(Element link: links){
			System.out.println("\nlink : " + link.attr("href"));
			try{
			ParseThree.main("http://www.4icu.org"+link.attr("href").toString());
			}catch(Exception e){
				System.out.print("?");
			}finally{
				
			}
			//System.out.println("text : " + link.text());
			linkcount++;
		}
		System.out.println(linkcount);
		

	}

}
