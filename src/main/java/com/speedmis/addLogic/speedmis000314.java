package com.speedmis.addLogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedmis.controller.Controller;
import com.speedmis.controller.MisCommonFunction;
import com.speedmis.frontcontroller.IndexController;

public class speedmis000314 {
	


  public com.speedmis.frontcontroller.IndexController indexPage = new com.speedmis.frontcontroller.IndexController();
  
  
  public void init(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		//String lines = "speedmis000314 에서 myname 변경시도<br>";
		//writer.println(lines);
		indexPage.$myname = "홍길동314";
		
	  
  }


  
  public void list_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  MisCommonFunction misFunc=new MisCommonFunction();
	  //indexPage.$list_word = misFunc.lcase(indexPage.$list_word) + " by 314 의 list_change_word() 소문자로!";
	  indexPage.$list_word = misFunc.lcase(indexPage.$list_word) + " by 314 의 list_change_word() 소문자로!";
  }  
  public void view_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  MisCommonFunction misFunc=new MisCommonFunction();
	  //indexPage.$list_word = misFunc.lcase(indexPage.$list_word) + " by 314 의 list_change_word() 소문자로!";
	  indexPage.$view_word = misFunc.ucase(indexPage.$view_word) + " by 314 의 view_change_word() 대문자로!";
  }

	

  
}
