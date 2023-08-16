//Do not add or edit the code. Model class is provided as part of the code skeleton
package com.model;
import java.util.Date;
public class Candidate {
	private String candidateId;
	private String studentName;
	private String phoneNumber;
	private Date dob;
	private int admissionClass;
	private String nationality;
	private double eyeSight;
	private double entranceFee;
	
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String candidateId, String studentName, String phoneNumber, Date dob, int admissionClass,
			String nationality, double eyeSight,double entranceFee) {
		super();
		this.candidateId = candidateId;
		this.studentName = studentName;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.admissionClass = admissionClass;
		this.nationality =nationality ;
		this.eyeSight = eyeSight;
		this.entranceFee=entranceFee;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAdmissionClass() {
		return admissionClass;
	}

	public void setAdmissionClass(int admissionClass) {
		this.admissionClass = admissionClass;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public double getEyeSight() {
		return eyeSight;
	}

	public void setEyeSight(double eyeSight) {
		this.eyeSight = eyeSight;
	}

	
	
	public double getEntranceFee() {
		return entranceFee;
	}

	public void setEntranceFee(double entranceFee) {
		this.entranceFee = entranceFee;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hatsun Sainik Academy [candidateId=" + candidateId + ", studentName=" + studentName + ", phoneNumber=" + phoneNumber
				+ ", dob=" + dob + ", admissionClass=" + admissionClass + ", nationality=" + nationality+", eyeSight=" + eyeSight+", entranceFee=" + entranceFee
				+ "]";
		
	}

	
	
}
