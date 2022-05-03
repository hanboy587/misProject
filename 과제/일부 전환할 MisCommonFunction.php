<?php


function getReadableByte($bytes, $decimal=1)
    {
		if(!is_numeric($bytes)) return '';
        else if ($bytes >= 1024*1024*1024*1024*1024)
        {
            $bytes = number_format($bytes / 1024/1024/1024/1024/1024, $decimal) . ' PB';
        }
        else if ($bytes >= 1024*1024*1024*1024)
        {
            $bytes = number_format($bytes / 1024/1024/1024/1024, $decimal) . ' TB';
        }
        else if ($bytes >= 1024*1024*1024)
        {
            $bytes = number_format($bytes / 1024/1024/1024, $decimal) . ' GB';
        }
        else if ($bytes >= 1024*1024)
        {
            $bytes = number_format($bytes / 1024/1024, $decimal) . ' MB';
        }
        else if ($bytes >= 1024)
        {
            $bytes = number_format($bytes / 1024, $decimal) . ' KB';
        }
        else if ($bytes >= 1)
        {
            $bytes = $bytes . ' Bytes';
        }
        else
        {
            $bytes = '0 Bytes';
        }

        return $bytes;
}

function curPageURL() {
	$pageURL = 'http';
	if (isset($_SERVER["HTTPS"])) if ($_SERVER["HTTPS"] == "on") {$pageURL .= "s";}
	$pageURL .= "://".$_SERVER["SERVER_NAME"];
	if ($_SERVER["SERVER_PORT"] != "80" && $_SERVER["SERVER_PORT"] != "443") {
		$pageURL .= ":".$_SERVER["SERVER_PORT"];
	}
	$pageURL .= $_SERVER["REQUEST_URI"];
	return $pageURL;
}
function curPageSite() {
	$pageURL = 'http';
	if (isset($_SERVER["HTTPS"])) if ($_SERVER["HTTPS"] == "on") {$pageURL .= "s";}
	$pageURL .= "://".$_SERVER["SERVER_NAME"];
	if ($_SERVER["SERVER_PORT"] != "80" && $_SERVER["SERVER_PORT"] != "443") {
		$pageURL .= ":".$_SERVER["SERVER_PORT"];
	}
	
	return $pageURL;
}
function curPageDomain() {
	return $_SERVER["SERVER_NAME"];
}
function gzecho($p_data) {
	global $gzip_YN, $jsonUrl, $full_site;
	if(requestVB('remote')=='Y') echo $p_data;
	else if($gzip_YN=='Y' && InStr($jsonUrl,$full_site)==0) echo gzencode($p_data);
	else if($gzip_YN=='Y') echo gzencode($p_data);
	else echo $p_data;
}


function getCookie($cname) {
	if(isset($_COOKIE[$cname])) return $_COOKIE[$cname];
	else return '';
}
  
function arrayValue($p_result, $p_mm, $p_item) {
	if(isset($p_result[$p_mm][$p_item])) return $p_result[$p_mm][$p_item];
	else return false;
}



