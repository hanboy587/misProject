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
import com.speedmis.controller.ListInc;
import com.speedmis.controller.ViewInc;
import com.speedmis.uniqueInfo.ConfigSiteinfo;

@RestController
@RequestMapping("/_mis/list_json.php")
public class ListJsonController {


    public static String $strsql = "";
	public static String $myname = "미정";
	public static String $gubun = "";
	public static String $RealPid = "";
	public static String $logicPid = "";
	public static String $MisJoinPid = "";
	public static String $parent_RealPid = "";
	public static String $idx = "";
    
    public static String $sql = "";
    public static String $ActionFlag = "";
    public static String $devQueryOn = "";
    public static String $gzip_YN = "";
    public static String $app = "";
    public static String $MS_MJ_MY = "";
	public static String $MS_MJ_MY2 = "";
    public static String $addDir = "";
    public static String $remote_MS_MJ_MY = "";
    public static String $MisSession_UserID = "";
    

    public HttpServletRequest $request;
    public HttpServletResponse $response;

    public static ConfigSiteinfo configSiteinfo = new ConfigSiteinfo();

	@GetMapping("")
	public void requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET");
        response.addHeader("Access-Control-Allow-Headers", "origin, x-requested-with");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        
        $request = request;
        $response = response;
        
	
        PrintWriter writer = response.getWriter();
        MisCommonFunction misFunc=new MisCommonFunction();
        misFunc.init(request, response);

        $ActionFlag = requestVB("ActionFlag");
        $devQueryOn = "N";
        $gzip_YN = "N";
        
        $app = requestVB("app");
        
        /*
        if (isset($_COOKIE['devQueryOn'])) {
            $devQueryOn = $_COOKIE['devQueryOn'];
        } //else $devQueryOn = requestVB("devQueryOn");
        if($devQueryOn!='Y' && InStr($app,'download')==0) {
            header('Content-Encoding: gzip");
            $gzip_YN = 'Y';
        }
        */
        
        if($MS_MJ_MY=="MY") $addDir = "MY"; else $addDir = "";
        
        String $resultQuery = "";
        String $resultCode = "success";
        String $afterScript = "";
        String $appSql = "";
        
        
        $MisSession_UserID = "gadmin";
        //accessToken_check();
        String $MSUI = requestVB("MSUI");
        if($MSUI!="") $MisSession_UserID = $MSUI;
        
        
        $RealPid = requestVB("RealPid");
        $MisJoinPid = requestVB("MisJoinPid");
        if($MisJoinPid=="") $logicPid = $RealPid; else $logicPid = $MisJoinPid;
        $remote_MS_MJ_MY = requestVB("remote_MS_MJ_MY");
        
        
        if($MS_MJ_MY=="MY") {
            $sql = "select concat(ifnull(g08,''),'@',ifnull(dbalias,'')) from MisMenuList where RealPid='" + $logicPid + "'";
        } else {
            $sql = "select isnull(g08,'')+'@'+isnull(dbalias,'') from MisMenuList where RealPid='" + $logicPid + "'";
        }
        System.out.println($sql);
        System.out.println(misFunc.onlyOnereturnSql($sql));
        String[] $temp = misFunc.splitVB(misFunc.onlyOnereturnSql($sql)+"default","@");
        
        String $table_m = $temp[0];
        String $dbalias = $temp[1];
        //System.out.println($dbalias);
        

        String $isnull = "isnull";
        
        if($dbalias=="default") $dbalias = "";
        else if($dbalias=="" && $MS_MJ_MY=="MY") {
            $dbalias = "1st";
            $MS_MJ_MY2 = "MY";
            $isnull = "ifnull";
        }
        


        
        //connectDB_dbalias($dbalias);
        
