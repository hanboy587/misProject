package com.speedmis.controller;

import java.io.IOException;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedmis.uniqueInfo.ConfigSiteinfo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;



public class MisCommonFunction {
  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static ConfigSiteinfo configSiteinfo = new ConfigSiteinfo();


	public static String $gzip_YN = "";
	public static String connectionUrl = "";
	
  public void init(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {

	  $gzip_YN = "N";
	  
  }
  
  public String lcase(String $str) { // key=>/memberList.do
	  return $str.toLowerCase();
  }
 
  
  public String ucase(String $str) { // key=>/memberList.do
	  return $str.toUpperCase();
  }

  public String requestVB(HttpServletRequest request, HttpServletResponse response, String $arg)
			throws ServletException, IOException {
	  
	  String $r = request.getParameter($arg);
	  if($r==null) $r = "";
	  return $r;
  }


	public static <T> T iif(boolean test, T ifTrue, T ifFalse) {
	    return test ? ifTrue : ifFalse;
	}
	

	public String onlyOnereturnSql(String $p_sql) {

		//@Select($sp_sql)
		//List<Member> findAll();
		//System.out.println(jdbcTemplate.query($p_sql, null));
		//return jdbcTemplate.queryForMap(query, seq);


	//jdbc:sqlserver://ms1901.gabiadb.com:1433;databaseName=speedmiscom
		
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
	    connectionUrl = configSiteinfo.connectionUrl;
	    String result = "";
		
	    try (Connection connection = DriverManager.getConnection(connectionUrl);) {
	        // Code here.
	          Statement stmt = connection.createStatement();
	          ResultSet rs = stmt.executeQuery($p_sql);
	          int ii = 0;
	          
	          while (rs.next() && ii==0) {
	        	  result = rs.getString(1);
	        	  ++ii;
	          }           
	        rs.close();
	        stmt.close();
	        connection.close();
	    }
	    // Handle any errors that may have occurred.
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
        return result;
		
		//return "zzzz";
	}
    

	
	public JSONArray allreturnSql(String $p_sql) {

	//String jsonString = "{\"name\":\"StudyingAzae\",\"job\":\"Gamer\",\"age\":\"3\"}";
	
	//JSONObject jObject = new JSONObject(jsonString);
	//System.out.println(jObject.toString());

        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        
	    String connectionUrl =
	            "jdbc:sqlserver://ms1901.gabiadb.com:1433;"
	                    + "database=speedmiscom;"
	                    + "user=speedmiscom;"
	                    + "password=djajsk!!00fw;";


		JSONArray   jary    = new JSONArray();
	    try (Connection connection = DriverManager.getConnection(connectionUrl);) {
	    	
	    	
	        // Code here.
	          Statement stmt = connection.createStatement();
	          ResultSet rs = stmt.executeQuery($p_sql);

	          while (rs.next()) {
				JSONObject obj = new JSONObject();
                ResultSetMetaData rsmd = rs.getMetaData();
                int total_rows = rsmd.getColumnCount();
                for (int i=0; i<total_rows; i++)
                {
                    String columnName = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    obj.put(columnName, columnValue);
                    System.out.println(obj);
                }
                jary.add(obj);
	          }           
	        rs.close();
	        stmt.close();
	        connection.close();
	    }
	    // Handle any errors that may have occurred.
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
        return jary;
	}
	
	public String jsonReturnSql(String $p_sql) {
		return allreturnSql($p_sql).toString();
	}

		

	public String replace(String $arg1,String $arg2,String $arg3) {
		System.out.println($arg1);
		return $arg1.replace($arg3,$arg1);
	}

	public String[] splitVB(String $p1, String $p2) {
		return $p1.split($p2);
	}

	public String GubunIntoRealPid(String $p_gbn) {
		String $sql = "select RealPid FROM MisMenuList WHERE useflag='1' and idx='" + $p_gbn + "';";
		return onlyOnereturnSql($sql);
	}
	
	// public String is_date(String $str) {
	// 	String H;
	// 	String.format(1,1);
	// 	H = """
				
	// 			""";
	// 	return "";
	// }

	// function is_date( $str ) {
	// 	$d = date('Y-m-d', strtotime( $str ));
	// 	return $d == $str;
	// }
/*
	public String gzecho(String $p_data) {
		String $gzip_YN, $jsonUrl, $full_site;
		GZIPOutputStream gzencode = new GZIPOutputStream();
		
		if(requestVB("", "", "remote" )=="Y") System.out.println($p_data);
		else if($gzip_YN=="Y" && $jsonUrl.contains($full_site)==false) System.out.println(gzencode($p_data));
		else if($gzip_YN=="Y") System.out.println(gzencode($p_data));
		else System.out.println($p_data);

		gzencode.close();

	}

	*/

	// function gzecho($p_data) {
	// 	global $gzip_YN, $jsonUrl, $full_site;
	// 	if(requestVB('remote')=='Y') echo $p_data;
	// 	else if($gzip_YN=='Y' && InStr($jsonUrl,$full_site)==0) echo gzencode($p_data);
	// 	else if($gzip_YN=='Y') echo gzencode($p_data);
	// 	else echo $p_data;
	// }
	
}