function encode_firewall($ajax_sql) {

	$ajax_sql = replace($ajax_sql,"union","_@uni");
	$ajax_sql = replace($ajax_sql,"getdate","_@get");
	$ajax_sql = replace($ajax_sql,"isnull","_@isn");
	$ajax_sql = replace($ajax_sql,"declare","_@dec");
	$ajax_sql = replace($ajax_sql,"like","_@li");
	$ajax_sql = replace($ajax_sql,"outer","_@ou");
	$ajax_sql = replace($ajax_sql,"left","_@le");
	$ajax_sql = replace($ajax_sql,"inner","_@in");
	$ajax_sql = replace($ajax_sql,"click","_@cl");
	$ajax_sql = replace($ajax_sql,"char","_@ch");
	$ajax_sql = replace($ajax_sql,"join","_@jo");
	$ajax_sql = replace($ajax_sql,"varchar","_@var");
	$ajax_sql = replace($ajax_sql,"convert","_@co");
	$ajax_sql = replace($ajax_sql,".dbo.","_@.d");
	$ajax_sql = replace($ajax_sql,"distinct","_@di");
	$ajax_sql = replace($ajax_sql,"and","_@an");
	$ajax_sql = replace($ajax_sql,"where","_@wh");
	$ajax_sql = replace($ajax_sql,"from","_@fr");
	$ajax_sql = replace($ajax_sql,"script","_@sc");
	$ajax_sql = replace($ajax_sql,"update","_@up");
	$ajax_sql = replace($ajax_sql,"select","_@se");
	$ajax_sql = replace($ajax_sql,"able","_@ab");
	$ajax_sql = replace($ajax_sql,"#","_@shap");
	$ajax_sql = replace($ajax_sql,"&","_@_nd");
	$ajax_sql = replace($ajax_sql,"+","_@plus");
	$ajax_sql = replace($ajax_sql,"(","_@karoA");
	$ajax_sql = replace($ajax_sql,")","_@karoB");
	$ajax_sql = replace($ajax_sql,"%","_@percent");
	$ajax_sql = replace($ajax_sql,"'","_@dda");
	$ajax_sql = replace($ajax_sql,"00","_@@@@");


	return $ajax_sql;
}
function decode_firewall($ajax_sql) {

	$ajax_sql = replace($ajax_sql,"_@@@@","00");
	$ajax_sql = replace($ajax_sql,"_@dda","'");
	$ajax_sql = replace($ajax_sql,"_@percent","%");
	$ajax_sql = replace($ajax_sql,"_@karoB",")");
	$ajax_sql = replace($ajax_sql,"_@karoA","(");
	$ajax_sql = replace($ajax_sql,"_@plus","+");
	$ajax_sql = replace($ajax_sql,"_@_nd","&");
	$ajax_sql = replace($ajax_sql,"_@shap","#");
	$ajax_sql = replace($ajax_sql,"_@ab","able");
	$ajax_sql = replace($ajax_sql,"_@se","select");
	$ajax_sql = replace($ajax_sql,"_@up","update");
	$ajax_sql = replace($ajax_sql,"_@sc","script");
	$ajax_sql = replace($ajax_sql,"_@fr","from");
	$ajax_sql = replace($ajax_sql,"_@wh","where");
	$ajax_sql = replace($ajax_sql,"_@an","and");
	$ajax_sql = replace($ajax_sql,"_@di","distinct");
	$ajax_sql = replace($ajax_sql,"_@.d",".dbo.");
	$ajax_sql = replace($ajax_sql,"_@co","convert");
	$ajax_sql = replace($ajax_sql,"_@var","varchar");
	$ajax_sql = replace($ajax_sql,"_@jo","join");
	$ajax_sql = replace($ajax_sql,"_@ch","char");
	$ajax_sql = replace($ajax_sql,"_@cl","click");
	$ajax_sql = replace($ajax_sql,"_@in","inner");
	$ajax_sql = replace($ajax_sql,"_@le","left");
	$ajax_sql = replace($ajax_sql,"_@ou","outer");
	$ajax_sql = replace($ajax_sql,"_@li","like");
	$ajax_sql = replace($ajax_sql,"_@dec","declare");
	$ajax_sql = replace($ajax_sql,"_@isn","isnull");
	$ajax_sql = replace($ajax_sql,"_@get","getdate");
	$ajax_sql = replace($ajax_sql,"_@uni","union");

	return $ajax_sql;
}

