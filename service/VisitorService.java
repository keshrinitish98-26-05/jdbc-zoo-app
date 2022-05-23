package com.ty.visitor.service;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AES;
import static com.ty.visitor.util.AppConstant.*;

import com.ty.visitor.dao.VisitorDao;

public class VisitorService
{
	VisitorDao dao=new VisitorDao();
	public int saveVisitor(Visitor visitor)
	{
		
		String encName=AES.encrypt(visitor.getName(),SECRETE_KEY);
		String encEmail=AES.encrypt(visitor.getEmail(),SECRETE_KEY);
		String encPhone=AES.encrypt(visitor.getPhone(),SECRETE_KEY);
		visitor.setName(encName);
		visitor.setEmail(encEmail);
		visitor.setPhone(encPhone);
		return dao.saveVisitor(visitor);
	}
	public Visitor getVisitorById(int id)
	{
	  Visitor visitor=dao.getVisitorById(id);
	  if(visitor!=null)
	  {
	  String decName=AES.decrypt(visitor.getName(), SECRETE_KEY);
	  String decEmail=AES.decrypt(visitor.getEmail(), SECRETE_KEY);
	  String decPhone=AES.decrypt(visitor.getPhone(), SECRETE_KEY);
	  visitor.setName(decName);
	  visitor.setEmail(decEmail);
	  visitor.setPhone(decPhone);
	  return visitor;
	  }
	  return null;
	  
	}
}
