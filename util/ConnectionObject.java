package com.ty.visitor.util;

import static com.ty.visitor.util.AppConstant.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObject {
	
	static
	{
		try
		{
		Class.forName(DRIVER);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
	}
	
	public static Connection getConnection()
	{
		
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} 
		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