function MemberPid_XRWA($p_RealPid,$p_UserID) {
	global $MS_MJ_MY;
	if($MS_MJ_MY=='MY') {
		$temp_sql = " select concat(ifnull(table_RealPid.AuthorityLevel,0),';',ifnull(table_RealPid.userid,'')) as userid 
		FROM MisMenuList table_m 
		left outer join MisMenuList_Member table_RealPid
		on table_RealPid.RealPid=table_m.RealPid
		where table_m.RealPid='" . $p_RealPid . "' 
		and (
		ifnull(table_m.new_gidx,0)=0 
		or ifnull(table_m.AuthCode,'') in ('','01')
		or ifnull(table_RealPid.userid,'')='" . $p_UserID . "'
		)
		order by case when table_RealPid.userid='" . $p_UserID . "' then 1 else 2 end";
	} else {
		$temp_sql = " select convert(varchar(1),isnull(table_RealPid.AuthorityLevel,0))+';'+isnull(table_RealPid.userid,'') as userid 
		FROM MisMenuList table_m 
		left outer join MisMenuList_Member table_RealPid
		on table_RealPid.RealPid=table_m.RealPid
		where table_m.RealPid='" . $p_RealPid . "' 
		and (
		table_m.new_gidx=0 
		or table_m.AuthCode in ('','01')
		or isnull(table_RealPid.userid,'')='" . $p_UserID . "'
		)
		order by case when table_RealPid.userid='" . $p_UserID . "' then 1 else 2 end";
	}
	

	$r = onlyOnereturnSql($temp_sql);
	
    if($r=="") return "X";
    $r1 = splitVB($r,";")[0];
    $r2 = splitVB($r,";")[1];


    if($r1=="9") $XRWA="X";
	else if($r1=="3" && $r2==$p_UserID) $XRWA="A";
	else if($r1=="2" && $r2==$p_UserID) $XRWA="W";
	else if($r1=="0" && $r2=='') $XRWA="W";
	else $XRWA="R";

	return $XRWA;

}



function fileDelete($filepath) {
	if(file_exists($filepath)) {
		if(@unlink($filepath)){
			return true;
		} else return false;
	} else return true;
}
function fileMove($oldfile, $newfile) {

	if(file_exists($oldfile)) {
		if(!copy($oldfile, $newfile)) {
			return false;
		} else {
			if(@unlink($oldfile)){
				return true;
			} else return false;
		}
	} else return false;;
}

function aliasN_update_all() {
	global $DbServerName, $DbID, $DbPW, $base_db, $database;
	$sql = "select RealPid from MisMenuList where useflag=1 and MenuType='01' order by idx;";
	$data = allreturnSql($sql);
	$updateSql = '';

	$cnt_data = count($data);
	for($i=0;$i<$cnt_data;$i++) {
		$updateSql = $updateSql . aliasN_updateQuery_RealPid($data[$i]['RealPid']);
	}
	execSql($updateSql);
}

function aliasN_update_RealPid($p_RealPid) {
	$updateSql = aliasN_updateQuery_RealPid($p_RealPid);
	execSql($updateSql);
}

function aliasN($han) {
	if(InStr($han,",")>0) $han = splitVB($han,",")[1];
	$alias = replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace($han, " ", ""), ",", ""), "*", ""), "'", ""), "-", ""), ":", ""), "[", ""), "]", ""), "+", ""), "(", ""), ")", ""), "/", ""), ".", "");
    //$alias = urlencode($alias);
	if(is_numeric(Left($alias,1))) $alias = 'numQ' . $alias;
    $alias = Hangeul_Romaja::convert($alias, Hangeul_Romaja::CAPITALIZE_WORDS);
	$alias = replace($alias, "%", "");

	if(uni_len($alias)>len($alias)) {
		//한글외 다국어일 경우 또는 ㅋㅋㅋ 같을때.
		$alias = urlencode($alias);
		$alias = replace($alias, "%", "");
	};
    return $alias;
}



function isMobile() {
	$useragent=$_SERVER['HTTP_USER_AGENT'];


	if(preg_match('/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i',$useragent)||preg_match('/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i',substr($useragent,0,4)))

	return "Y";

	else if(InStr($useragent,"iPhone")+InStr($useragent,"iPad")>0) return "Y";

	else return "N";
}

