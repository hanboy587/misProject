package com.speedmis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedmis.controller.Controller;
import com.speedmis.controller.MisCommonFunction;

public class ListInc extends com.speedmis.frontcontroller.IndexController 
{
	

  //public com.speedmis.addLogic.IndexController indexPage = new com.speedmis.frontcontroller.IndexController();
  public static com.speedmis.addLogic.speedmis000314 realLogic=new com.speedmis.addLogic.speedmis000314();

  
  public void main(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		String lines = "<style>    span.title {        font-size:30px;        color: blue;        padding:50px;        display: inline-block;    }</style>					";
		writer.println(lines);

		
		lines = "<span class='title'>" + super.$myname + "</span> 에 대한 목록입니다.<br>";
		writer.println(lines);
		
		realLogic.list_change_word(request, response);
		
		
		lines = "ListInc 에서의 list_word 는 " + super.$list_word + " 입니다.<br><br>";
		writer.println(lines);
		
		
		lines = "ListInc 에서의 view_word 는 " + super.$view_word + " 입니다.<br><br>";
		writer.println(lines);
		

		 
		lines = "<a href='index.php?gubun=" + super.$gubun + "&idx=123'>123 번 내용보기</a><br><br>";
		writer.println(lines);
		
		lines = "<a href='index.php?gubun=314'>gubun=314 목록가기</a> | <a href='index.php?gubun=36'>gubun=36 목록가기</a> | <a href='index.php?gubun=999'>gubun=999 목록가기</a><br><br>			";
		writer.println(lines);
		
	  
  }



  
  public void list_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  MisCommonFunction misFunc=new MisCommonFunction();
	  //indexPage.$list_word = misFunc.lcase(indexPage.$list_word) + " by 314 의 list_change_word() 소문자로!";
	  super.$list_word = misFunc.lcase(super.$list_word) + " by 314 의 list_change_word() 소문자로!";
  }  
  public void view_change_word(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	  MisCommonFunction misFunc=new MisCommonFunction();
	  //indexPage.$list_word = misFunc.lcase(indexPage.$list_word) + " by 314 의 list_change_word() 소문자로!";
	  super.$view_word = misFunc.lcase(super.$view_word) + " by 314 의 view_change_word() 대문자로!";
  }

	

  
}
