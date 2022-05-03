package com.speedmis.uniqueInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import java.sql.*;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.Map;



import com.speedmis.uniqueInfo.TopAddLogic;
import com.speedmis.controller.Controller;
import com.speedmis.controller.MisCommonFunction;

public class ConfigSiteinfo {
  

	/* 가입정보 start */
//유저수 : 500             유저수가 500이면 무한임.
public static String $full_siteID = "sdmoters";			//--- 고객등록ID, 3~8자, 알파벳으로 시작, 알파벳또는숫자
public static String $paidKey = "WTVMMlM3ZmVzK3IxL0lOWjFTRE9HQWtBMklzUVJPQzhVTmRjZUg4a2lyNXRVSVBEejlmZ2FhOHAxM0hNQlgzbHZDS3pOR0N3czQyUlloRUVsTjFKekFLNmYwL0d2eGd1dUQ4YVZWL0xsUy93VklLbXBVdXYxdlQvSCtkbXNpUlc3c01pZDFvTlNQVkJZWDV4K1VZZnlYaGFKU0RQVG9WV0FvcGpmZjRnYnpBPQ";                  //--- 구매관련인증키,무료사용기간 만료후에는 읽기전용으로만 사용가능.
public static String $base_domain = "staff.xn--c79a76jvsa611b95atyah3bl1tpwk96a.com";			//--- 포트 제외 도메인, ex: mis.mycom.co.kr
public static String $base_site = $base_domain;			//--- 포트를 포함한 도메인(포트가 80 또는 443 이면 공란), ex: $base_site = $base_domain . ":8080";
public static String $full_site = "http://" + $base_site;			//--- ssl 로그인할 경우, "http://" 을 "https://" 로 바꿀 것.
/* 가입정보 end */

public static String $base_root = "/speedmiscom/www/z_sdmoters/";			//--- 루트의 물리적 경로를 넣되, 슬래시까지 넣을 것, ex: d:/webroot/web_speedmis_v6/


public static String $RealPid_Home = "speedmis000988";			//--- 메인페이지 설정, 미리 바꿀 필요 없음.
public static String $pwdKey = "speed@mis";			//--- 비밀번호 저장 시, 해독키, 5자 ~ 20자(공백제외)


public static String $intrannet_name = "사내 업무 시스템";			//--- 웹브라우저 고정 타이틀 문구.
public static String $allKill_pw = "12341234";			//--- 비상시, allKill_pw 의 값을 넣으면 어느 ID 로든지 로그인 됨, 단 사용자가 텔레그램 설정했으면 통보됨.
public static String $kendoCulture = "ko-KR";			//--- 화면 인터페이스 언어, ko-KR, en-US 등으로 선택.
public static String $send_admin_mail = "";
public static String $telegram_bot_name = "sdmoters_bot";			//push 서비스용 텔레그렘 봇 name, 도메인_bot 형태 권장, 도메인은 쩜 대신 언더바로.
public static String $telegram_bot_token = "5287590645:AAGZ92QXG3EBiLA1-pd6KStbptVQGB5OiUM";			//push 서비스용 텔레그램 봇 token.

public static String $os = "linux";
/* 기본DB서버 정보*/
public static String $MS_MJ_MY = "MJ";			//--- 메인서버는 항상 MSSQL 임. JSON 지원하는 2016버전 이상이면 MJ 이전버전이면 MS 넣을 것.
public static String $MS_MJ_MY2 = "";

public static String connectionUrl =
"jdbc:sqlserver://ms1901.gabiadb.com:1433;"
		+ "database=speedmiscom;"
		+ "user=speedmiscom;"
		+ "password=djajsk!!00fw;";

public static String connectionUrl2 = "";
//public static String $externalDB = [];

/* 2차 DB서버 list */





/* 전체프로그램에서 공통으로 사용할 사용자 정의 함수 또는 공용함수 내의 옵션조정용 */ 
  public void init(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {

			//TopAddLogic topAddLogic = new TopAddLogic();
			//topAddLogic.init(request, response);
  }
  
}
