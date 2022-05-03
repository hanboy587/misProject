package com.speedmis.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;


import java.util.List;
import java.lang.reflect.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.speedmis.controller.MisCommonFunction;
import com.speedmis.controller.list_inc;
import com.speedmis.controller.view_inc;


@RestController
@RequestMapping("/_mis/index.php")
public class IndexController {

	
	public static String $myname = "미정";
	public static String $gubun = "";
	public static String $RealPid = "";
	public static String $idx = "";
	public static String $list_word = "";
	public static String $view_word = "";
	public static String $gzip_YN = "";



	@GetMapping("")
	public void requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//$request = request;
		//$response = response;
		
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        MisCommonFunction misFunc=new MisCommonFunction();

		
        misFunc.init(request, response);

		
        $gzip_YN = misFunc.$gzip_YN;
        
        
		PrintWriter writer = response.getWriter();
		
		
		String lines = "index.php 의 1번째 라인.<br>MisCommonFunction.php 시작<br>MisCommonFunction.php 끝<br>		           ";
        writer.println(lines);
        

		
        $gubun = misFunc.requestVB(request, response, "gubun");
        
      
        
        $idx = misFunc.requestVB(request, response, "idx");
        
        $list_word = "list_abcDEF";
        $view_word = "view_abcDEF";
        
        
        
        if($gubun == "") {
        	writer.println("gubun 값이 없으면 안됩니다.<br>");
        	writer.println("<a href='index.php?gubun=314'>gubun=314 목록가기</a>");
        	return;
        }
          
        
        //$list_word = realLogic.lcase2($list_word);
        
        //speedmis000314 realLogic=new speedmis000314();
        //Class realLogic = Class.forName("com.speedmis.addLogic.speedmis000314");
        //com.speedmis.addLogic.speedmis000314 realLogic=new com.speedmis.addLogic.speedmis000314();
        //com.speedmis.addLogic.speedmis000314 realLogic=new com.speedmis.addLogic.speedmis000314();
        
        if($gubun!="") {
            if($gubun.equals("314")) {
            	$RealPid = "speedmis000314";
            } else if($gubun.equals("36")) {
            	$RealPid = "speedmis000036";
            } else {
            	$RealPid = "";
            }
        } else {
        	$RealPid = "";
        }

        
        
        try {

            
        	Class<?> realLogic = Class.forName("com.speedmis.addLogic."+misFunc.iif($RealPid!="", $RealPid, "blankLogic"));
        	Object object = realLogic.getConstructor().newInstance();

        	Object[] methodParamObject = new Object[] {request, response};
        	Method method_init = object.getClass().getMethod("init", HttpServletRequest.class, HttpServletResponse.class);
        	method_init.invoke(object, request, response);
	        	
        	//Method method_ttt = object.getClass().getMethod("ttt");
        	//method_ttt.invoke(object);
        	
			writer.println("<br><br>초기 list_word 는 " + $list_word + " 입니다.<br><br>");
			writer.println("초기 view_word 는 " + $view_word + " 입니다.<br><br>");
			
			if($idx!="") {
				view_inc viewInc=new view_inc();
				viewInc.main(request, response);
			} else {
				list_inc listInc=new list_inc();
				listInc.main(request, response);
			}
			
			
			//realLogic.list_change_word(request, response);
			Method method_list_change_word = object.getClass().getMethod("list_change_word", HttpServletRequest.class, HttpServletResponse.class);
			method_list_change_word.invoke(object, request, response);
		
			writer.println("나의 이름은 " + $myname + " 입니다.<br><br>");
			writer.println("gzip_YN = " + $gzip_YN + " 입니다.<br>");
			//java.io.File file = new java.io.File($fname);
	
        	System.out.println("indx : addLogic 처리 완료");
			
        } catch (Exception e) {
        	//System.out.println("indx : addLogic 처리 오류");
        }
		
		
        

		
	}

	
}
