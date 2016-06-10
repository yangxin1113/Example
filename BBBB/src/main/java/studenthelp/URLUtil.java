package studenthelp;

public class URLUtil
{

	public static final String IP = "http://www.txbb.com/w/parttime?";

	/**
	 * 获取内容
	 * @param cursor
	 * @param catId
	 * @param areaId
	 * @return
	 */
	public static String generateUrl(int cursor, int catId, int areaId)
	{
		String urlStr = IP+"&cursor="+cursor+"&catId="+catId+"&areaId="+areaId;
		System.out.println(urlStr);
		return urlStr;

	}

}
