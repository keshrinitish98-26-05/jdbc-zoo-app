package com.ty.visitor.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionObject;

public class VisitorDao {
	
	public int saveVisitor(Visitor visitor)
	{
        String sql="INSERT INTO visitor VALUES(?,?,?,?,?,?,?,?)";
	    
	    Connection connection=ConnectionObject.getConnection();
	    try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,visitor.getId());
			preparedStatement.setString(2,visitor.getName());
			preparedStatement.setString(3,visitor.getEmail());
			preparedStatement.setString(4,visitor.getPhone());
			preparedStatement.setInt(5, visitor.getAge());
			preparedStatement.setString(6, visitor.getGender());
			preparedStatement.setString(7, visitor.getDob());
			preparedStatement.setString(8,visitor.getVisitdatetime());
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    finally
	    {
	    	if(connection!=null)
	    	{
	    		try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    }
		return 0;
	}
	public Visitor getVisitorById(int id)
	{
		String sql="SELECT * FROM visitor WHERE id=?";
		Connection connection=ConnectionObject.getConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(resultSet.getString(2));
				visitor.setEmail(resultSet.getString(3));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				visitor.setDob(resultSet.getString(7));
				visitor.setVisitdatetime(resultSet.getString(8));
				return visitor;
			}
			else
				System.out.println("No such id present");
				
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return null;
	}


}
