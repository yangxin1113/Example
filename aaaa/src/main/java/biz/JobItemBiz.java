package biz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.CommonException;
import bean.JobItem;
import studenthelp.URLUtil;


/**
 * ����NewItem��ҵ����
 * @author zhy
 * 
 */
public class JobItemBiz
{
	/**
	 * ҵ�硢�ƶ����Ƽ���
	 * 
	 * @param htmlStr
	 * @return
	 * @throws CommonException 
	 */
	public List<JobItem> getJobItems(int cursor, int catId, int areaId) throws CommonException
	{
		String urlStr = URLUtil.generateUrl(cursor, catId, areaId);
		
		//String htmlStr = DataUtil.doGet(urlStr);
		
		List<JobItem> JobItems = new ArrayList<JobItem>();
		JobItem JobItem = null;
		
		//Document doc = Jsoup.parse(htmlStr);
		Document doc = null;
		try {
			doc = Jsoup.connect(urlStr).timeout(5000).get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements pts = doc.getElementsByClass("pt");
		//System.out.println(pts.toString());
		//System.out.println(pts.toString());
		for (int i = 0; i < pts.size(); i++)
		{
			JobItem = new JobItem();
			JobItem.setId(i+1);
			JobItem.setCursor(cursor);
			JobItem.setCatId(catId);
			JobItem.setAreaId(areaId);
			
			Element pt_ele = pts.get(i);
			
			Element pt_title_ele = pt_ele.getElementsByClass("pt-title-wrapper").get(0);
			Element pt_a_ele = pt_title_ele.child(0);
			
			String title = pt_a_ele.text();
			String href = pt_a_ele.attr("href");
			JobItem.setLink(href);
			JobItem.setTitle(title);
			
			
			Element time_ele = pt_ele.getElementsByClass("pt-time").get(0);
			String date = time_ele.text();
			JobItem.setDate(date);

			Element addr_ele = pt_ele.getElementsByClass("pt-address").get(0);// 
			String address = addr_ele.text();
			JobItem.setAddress(address);
			
			Element salary_b_ele = pt_ele.getElementsByClass("b").get(0);
			Element sqlary_ele = salary_b_ele.child(0);
			String salary = sqlary_ele.text();
			JobItem.setSalary(salary);
			
			Element jobstatus_ele=null;
			//jobstatus_ele = pt_ele.getElementsByClass("pt-open").get(0);
			Elements pt_right_inner_wrapper_ele = pt_ele.getElementsByClass("pt-right-inner-wrapper");
			Elements pt_right_inner_wrapper = new Elements();
		    for (Element e : pt_right_inner_wrapper_ele) {
		        for (Element eChild : e.children()) {
		        	pt_right_inner_wrapper.add(eChild);
		        }
		    }
			
			
			//System.out.println(pt_right_inner_wrapper_ele.toString());
			if(pt_right_inner_wrapper.hasClass("pt-close"))
				jobstatus_ele = pt_ele.getElementsByClass("pt-close").get(0);
				//System.out.println("有");
			else if(pt_right_inner_wrapper.hasClass("pt-open"))
				//System.out.println("无");
				jobstatus_ele = pt_ele.getElementsByClass("pt-open").get(0);
			else
				jobstatus_ele = pt_ele.getElementsByClass("pt-full").get(0);
			String jobstatus = jobstatus_ele.text();
			JobItem.setJobstatus(jobstatus);
			try
			{// ����û��ͼƬ
				Element img_ele = pt_ele.child(1);
				String imgLink = img_ele.attr("src");
				JobItem.setImgLink(imgLink);
			} catch (IndexOutOfBoundsException e)
			{

			}
			JobItems.add(JobItem);
			//System.out.println("zzzzzzzz"+JobItem.toString());
		}

		return JobItems;

	}

}
