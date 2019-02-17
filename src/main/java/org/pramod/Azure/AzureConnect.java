package org.pramod.Azure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureConnect {
	
	public static void main(String[] args) {

        // Connect to database
        String hostName = "pramodserver.database.windows.net"; // update me
        String dbName = "testAzure"; // update me
        String user = "spramod8"; // update me
        String password = "Orissa@100"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        /*
         * String url = String.format("jdbc:sqlserver://pramodserver.database.windows.net:1433;database=testAzure;user=spramod8@pramodserver;password=Orissa@100;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
         */
        System.out.println("Before connection");
        Connection connection = null;

        try {
			connection = DriverManager.getConnection(url);
			String schema = connection.getSchema();
	        System.out.println("Successful connection - Schema: " + schema);

	        System.out.println("Query data example:");
	        System.out.println("=========================================");
	        String selectSql = "Select count(*) from SalesLT.Address";
	        /*Select count(*) from job_history where start_date BETWEEN '13-JAN_01' and '24-JUL-06' and DEPARTMENT_ID = '60';*/
	        /*String selectSqlppp = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName "
	                + "FROM [SalesLT].[ProductCategory] pc "  
	                + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";*/

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
                /*System.out.println(resultSet.getString(1) + " "
                    + resultSet.getString(2));*/
	        	System.out.println("no of records :::"+resultSet.getString(1));
            }
            connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
            
        

            
        }
	}
