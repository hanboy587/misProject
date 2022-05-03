package com.speedmis.addLogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedmis.controller.Controller;
import com.speedmis.controller.MisCommonFunction;

public class speedmis000036 extends com.speedmis.frontcontroller.IndexController 
{
	


  //public com.speedmis.frontcontroller.IndexController indexPage = new com.speedmis.frontcontroller.IndexController();
  

  
  public void init(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
		
	  PrintWriter writer = response.getWriter();
	  String lines = "speedmis000036 에서 myname 변경시도<br>";
	  writer.println(lines);


		super.$myname = "이순신36";
		
	  
  }


  
  public void list_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  MisCommonFunction misFunc=new MisCommonFunction();
	  super.$list_word = misFunc.ucase(super.$list_word) + " 36 의 list_change_word() 대문자로!";
  }  
  public void view_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  MisCommonFunction misFunc=new MisCommonFunction();
	  super.$view_word = misFunc.lcase(super.$view_word) + " by 36 의 view_change_word() 소문자로!";
  }

	


  
}
