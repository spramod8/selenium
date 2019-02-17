package org.pramod.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("data base connection start");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
		}
		
		System.out.println("Driver registered");
		Connection con = null;
		Statement st= null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:LearnDB", "SCOTT", "pass");
			System.out.println("Connected");
			st =con.createStatement();
			ResultSet resultSet =st.executeQuery("Select count(*) from emp");
			while (resultSet.next()) {
				System.out.println("result is :::"+resultSet.getString(1));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
		}
	}

}
