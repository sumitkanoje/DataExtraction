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
	public static void main(String args) throws IOException {
		// TODO Auto-generated method stub
		Document doc;
		
		doc = Jsoup.connect(args).userAgent("Mozilla").get();
				
//Get General Information		
		Elements sections = doc.select("div.section.group");
		Element temp = sections.get(6);
		//Elements uname = temp.select("h5 a b");
		//System.out.print("\nName: "+uname.text());
		Elements ulink = temp.select("h5 a");
		System.out.print(",Link: "+ulink.attr("href"));
		Elements acronym = temp.getAllElements();
		try{
			acronym = temp.select("acronym");
		}catch(Exception e){
			acronym.val("?");
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
		System.out.print(",Facilities: ");
		Elements faid = temp.select("img[src=/i/_financial_aids_1.gif]");
		if(faid.size()>0){System.out.print("FAid: Yes");}else{System.out.print("FAid: Not Reported");}
		Elements abroadstudy = temp.select("img[src=/i/_study_abroad_1.gif]");
		if(abroadstudy.size()>0){System.out.print(" Abroad Program: Yes");}else{System.out.print(" Aboad Program: Not Reported");}
		Elements library = temp.select("img[src=/i/_library_1.gif]");
		if(library.size()>0){System.out.print(" Library: Yes");}else{System.out.print(" Library: Not Reported");}
		Elements sports = temp.select("img[src=/i/_sport_facilities_1.gif]");
		if(sports.size()>0){System.out.print(" Sports: Yes");}else{System.out.print(" Sports: Not Reported");}
		Elements housing = temp.select("img[src=/i/_housing_1.gif]");
		if(housing.size()>0){System.out.print(" Housing: Yes");}else{System.out.print(" Housing: Not Reported");}
		Elements distance_learning = temp.select("img[src=/i/_distance_learning_1.gif]");
		if(distance_learning.size()>0){System.out.print(" Distance Learning: Yes");}else{System.out.print(" Distance Learning: Not Reported");}
		
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
		for(Element slink: slinks){
			System.out.print(",Social Media: "+slink.text()+","+slink.attr("href"));
		}
		
//Print Complete Information
		//System.out.println();

	}

}