function clean($string) {
   $string = str_replace(' ', '-', $string); // Replaces all spaces with hyphens.
   return preg_replace('/[^A-Za-z0-9\-_]/', '', $string); // Removes special chars.
}


function re_direct($url, $permanent = false) {
	global $full_site, $ServerVariables_URL;
    if (headers_sent() === false)
    {
		if(Left($url,4)!='http' && Left($full_site,5)=='https') {
			if(Left($url,1)=='/') $url = $full_site . $url;
			else {
				if(Left($url,2)=='./') $url = Mid($url, 3, 999);
				$a1 = splitVB($ServerVariables_URL,'?')[0];
				$a2 = splitVB($a1,'/')[count(splitVB($a1,'/'))-1];
				$a3 = Left($a1, Len($a1)-Len($a2));
				$url = $full_site . $a3 . $url;
				
			}
		}
        header('Location: ' . $url, true, ($permanent === true) ? 301 : 302);
    }

    exit();
}


function iif($tst,$cmp,$bad) {
	if($tst) return $cmp;
	else return $bad;
}




function ReadTextFile($filename) {
	if (file_exists($filename)) {
		$fp = fopen($filename, "r");
		if($fp) {
			if(filesize($filename)==0) return '';
			else {
				$buffer = fread($fp, filesize($filename));
				//return mb_convert_encoding(htmlspecialchars($buffer), "UTF-8", "EUC-KR");
				return $buffer;
			}
		} else return '';
		fclose($fp);
	} else return '';
}


function InStr($searchIn,$stringToSearch){
	if($stringToSearch=="") return 0;
	else {
		$x=-1;
		$x=strpos(strtoupper($searchIn),strtoupper($stringToSearch));
		if ($x>-1) return $x+1; else return 0;
	}
}

function requestVB($arg)
{
	if(isset($_POST[$arg])) {
		if($_POST[$arg]!="") return $_POST[$arg];
	} else if(isset($_GET[$arg])) {
		if($_GET[$arg]!="") return $_GET[$arg];
	} else {
		return '';
	}
}

function request_querystring($arg)
{
	return $_GET[$arg];
}

function request_form($arg)
{
	return $_POST[$arg];
}

function request_cookies($arg)
{
	if (isset($_COOKIE[$arg])) return $_COOKIE[$arg];
	else return '';
}

function POST_GET($arg)
{
	if($_POST[$arg]!="") {
		return $_POST[$arg];
	} else {
		//echo "OK POST\n";
		return $_GET[$arg];
	}
}

function left($arg1,$arg2)
{
	return mb_substr($arg1,0,$arg2,"UTF-8");
	//return substr($arg1, 0, $arg2);
}

function right($arg1,$arg2)
{
	return mb_substr($arg1,-$arg2,$arg2);
	//return substr($arg1, (strlen($arg1) - $arg2), strlen($arg1));
}

function mid($arg1,$arg2,$arg3)
{
	return mb_substr($arg1,$arg2-1,$arg3,"UTF-8");
}


function replace($arg1,$arg2,$arg3) {
	return str_replace($arg2,$arg3,$arg1);
}

function splitVB($arg1,$arg2) {
	return explode($arg2,$arg1);
}


//-----------단축url 함수. 자바스크립트도 함수이름이 같음.



