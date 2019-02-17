package org.pramod.Azure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public String getResultfromDB(String sql) {

        // Connect to database
        String hostName = "7364dpaeus2sqlstg.database.windows.net";
        String dbName = "testAzure"; //7364_MyXp_Stage//7364_DigitalPA_StageDB_Stg
        String user = "dipa7364_stage"; 
        String password = "d#7i3p6a4";
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
      
        System.out.println("Before connection");
        Connection connection = null;
        String resultfromDB = null;
        try {
			connection = DriverManager.getConnection(url);
			String schema = connection.getSchema();
	        System.out.println("Successful connection - Schema: " + schema);

	        System.out.println("Query data example:");
	        System.out.println("=========================================");
	        String selectSql = "Select count(*) from SalesLT.Address";
	        /*Select count(*) from job_history where start_date BETWEEN '13-JAN_01' and '24-JUL-06' and DEPARTMENT_ID = '60';*/
	       

	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(selectSql);
	        System.out.println("Top 20 categories:");
	        
	        /**
	        while (resultSet.next())
            {
                System.out.println("Result from AZURE HAPPY::"+resultSet.getString(1) );
            
            }*/
	        while (resultSet.next())
            {
            
	        	resultfromDB = resultSet.getString(1);
	        	System.out.println("result from DB ::::"+resultfromDB);
            }
            connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultfromDB;
        
            
        

            
        }
}