        if($MS_MJ_MY2=="MY") {
            $isnull = "ifnull";
        } else if($remote_MS_MJ_MY=="MY") {
            $isnull = "ifnull";
            $MS_MJ_MY = $MS_MJ_MY2;
            /*
            $DbServerName = $DbServerName2;
            $base_db = $base_db2;
            $DbID = $DbID2;
            $DbPW = $DbPW2;*/
            misFunc.connectionUrl = configSiteinfo.connectionUrl2;
        } else {
            $isnull = "isnull";
        }
        


        String $alldata = "";
        
        
     
        String $flag = requestVB("flag");
        String $ChkOnlySum = requestVB("ChkOnlySum");
        String $parent_gubun = requestVB("parent_gubun");
        
        if ($parent_gubun!="") {
            $parent_RealPid = misFunc.GubunIntoRealPid($parent_gubun);
        } else {
            $parent_RealPid = "";
        }
        System.out.println("4444");

        String $helpbox = requestVB("helpbox");
        String $sel_idx = requestVB("sel_idx");
        String $skip = requestVB("$skip");
        if($skip=="") $skip = "0"; //else $skip = $skip * 1;
        
        String $rnd = "";
        
        String $parent_idx = requestVB("parent_idx");
        
        
        String $lite = requestVB("lite");
        String $onlyCnt = requestVB("onlyCnt");
        


        /*
        if($lite=='Y' && $flag=='modify') {
            gzecho($_GET['$callback'] + '({
                "d" : {
                "results":
                []
                }
                }
                )");
            exit;
        }
        */

        
        String $grid_load_once_event = requestVB("grid_load_once_event");
        String $chartKey = requestVB("chartKey");
        String $chartNumberColumns = requestVB("chartNumberColumns");
        String $chartOrderBy = requestVB("chartOrderBy");
        String $chartTop = requestVB("chartTop");
        if($chartTop=="") $chartTop = "15";
        
        String $resultMessage = "";
        String $recently = "";
        String $allFilter = "";
        String $selField = "";
        String $selValue = "";
        String $isDeleteList = requestVB("isDeleteList");      //경우에 따라 post / get
        
        System.out.println("6666");

        String $backup = requestVB("backup");
        String $filter = requestVB("$filter");  //사용자 로직에서만 사용함.
        
        
        if (requestVB("allFilter")!="") {
            $allFilter = requestVB("allFilter");
            $allFilter = misFunc.replace(misFunc.replace($allFilter, "@nd;", "&"), "@per;", "%");
            $recently = requestVB("recently");
            
            $allFilter = "{\"entries\":" + $allFilter + "}";
        
        } else {
            $selField = requestVB("selField");
            $selValue = requestVB("selValue");
            $selValue = misFunc.replace(misFunc.replace($selValue, "@nd;", "&"), "@per;", "%");
            $recently = requestVB("recently");
        }
        
        $idx = requestVB("idx");
        String $idx_aliasName = requestVB("idx_aliasName");
        


        /* 서버 로직 start */
        //if(file_exists('../_mis_addLogic' + $addDir + '/' + $logicPid + '.php')) include '../_mis_addLogic' + $addDir + '/' + $logicPid + '.php';
        
        String $use_templete = "";
        /*
        if(function_exists("view_templete")) {
            $use_templete = 'Y';
        } else {
            */
            $use_templete = "N";
        //}