function gridTxt_into_SortElement($p_RealPid, $gridTxt) {
	$temp1 = "select SortElement FROM MisMenuList_Detail WHERE useflag='1' and RealPid='" . $p_RealPid . "' and Grid_TextMatrix0='" . $gridTxt . "';";
	return onlyOnereturnSql($temp1);
}
function gridAlias_into_SortElement($p_RealPid, $aliasName) {
	$temp1 = "select SortElement FROM MisMenuList_Detail WHERE useflag='1' and RealPid='" . $p_RealPid . "' and aliasName='" . $aliasName . "';";
	return onlyOnereturnSql($temp1);
}
function gridAlias_into_Field($p_RealPid, $aliasName) {
	$temp1 = "select Grid_Select_Field FROM MisMenuList_Detail WHERE useflag='1' and RealPid='" . $p_RealPid . "' and aliasName='" . $aliasName . "';";
	return onlyOnereturnSql($temp1);
}
function gridSortElement_into_Alias($p_RealPid, $SortElement) {
	$temp1 = "select aliasName FROM MisMenuList_Detail WHERE useflag='1' and RealPid='" . $p_RealPid . "' and SortElement='" . $SortElement . "';";
	return onlyOnereturnSql($temp1);
}
function gridColumnTitle_into_Alias($p_RealPid, $Grid_Columns_Title) {
	$temp1 = "select aliasName FROM MisMenuList_Detail WHERE useflag='1' and RealPid='" . $p_RealPid . "' and Grid_Columns_Title=N'" . $Grid_Columns_Title . "';";
	return onlyOnereturnSql($temp1);
}
function gridSortElement_into_Field($p_RealPid, $SortElement) {
	$temp1 = "select Grid_Select_Field FROM MisMenuList_Detail WHERE useflag='1' and RealPid='" . $p_RealPid . "' and SortElement='" . $SortElement . "';";
	return onlyOnereturnSql($temp1);
}
//echo gridTxt_into_SortElement("speedmis000003","답변순");


function RealPidIntoGubun($p_rpd) {
	$sql = "select idx FROM MisMenuList WHERE useflag='1' and RealPid='" . $p_rpd . "';";
	return onlyOnereturnSql($sql);
}

function GubunIntoRealPid($p_gbn) {
	$sql = "select RealPid FROM MisMenuList WHERE useflag='1' and idx='" . $p_gbn . "';";
	return onlyOnereturnSql($sql);
}

function get_logicPid($p_RealPid) {
	$sql = "select RealPid from MisMenuList where RealPid='$p_RealPid' and MenuType='01'
	union
	select MisJoinPid from MisMenuList where RealPid='$p_RealPid' and MenuType='06';";
	return onlyOnereturnSql($sql);
}

function sqlValueReplace($value) {
	return replace($value,"'","''");
}

function kendoCultureIntoLANGUAGE() {
	//https://docs.microsoft.com/en-us/sql/relational-databases/system-compatibility-views/sys-syslanguages-transact-sql?view=sql-server-ver15
	global $kendoCulture;
	$kendoCultureNew = $kendoCulture;
	if(request_cookies('myLanguageCode')!='') $kendoCultureNew = request_cookies('myLanguageCode');
	$L2 = Left($kendoCultureNew,2);
	$lang = 'Korean';
	if($L2=='en') $lang = 'English';
	else if($L2=='ja') $lang = 'Japanese';
	else if($L2=='zh') $lang = 'Traditional Chinese';
	else if($L2=='de') $lang = 'German';
	return $lang;
}


function misLog($logType,$menuIdx,$query,$HTTP_REFERER,$loginId) {
	global $ServerVariables_HTTP_USER_AGENT, $ServerVariables_REMOTE_ADDR;

	$temp1 = "insert into MisLog (logType,menuIdx,query,HTTP_USER_AGENT,HTTP_REFERER,ip,wdater) values (
	'" . $logType . "'
	," . iif($menuIdx=="","null",$menuIdx) . "
	,'" . replace($query,"'","'+char(39)+'") . "'
	,'" . $ServerVariables_HTTP_USER_AGENT . "'
	,'" . $HTTP_REFERER . "'
	,'" . $ServerVariables_REMOTE_ADDR . "'
	,'" . $loginId . "'
	); ";
	execSql($temp1);

}

