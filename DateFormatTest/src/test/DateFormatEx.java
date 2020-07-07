package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx {
	public static void main(String[] args) {
		
		// "2020-05-25" : 전달파라미터의 형식 String
		String param = "2020-05-25";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try { 
			// String -> java.util.Date
			Date d = format.parse(param);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("---------------------------");
		
		// java.util.Date -> String
		String nowStr = format.format(new Date());
		System.out.println(nowStr);
	}
}