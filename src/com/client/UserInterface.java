/*Test your application by invoking the service methods from the UserInterface class. 
You are free to write your own code in the main method to invoke the business methods 
to check its correctness. UserInterface class is not taken for evaluation. 
*/

package com.client;
import com.service.AcademyService;
import java.util.*;
public class UserInterface {
	public static void main(String[] args) {
		AcademyService cs = new AcademyService();
		
		Scanner sc=new Scanner(System.in);
		// The below code gets the details of candidates
		// Give input in the format as specified in the problem statement
		System.out.println("Enter the number of candidates to enroll");
		int num=sc.nextInt();
		String s[]=new String[num];
		System.out.println("Enter the candidates details");
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			s[i]=sc.nextLine();
		}
		boolean recordsInserted = cs.addCandidateList(s);
			if (recordsInserted) {
				System.out.println("Read valid candidate records and updated it to the database");
				System.out.println("Enter the admission class to search for candidate details");
				
				int c=sc.nextInt();
				
					List<String> list1=cs.getCandidateRecord(c);
					
					
					if(list1.size()==0){
						System.out.println("No record found");
					}
					else{
						for(String x:list1){
							System.out.println(x);
						}	 	  	  		    	  	      	      	 	
						
					}
			
			}
			else
				System.out.println("Fail to insert records");

	}
}