function is_json($string) {
    return ((is_string($string) &&
            (is_object(json_decode($string)) ||
            is_array(json_decode($string))))) ? true : false;
}


function len($str) {
  return iconv_strlen($str);
}


function uni_len($str) {
  return strlen($str);
}

function uni_left($str, $chars) {  
	return mb_substr($str, 0, $chars, 'UTF-8');
}

function console_log($str) {
  ?>
<img onerror="console.log(this.title);" src="" title="<?=$str?>" style="display:none;"/>
<script></script>
  <?php
}



/*
is_numeric 가 php 의 isNumeric 임.
*/
function is_date( $str ) {
	$d = date('Y-m-d', strtotime( $str ));
	return $d == $str;
}
function isnull($str) {
	return is_null($str);
}

function lcase($str) {
	return strtolower($str);
}

function ucase($str) {
	return strtoupper($str);
}


function getTextString($str) {

	if(isnull($str)) { 
		$str = '';
	 } else { 
		$str = replace($str,"<style>","<!--style");
		$str = replace($str,"<style","<!--style");
		$str = replace($str,"</style>","/style-->");
		$str = replace($str,"<script","<!--script");
		$str = replace($str,"</script>","/script-->");

		$str = replace($str,"<STYLE>","<!--STYLE");
		$str = replace($str,"<STYLE","<!--STYLE");
		$str = replace($str,"</STYLE>","/STYLE-->");
		$str = replace($str,"<SCRIPT","<!--SCRIPT");
		$str = replace($str,"</SCRIPT>","/SCRIPT-->");

		$str = replace($str,"/css\">","/css");

		$str = replace($str,"&nbsp;"," ");
	}

        $nLen = len($str);
        $sf = $str;
        for($qq = 1; $qq <= $nLen; $qq++) { 
                $st = InStr($qq,$str,"<");
                $ed = InStr($st+1,$str,">");
                if($st > 0 && $ed > 0) { 
                        $ds = mid($str,$st,($ed+1)-$st);
                        $sf = replace($sf,$ds,"");
                        $qq = $ed;
                } 
        } 
        return $sf;
}




function HtmlTOText_MultiLine($str) {

	$str = HtmlTOText($str);
	$str = replace($str," ","&nbsp;");
	$str = replace($str,chr(13).chr(10),"<br/>");

	return $str;
} 

function HtmlTOText($str) {

    	$str = replace($str,"<STYLE>","<STYLE><!--");
    	$str = replace($str,"</STYLE>","--></STYLE>");
    	$str = replace($str,"<SCRIPT>","<SCRIPT><!--");
    	$str = replace($str,"</SCRIPT>","--></SCRIPT>");
    	$str = replace($str,"&nbsp;"," ");
    	$str = replace($str,"</p>",chr(13).chr(10));
    	$str = replace($str,"<br>",chr(13).chr(10));
    	$str = replace($str,"<br/>",chr(13).chr(10));

	$nLen = len($str);
        $sf = $str;
        for($qq = 1; $qq <= $nLen; $qq++) { 
                $st = InStr($qq,$str,"<");
                $ed = InStr($st+1,$str,">");
                if($st > 0 && $ed > 0) { 
                        $ds = mid($str,$st,($ed+1)-$st);
                        $sf = replace($sf,$ds,"");
                        $qq = $ed;
                } 
        } 
        return $sf; 
} 
//echo HtmlTOText("aa<br/>나나나<br/><br>zzz");

function TextToHtml($temp) {
	if(isnull($temp)) $temp = '';
	$temp = replace($temp,"&nbsp;","&ampnbsp;");
	$temp = replace(replace(replace(replace(replace(replace($temp,"<","&lt;"),">","&gt;"),chr(13).chr(10),"<br>"),chr(10),"<br>")," ","&nbsp;"),chr(9),"&nbsp;&nbsp;&nbsp;&nbsp;");
	return $temp;
}
//echo TextToHtml("zzz    sss");


