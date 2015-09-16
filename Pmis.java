package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Pmis {
	private static DefaultHttpClient client = new DefaultHttpClient();

	public static List<Cookie> login(String userName,String password) {
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("doAction", "login");
			param.put("xtyh.yhxm", userName);
			param.put("xtyh.dlkl", password);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			for (Entry<String, String> entry : param.entrySet()) {
				formparams.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
			UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formparams,
					"utf-8");
			HttpPost post = new HttpPost("http://112.124.110.52/pmis/sys/login.do");
			post.setEntity(entity1);
			HttpResponse execute = client.execute(post);
			EntityUtils.consume(execute.getEntity());
			CookieStore cookieStore = client.getCookieStore();
			List<Cookie> cookies = cookieStore.getCookies();
			return cookies;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void test(String userName,String password,String content,String time,String spr) {
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("doAction", "addWdbg");
			param.put("bbg.gzdd", "370100");
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//			date = "2015-09-06";
			param.put("bbg.gzrq", date);
			param.put("bbg.bglx", "0001");
			param.put("zrbmId", "201301010030");
//			bbg.xmid:20140520113616456232 徐唯耀
//			"20140522212502443730" 许元虎
			param.put("bbg.xmid", spr);
			param.put("city", "370100");
			param.put("bbg.gzxs", time);
			param.put("bbg.gznr", content);
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			for (Entry<String, String> entry : param.entrySet()) {
				formparams.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
			UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formparams,
					"utf-8");
			HttpPost post = new HttpPost("http://112.124.110.52/pmis/bui/bggl/wdbg.do");
			post.setEntity(entity1);
			login(userName,password);
			HttpResponse execute = client.execute(post);
			result(execute);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		File file = new File("D:/work/wordspace/UAP/pmis/src/test/content");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line =  reader.readLine();
			while(line!= null){ 
				System.out.println(line); 
				list.add(line);
				line = reader.readLine();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		for(String s:list){
			System.out.println(s);
		}
		test("余超2", "123456", list.get(0), "8", "20150324100603401999");
		test("王坤", "lj+1234", list.get(1), "8", "20150324100603401999");
		test("郑佳佳", "lj+1234", list.get(2), "8", "20150324100603401999");
		test("李飞飞", "123456", list.get(3), "8", "20150324100603401999");
		test("高杰2", "lj+1234", list.get(4), "8", "20150324100603401999");
		test("曹小亮2", "lj+1234", list.get(5), "8", "20150324100603401999");
		test("高浩", "lj+1234", list.get(6), "8", "20150324100603401999");
		test("张祖迪", "lj+1234", list.get(7),"8","20150324100603401999");
		test("梅凯明2", "123456", list.get(8),"8","20150727201307465214");
	}

	public static void result(HttpResponse response) {
		try {
			HttpEntity entity = response.getEntity();
			StringBuilder result = new StringBuilder();
			if (entity != null) {
				InputStream instream = entity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						instream));
				String temp = "";
				while ((temp = br.readLine()) != null) {
					String str = new String(temp.getBytes(), "utf-8");
					result.append(str);
				}
			}
			System.out.println(result);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
