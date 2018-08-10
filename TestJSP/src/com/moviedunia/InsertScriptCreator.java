package com.moviedunia;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertScriptCreator {

	public static void main(String[] args) {
		int movies = 5;
		
		String showTimes[] = { "10.00","13.00","16.00", "19.00" }; 
		SimpleDateFormat d1 = new SimpleDateFormat("YYYY-MM-D");
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		
		
		System.out.println(d1.format(dt));
		
	}

}
