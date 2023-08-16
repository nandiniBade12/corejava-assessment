// Don't hardcode values in this class, instead read them from database.properties file
package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {

	private static Connection con = null;
	private static Properties props = new Properties();
	
	public static Connection getConnection(){
		
		try {
			FileInputStream fs = null;
			fs = new FileInputStream("database.properties");
			props.load(fs);
			
			Class.forName(props.getProperty("drivername"));
			con = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
			fs.close();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}