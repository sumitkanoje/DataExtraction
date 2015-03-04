import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseThree {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args) throws IOException {
		// TODO Auto-generated method stub
		Document doc;
		
		//doc = Jsoup.connect("http://www.4icu.org/reviews/12299.htm").userAgent("Mozilla").get();
		
		doc = Jsoup.connect(args).userAgent("Mozilla").get();
				
//Get General Information		
		Elements sections = doc.select("div.section.group");
		Element temp = sections.get(6);
		Elements uname = temp.select("h5 a b");
		//System.out.print("\nName: "+uname.text());
		Elements ulink = temp.select("h5 a");
		System.out.print(",Link: "+ulink.attr("href"));
		Elements acronym = temp.getAllElements();
		try{
			acronym = temp.select("acronym");
		}catch(Exception e){
			acronym.val("?");
			}finally{
				
		}
		System.out.print(",Acronym: "+acronym.text());
		Element year = temp.select("tr td h5").get(2);
		System.out.print(",Year:"+year.text());
		
//Get Location Information
		temp = sections.get(8);
		Elements uaddr = temp.select("td[width=75%]");
		System.out.print(",Addr: "+uaddr.text());
				
		Elements dump = temp.select("h5");
		Element prange = dump.get(4);
		Element uphone = dump.get(5);
		Element ufax =	dump.get(6);
		System.out.print(",Pop Range: "+prange.text());
		System.out.print(",Telephone: "+uphone.text()); 
		System.out.print(",Fax: "+ufax.text());

//Get Course Information		
//This code extracts course information from Table
//So You Will Have to implement for loop inside this to print all courses available in a university.
//I have used .first() function which retrieves only first course from Table
		Elements raw = doc.select("tr:has(img[src=/i/1b.gif])");

		for(Element coursse: raw){
			Elements coursename = coursse.select("a.tooltip");
			System.out.print(",Course: "+coursename.get(0).childNode(0));
			Elements coursetypes = coursse.select("img[src=/i/1b.gif]");
			for(Element coursetype: coursetypes){
				System.out.print(" "+coursetype.attr("alt"));
			}
		}
		
//Get Tuition Fees Range
		
		temp = sections.get(12);
		Elements fees = temp.select("tr td[align=center] h6");
		System.out.print(",Fees: "+fees.text());
//Get Admissions Information
		temp = sections.get(14);
		Elements adinfo = temp.select("h5");
		System.out.print(",Admissions: "+adinfo.text());
//Get Size and and Profile
		temp = sections.get(17);
		Elements spinfo = temp.select("h5");
		System.out.print(",Size & Profile: "+spinfo.text());
//Get facilities and Services
		temp = sections.get(19);
		Elements fsinfo = temp.select("h5");
		System.out.print(",Facilities: "+fsinfo.text());
//Get Accreditations
		temp = sections.get(22);
		Elements accinfo = temp.select("h5");
		System.out.print(",Accrediations: "+accinfo.text());
//Get affiliations information
		temp = sections.get(24);
		Elements affinfo = temp.select("h5");
		System.out.print(",Affiliations: "+affinfo.text());
//Get Social Media information
		temp = sections.get(28);
		Elements socinfo = temp.select("div.col.span_2_of_2");
		Elements slinks = socinfo.select("a[href]");
		System.out.print(",Social Media: "+socinfo.text()+","+slinks.text()+","+slinks.attr("href"));
		
//Print Complete Information
		System.out.println();

	}

}
