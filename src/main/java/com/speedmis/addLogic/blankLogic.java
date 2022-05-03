package com.speedmis.addLogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedmis.controller.Controller;
import com.speedmis.controller.MisCommonFunction;

public class blankLogic extends com.speedmis.frontcontroller.IndexController {
	


  //public com.speedmis.frontcontroller.IndexController indexPage = new com.speedmis.frontcontroller.IndexController();
  
  
  public void init(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  
	  PrintWriter writer = response.getWriter();
		
	  String lines = "blankLogic 에서 myname 변경시도<br>";
	  writer.println(lines);
	  super.$myname = "";

	  
  }



  
  public void list_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  
	  super.$list_word = "";
  }  
  public void view_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  
	  super.$view_word = "";
  }

	


  
}
