package com.ty.visitor.controler;

import static com.ty.visitor.util.AppConstant.SECRETE_KEY;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.service.VisitorService;
import com.ty.visitor.util.AES;

public class Tset {
	public static void main(String[] args) {
		Visitor visitor=new Visitor();
		visitor.setId(5);
		visitor.setName("Muttu");
		visitor.setEmail("muttu@gmail.com");
		visitor.setPhone("66876552346");
		visitor.setAge(27);
		visitor.setGender("mail");
		visitor.setDob("1996-08-10"); 
		visitor.setVisitdatetime("2022-03-13");
		VisitorService visitorService=new VisitorService();
//	    int res=visitorService.saveVisitor(visitor);
//		if(res>0)
//		{
//			System.out.println("Data added");
//		}
//		else
//		{
//			System.out.println("Data not added");
//		}
		Visitor visitor2=visitorService.getVisitorById(5);
		if(visitor2!=null)
		{
		System.out.println(visitor2.getName());
		System.out.println(visitor2.getEmail());
		System.out.println(visitor2.getAge());
		}
	}

}
