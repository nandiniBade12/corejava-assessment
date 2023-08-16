package com.util;


import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.exception.InvalidCandidateException;

public class ApplicationUtil {

	public static List<String> extractDetails(String[] input) {
		
		List<String> stringList = new ArrayList<String>();
		
			for(String s : input) {
				String[] details = s.split(":");
				String nation = details[5];
				double sight = Double.parseDouble(details[6]);
				try {
					if(validateCandidateRecords(nation,sight)) {
						stringList.add(s);
					}
				} catch (InvalidCandidateException e) {
					e.printStackTrace();
				}
			}
				
		return stringList;
	}

	public static boolean validateCandidateRecords(String nationality,double eyeSight) throws InvalidCandidateException 
	{
		if(nationality.equalsIgnoreCase("Indian") && (eyeSight>=-3.5 && eyeSight<=3.5)) {
			return true;
		}
	    throw new InvalidCandidateException("Invalid Candidate records");
	}

	
	
	public static java.util.Date stringToDateConverter(String stringDate) {
		
		java.util.Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
			return null;
					
	}

	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		
		java.sql.Date sqlDate = new java.sql.Date(utDate.getTime());
		
		return sqlDate;
		
	}
	
	public static String dateToStringConverter(java.util.Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate = sdf.format(date);
		return stringDate;
		
	}

public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) {
		
		java.util.Date utDate = new java.util.Date(sDate.getTime());

			return utDate;
		}

}