        /*
        if(function_exists("jsonUrl_index")) {
            $remote_MS_MJ_MY = $MS_MJ_MY;
            jsonUrl_index();
        
            if($jsonUrl!="") {
                
                if(InStr($jsonUrl, $full_site)==0) {
                    $remote_url = explode('/_mis',$jsonUrl)[0] + $ServerVariables_URL;
                    if(InStr($remote_url,'&recently=')==0 && $recently!="") $remote_url = $remote_url + '&recently=' + $recently;
                    if(InStr($remote_url,'&$orderby=')==0 && requestVB("$orderby')!="") $remote_url = $remote_url + '&$orderby=' + requestVB("$orderby");
                    if(InStr($remote_url,'&top=')==0 && requestVB("$top')!="") $remote_url = $remote_url + '&$top=' + requestVB("$top");
                    //if($devQueryOn=='Y') $remote_url = $remote_url + '&devQueryOn=Y';
                    
                    //gzecho($remote_url);exit;
                    if($recently!="" && InStr($ServerVariables_URL, 'recently=')==0) {
                        $remote_url = $remote_url + "&$recently=$recently";
                    }
                    if($remote_MS_MJ_MY=="MY") {
                        $remote_url = $remote_url + '&remote_MS_MJ_MY=MY';
                    }
                    $remote_url = $remote_url + '&remote=Y';
                    gzecho(file_get_contents_new($remote_url));
                    exit;
                }
            }    
        }
        */

        System.out.println("aaa");
        
        String $callback = requestVB("$callback");
        if($callback=="") $callback = requestVB("callback");
        if($flag=="readResult") {
        
        } else if ($callback!="") $alldata = $alldata + $callback;
        else return;
        
        
        System.out.println("bbb");
        
        /*
        if(function_exists("list_json_init")) {
            list_json_init();
        }
        */
        
        /* 서버 로직 end */
        
        
        
        if($flag!="readResult") $alldata = $alldata + "(";
        
