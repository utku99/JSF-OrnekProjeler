/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connect() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/DB");
                        //System.out.println("DB connected");
                   return connection; 
		} catch (Exception e) {
			System.out.println(e.getMessage());
                        //System.out.println("DB failed");
                   return null;     
		}
                
	}	
}