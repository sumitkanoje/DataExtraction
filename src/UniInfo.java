import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class UniInfo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc;
		
		doc = Jsoup.connect("http://www.4icu.org/reviews/12299.htm").userAgent("Mozilla").get();
		
		String title = doc.title();
		System.out.println("Title: "+title);

		//Get General Information		
		Elements table = doc.select("table[width=100%]");
		System.out.println("\nTable: "+table.text());
		Elements links = table.select("td[width=75%] h5 a[href]");
		//Elements loc = table.select("h5");
		int linkcount=0;
		for(Element link: links){
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
			linkcount++;
		}
		System.out.println("Count: "+linkcount);
		
		Elements acronym = doc.select("acronym");
		System.out.println("Acronym: "+acronym.text());
		
		Elements year = doc.select("tr td h5");
		System.out.println("Year:"+year.get(4).text());
		
		Elements Address = doc.select("td[width=75%]");
		System.out.println("Address: "+Address.text());
		
		Elements phnos = doc.select("tr td h5");
		Element phno =	phnos.get(10);
		System.out.println("Telephone: "+phno.text()); 
		System.out.println("Fax: "+phnos.get(11).text());

//Get Course Information		
//This code extracts course information from Table
//So You Will Have to implement for loop inside this to print all courses available in a university.
//I have used .first() function which retrieves only first course from Table
		Elements raw = doc.select("tr:has(img[src=/i/1b.gif])");
		Element courses = raw.get(0);
		Element course = courses.child(0);
		course = course.getElementsByClass("tooltip").first();
		//course = course.
		System.out.println("Courses: "+course.childNode(0)+"\n");
		
//Try Implementing Below Code
		
//Get Tuition Fees Range
		
//Get Admissions Information
		
//Get Size and and Profile
		
//Get facilities and Services
		
//Get Accreditations
		
//Get affiliations information
		
//Get Social Media information

	}

}