        if($flag!="update") { 
            
            if($flag!="readResult") { 
                    $alldata = $alldata + "{" + "\n" +
        "\"d\" : {" + "\n" +
        "\"results\":\"" + "\n"
        ;
            }
        }
        
        
        if($helpbox!="") {
            //$strsql = helpbox_sql($logicPid, $helpbox, 'list_json");
        } else if($MS_MJ_MY=="MY") {
            /*
            $strsql = "
            select 
            m.menuName
            ,ifnull(g01,'') as g01
            ,ifnull(g04,'') as g04
            ,ifnull(g05,'') as g05
            ,ifnull(g06,'') as g06
            ,ifnull(g07,'') as g07
            ,ifnull(g08,'') as g08
            ,ifnull(g09,'') as g09
            ,ifnull(g10,'') as g10
            ,ifnull(g11,'') as g11
            ,ifnull(g12,'') as g12
            ,ifnull(g13,'') as g13
            ,ifnull(dbalias,'') as dbalias
            ,aliasName
            ,Grid_Columns_Title
            ,SortElement as SortElement 
            ,ifnull(Grid_FormGroup,'') as Grid_FormGroup
            ,ifnull(Grid_Columns_Width,'') as Grid_Columns_Width
            ,ifnull(Grid_Align,'') as Grid_Align
            ,ifnull(Grid_Orderby,'') as Grid_Orderby
            ,ifnull(Grid_MaxLength,'') as Grid_MaxLength
            ,ifnull(Grid_Default,'') as Grid_Default
            ,ifnull(Grid_Select_Tname,'') as Grid_Select_Tname
            ,ifnull(Grid_Select_Field,'') as Grid_Select_Field
            ,ifnull(Grid_GroupCompute,'') as Grid_GroupCompute
            ,ifnull(Grid_CtlName,'') as Grid_CtlName 
            ,ifnull(Grid_IsHandle,'') as Grid_IsHandle
            ,ifnull(Grid_Schema_Validation,'') as Grid_Schema_Validation
            ,ifnull(Grid_PrimeKey,'') as Grid_PrimeKey
            ,ifnull(Grid_Alim,'') as Grid_Alim
            ,ifnull(Grid_Pil,'') as Grid_Pil
            ,ifnull(Grid_Schema_Type,'') as Grid_Schema_Type
            from MisMenuList_Detail d
            left outer join MisMenuList m on m.RealPid=d.RealPid
            where (d.sortelement<>999 or ifnull(d.Grid_Select_Field,'')!="") and ifnull(d.aliasName,'')<>'' and d.RealPid='" + $logicPid + "'  
            order by sortelement;
            ";
            
            if($ActionFlag=='write' && ($idx!="0" || $idx!="")) {
                //참조입력일 경우, 첨부파일은 끌어오지 않는다.
                $strsql = str_replace('where d.RealPid', "where ifnull(d.Grid_CtlName,'')<>'attach' and d.RealPid",$strsql);
            }
            */
        } else {
            
            $strsql = String.join("\n"
            ,"select "
            ,"m.menuName "
            ,",m.g01 "
            ,",m.g04 "
            ,",m.g05 "
            ,",m.g06 "
            ,",m.g07 "
            ,",m.g08 "
            ,",m.g09 "
            ,",m.g10 "
            ,",m.g11 "
            ,",m.g12 "
            ,",m.g13 "
            ,",m.dbalias "
            ,",d.aliasName "
            ,",d.Grid_Columns_Title "
            ,",d.SortElement "
            ,",d.Grid_FormGroup "
            ,",d.Grid_Columns_Width "
            ,",d.Grid_Align "
            ,",d.Grid_Orderby "
            ,",d.Grid_MaxLength "
            ,",d.Grid_Default "
            ,",d.Grid_Select_Tname "
            ,",case when d.Grid_Select_Tname<>'' and isnumeric(left(d.Grid_Select_Field,1))=1 then '['+d.Grid_Select_Field+']' else d.Grid_Select_Field end as Grid_Select_Field "
            ,",d.Grid_GroupCompute "
            ,",d.Grid_CtlName  "
            ,",d.Grid_IsHandle "
            ,",d.Grid_Schema_Validation "
            ,",d.Grid_PrimeKey "
            ,",d.Grid_Alim "
            ,",d.Grid_Pil "
            ,",d.Grid_Schema_Type "
            ,"from MisMenuList_Detail d "
            ,"left outer join MisMenuList m on m.RealPid=d.RealPid "
            ,"where (d.sortelement<>999 or d.Grid_Select_Field!='') and d.aliasName<>'' and d.RealPid='" + $logicPid + "'   "
            ,"order by sortelement"
            );
            
            if($ActionFlag=="write" && ($idx!="0" || $idx!="")) {
                //참조입력일 경우, 첨부파일은 끌어오지 않는다.
                $strsql = misFunc.replace($strsql, "where d.RealPid", "where d.Grid_CtlName<>'attach' and d.RealPid");
            }
            
        }
        

        
        try {

            
        	Class<?> realLogic = Class.forName("com.speedmis.addLogic."+misFunc.iif($RealPid!="", $RealPid, "blankLogic"));
        	
            Object object = realLogic.getConstructor().newInstance();
            
        	Object[] methodParamObject = new Object[] {request, response};
        	Method method_init = object.getClass().getMethod("init", HttpServletRequest.class, HttpServletResponse.class);
            method_init.invoke(object, request, response);
	        

        	
        	System.out.println("indx : addLogic 처리 완료");
			
        } catch (Exception e) {
        	System.out.println("indx : addLogic 처리 오류");
        }
	

        
        //String result = misFunc.onlyOnereturnSql(sql);
        
        //writer.println("result="+result);
        
        System.out.println("888");
        //writer.println(misFunc.allreturnSql(sql));
        //writer.println("----------------------------");
        writer.println(misFunc.jsonReturnSql($strsql));
        
        System.out.println("999");
        
        /*
        List<String> list = new ArrayList<>();
        list.add("Harry");
        list.add("Sam");
        */
        
        
        //String $json = "json 출력영역";
				
				//writer.println($json);
		//return;	
	}

    public String requestVB(String $arg)
			throws ServletException, IOException {
      MisCommonFunction misFunc=new MisCommonFunction();
	  return misFunc.requestVB($request, $response, $arg);
    }

    @GetMapping(value="/test")
    public String test() {
        return "aaa";
    }


}
