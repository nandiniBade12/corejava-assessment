package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.AcademyDAO;
import com.model.Candidate;
import com.util.ApplicationUtil;


public class AcademyService {
	
public static List <Candidate> buildCandidateList(List<String> candidateRecords) {
		
		final String COMMADELIMITER = ":";
		List <Candidate> objectList = new ArrayList<Candidate>();
		for(String record: candidateRecords) {
			String[] details = record.split(COMMADELIMITER);
			Date date = ApplicationUtil.stringToDateConverter(details[3]);
			int admissionclass = Integer.parseInt(details[4]);
			double sight = Double.parseDouble(details[6]);
			double fee = calculateEntranceFee(admissionclass);
			Candidate cand = new Candidate(details[0],details[1],details[2],date,admissionclass,details[5],sight,fee);
			objectList.add(cand);
		}
		return objectList;
	}
	
	public boolean addCandidateList(String[] input)
	{
		boolean flag=false;
		List<String> validInputs = ApplicationUtil.extractDetails(input);
		List<Candidate> objects = buildCandidateList(validInputs);
		AcademyDAO dao = new AcademyDAO();
		int result = dao.insertCandidateList(objects);
		if(result>0) {
			flag = true;
		}
		return flag;
		
	}	 
	
	public static double calculateEntranceFee(int admissionClass)
	{
		double entranceFee=0;
		if(admissionClass>=6 && admissionClass<=8) {
			entranceFee = 2500;
		} else if(admissionClass>=9 && admissionClass<=10) {
			entranceFee = 3000;
		} else if(admissionClass>=11 && admissionClass<=12) {
			entranceFee = 3500;
		}

		return entranceFee;
	}
	public static List<String> getCandidateRecord(int admissionClass) 
	{
		List<String> stringList = new ArrayList<String>();
		String result = "";
		AcademyDAO dao = new AcademyDAO();
		List<Candidate> candidates = dao.retrieveCandidateList(admissionClass);
		for(Candidate c: candidates) {
			String date = ApplicationUtil.dateToStringConverter(c.getDob());
			String admission = String.valueOf(c.getAdmissionClass());
			String sight = String.valueOf(c.getEyeSight());
			String fee = String.valueOf(c.getEntranceFee());
			result = c.getCandidateId() + ":" + c.getStudentName() +  ":" + c.getPhoneNumber() + ":" + date + ":" + admission + ":" + c.getNationality() + ":" + sight + ":" + fee;
			stringList.add(result);
		}
		return stringList;
	}

}


	 