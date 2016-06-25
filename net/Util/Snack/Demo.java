package net.Util.Snack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo{
	/*
	 * ��ӡ����ҳ
	 */
	public static String getHttp(String urlstr){
		StringBuilder sb = new StringBuilder();
		try{
		URL url = new URL(urlstr);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("utf-8")));
		String temp = "";
		while((temp=reader.readLine())!=null){
			sb.append(temp);
		}
		}catch(Exception e ){
		}
		return sb.toString();
	}
	/*
	 * ȡ����ַ
	 */
public static List<String> setHttp2(String asd){
		
		String dest = getHttp(asd);
		//Pattern p = Pattern.compile("<a[\\s\\S]+</a>");
		Pattern p = Pattern.compile("href=\"(http://www.douyu.[\\w\\s./:]+?)\"");
		Matcher m = p.matcher(dest);
		List<String> result = new ArrayList<String>();
		while(m.find()){
			result.add(m.group(1));
		}
		return result;
	}
	public static List<String> setHttp(String asd){
		
		String dest = getHttp(asd);
		//Pattern p = Pattern.compile("<a[\\s\\S]+</a>");
		Pattern p = Pattern.compile("href=\"(http[\\w\\s./:]+?)\"");
		Matcher m = p.matcher(dest);
		List<String> result = new ArrayList<String>();
		while(m.find()){
			result.add(m.group(1));
		}
		return result;
	}
	/*
	 * �ڶ��α���
	 * 
	 */
	public static void gogoing(String str){
		List<String> result = setHttp(str);
		for (String temp : result){
			System.out.println(temp);
			List<String> result2 = setHttp2(temp);
				for(String temp2 : result2){
					System.out.println(temp2);
				}
		}
	}
	
	public static void main(String[] args) {
		String asd = "http://www.douyu.com";
			gogoing(asd);
	
	}
		
}