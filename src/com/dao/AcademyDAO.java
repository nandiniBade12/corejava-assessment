package com.dao;

import com.model.Candidate;
import com.util.ApplicationUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AcademyDAO {
	
	public static Connection connection = null;

	public int insertCandidateList(List<Candidate> candidateList)
	{
		boolean recordsAdded = false;
		int count = 0;
		try {
			connection = DBConnectionManager.getConnection();
			String insertQuery = "insert into candidate values(?,?,?,?,?,?,?,?)";
			
			for(Candidate c: candidateList) {
				PreparedStatement ps = connection.prepareStatement(insertQuery);
				ps.setString(1, c.getCandidateId());
				ps.setString(2, c.getStudentName());
				ps.setString(3, c.getPhoneNumber());
				ps.setDate(4, ApplicationUtil.utilToSqlDateConverter(c.getDob()));
				ps.setInt(5, c.getAdmissionClass());
				ps.setString(6, c.getNationality());
				ps.setDouble(7, c.getEyeSight());
				ps.setDouble(8, c.getEntranceFee());
				int row = ps.executeUpdate();
				if(row>0) {
					count++;
				}
			}
			if(count>0) {
				recordsAdded = true;
			}
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return count;
	}
	
public List<Candidate> retrieveCandidateList(int admissionClass) {
	
	List<Candidate> list = new ArrayList<Candidate>();
	
	try {
		connection = DBConnectionManager.getConnection();
		String selectQuery = "select * from candidate where admission_class=?";
		
		PreparedStatement ps = connection.prepareStatement(selectQuery);
		ps.setInt(1, admissionClass);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String phoneno = rs.getString(3);
			java.util.Date date = ApplicationUtil.sqlToUtilDateConverter(rs.getDate(4));
			int admclass = rs.getInt(5);
			String nation = rs.getString(6);
			double sight = rs.getDouble(7);
			double fee = rs.getDouble(8);
			Candidate c = new Candidate(id,name,phoneno,date,admclass,nation,sight,fee);
			list.add(c);
			
		}
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
		
		return list;
	}	    

}
	 	  