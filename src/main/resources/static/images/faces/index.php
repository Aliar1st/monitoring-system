 <?
include ("head_end.php");
include ("banners.php");
require("db_vars.php4");

if (isset($Email)) {

		//���� ��������
        function lfpregtrim($str) {
                 return preg_replace("/[^\x20-\xFF]/","",@strval($str));
                 }
        $error = null;
        // mail ������
        if(lfcheck_mail($Email)==false) $error = "������� ���������� ���������� Email";
        if($error == null){

			if (connect_bd()){
				$res_bd = query_bd("SELECT * FROM new_mail_list WHERE mail='$Email'");
				if (mysql_num_rows($res_bd) > "0"){
					$error = "����� Email ��� ���������������!";
					$res_bd = null;
				} else {
					$res_bd = query_bd("INSERT INTO new_mail_list VALUES ('', '$Email')");
				}
				close_bd();
			}
			$send = mail("fndesign@yandex.ru", "News Registration", $Email);
        }
}

?>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>������������� ��������������� ����� ������������ ���������� Aptech </TITLE>

<META NAME="Author" CONTENT="Fissenko N.P.">
<META NAME="Keywords" CONTENT="������ World-Wide, Aptech �������, Computer Education, ������ ���������������  �����������, ������ �����������, ������� ������������ �����, ������������� �����������, ������������� ���������������� IT-�����������, ���������������� IT-�����, ����������� �� �������, �������� �����">
<META NAME="Description" CONTENT="������� ����� ������ ���� �� ���������� � ������. �� ��������� �������������� ���� ��������������� ���������, ������������� ����� ������-������������ �������. �� ���� ����������� �������� ����������� �������� ������. �������.">

<META content="text/html; charset=windows-1251" http-equiv=Content-Type>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel=stylesheet href="stylesheet.css" type="text/css">
</HEAD>

<BODY bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0" leftmargin="0" topmargin="0" bottommargin="0">

<script>
function validate() {
        if (document.newsMail.Email.value=="E-mail") {
                alert("������� Email ����������");
                return false;
        };
        return true;
}
</script>
<?
if (isset($error)) {
?>
<script>
	alert('<?echo $error;?>');
</script>
<?	
}
if(isset($res_bd)) {
?>
<script>
	alert("������� �� �����������");
</script>
<?
}
?>

<?

head_table("news", "main");
//head_table("news", $id);

?>

<!-- versiya-dlya-slabovidyashih -->
<div style="padding-left: 5px;">
	<a href="/special" style="color: #44679e; text-decoration: none; font-size: 14px; text-transform: uppercase;"><img src="/special/versiya-dlya-slabovidyashih.png" style="width:30px"> <span style="vertical-align: super;">������ ��� ������������</span></a>
</div>

<!-- /versiya-dlya-slabovidyashih -->

<!-- ����������� ����� -->
<TABLE width="100%" cellpadding="0" cellspacing="0" border="0">
	<TR>
		<TD align="center">

		<IMG SRC="images/1.gif" WIDTH="135" HEIGHT="5" BORDER="0">

		<!-- ������� -->
<?
	show_banners();
?>
	
		<!-- / ������� -->
		</TD>
		<TD bgcolor="#F0F0F0">
		<!-- ������� ������� -->

			<TABLE width="175" cellpadding="0" cellspacing="0" border="0">
				<TR>
					<TD colspan="2"><IMG SRC="images/1.gif" WIDTH="175" HEIGHT="5" BORDER="0"></TD>
				</TR>
				<TR>
					<TD bgcolor="#124090" style="vertical-align: middle;"><DIV class="zag"><!--��������� �����--></DIV></TD>
					<TD bgcolor="#0066B2"><IMG SRC="images/1.gif" WIDTH="5" HEIGHT="20" BORDER="0"></TD>
				</TR>
				<TR>
					<TD><IMG SRC="images/1.gif" WIDTH="170" HEIGHT="5" BORDER="0"></TD>
					<TD><IMG SRC="images/1.gif" WIDTH="5" HEIGHT="5" BORDER="0"></TD>
				</TR>
				<TR>
					<TD colspan="2">


<!--<hr NOSHADE size="1">
<DIV class="f12_left"><a href="http://www.digitalwind.ru/" target="_blank"><img src="images/dw2014.png" border="0"style="margin: 5px;"/></a></DIV>

<DIV class="f12_left">
<A HREF="../news.php?id=140414"><IMG SRC="../images/mklass.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">


<A HREF="../news.php?id=270512"><IMG SRC="../images/reg.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>

<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="../gigabytereg.php"><IMG SRC="../images/gigabite.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>


<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="http://www.aptechsar.com/news.php?id=121212"><IMG SRC="../images/aptech_scidca.jpg" WIDTH="200" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="news.php?id=festreg14"><IMG SRC="images/festreg.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left"
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#16DEDE, #09B8B8);"><a href="http://digitalwind.ru/registration/masterList.php" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">"�������� �����"<br>����������� �� ������-������</span></a></p>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#874CC2, #5D17A3);"><a href="http://digital-school.net/o_start.php" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">��������� �� ���������� ��������� ����������</span></a></p>
</DIV>
<hr NOSHADE size="1"> 

<DIV class="f12_left">
<A HREF="http://www.focus-design.org/?s=reg3d" target="_blank"><IMG SRC="images/reg_3d.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">
<A HREF="../news.php?id=130415"><IMG SRC="../images/mcreg15.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="../mobile_reg.php" target="_blank"><IMG SRC="images/mobile_reg.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>

<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="/news.php?id=121015_1"><IMG SRC="images/javacourse.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">
<A HREF="/news.php?id=140515"><IMG SRC="images/ciscocourse.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="/news.php?id=050515_1"><IMG SRC="images/androidcourse.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="../roreg.php"><IMG SRC="../images/robocode.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">
<A HREF="/news.php?id=120515"><IMG SRC="images/1ccourse.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">
<A HREF="/news.php?id=121015_1"><IMG SRC="images/javacourse.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">-->

<!--<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="http://www.123contactform.com/form-2305102/-"><IMG SRC="images/reg_start.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>

<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="fest.apk"><IMG SRC="../images/app_sf_but.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>


<DIV class="f12_left">
<A HREF="http://digitalwind.ru" target="_blank"><IMG SRC="../images/dw_2017.jpg" WIDTH="180" BORDER="0" style="margin: 5px;" class="dw_ban"></A>
</div>-->


<!-- <DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:10px; border-radius:7px; background: linear-gradient(#7015C3, #590599);"><A HREF="/courses" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">����� Unity 3D</span></A></p> 
</DIV>
<hr NOSHADE size="1"> -->


<!--
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#f00, #be0000);"><a href="/courses" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">�������������� ���������������� �����������</span></a></p>
</DIV> -->


<!-- href="/courses" 
<hr NOSHADE size="1"> -->
<DIV class="f12_left">
<A HREF="http://digital-school.net/"><img src="images/dks_but.png"  width="180" border="0" style="margin: 5px;" alt="������� ������������ �����"></A>
</div>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="http://digitalwind.ru"  target="_blank"><IMG SRC="images/digitalwind_logo.png" WIDTH="180" BORDER="0" style="margin: 5px;" align="center"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#f00, #be0000);"><a href="/courses/courses2018.doc" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">������ ������ ��������������� �����������</span></a></p>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:6px; border-radius:7px; background: linear-gradient(#121212, #000000);"><A HREF="http://www.aptechsar.com/courses/programmistaptech/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">�������� �� ����������������� ��������� <span style="color: yellow"><i>"Aptech"</i></span></span></A></p>
</DIV>
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:6px; border-radius:7px; background: linear-gradient(#40ce40, #028a02);"><A HREF="http://www.aptechsar.com/courses/programmist/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">�������� ����������� ����������������</span></A></p>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding: 8px; border-radius:7px; background: linear-gradient(#1878D9, #084F9C);"><A HREF="http://www.aptechsar.com/courses/administrator/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">������� �������� �����</span></A></p>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding: 8px; border-radius:7px; background: linear-gradient(#D1611B, #D12B1B);"><A HREF="http://www.aptechsar.com/courses/designer/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">���������� ������� � ����������</span></A></p>
</DIV>


<!--<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="images/logomfpit3.png"  target="_blank"><IMG SRC="images/logodownload.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>-->

<!--<DIV class="f12_left">
<A HREF="FestScience.apk"><IMG SRC="../images/app_two_sf_but.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="3dLabels.zip">������� ����� � ������� ��� ���������� �Magic News�</A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="project.apk"><IMG SRC="../images/app_sf_but.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">-->
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="../SendQuestions.php"><IMG SRC="images/SendMyQuestion.jpg" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="http://rasp.sstu.ru/" target="_blank"><IMG SRC="../images/rasp_but.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left"><A HREF="subscriberegistration.php"><img src="images/newssub_but.png"  width="180" border="0" style="margin: 5px;"></A></DIV>

<!--<hr NOSHADE size="1">
<DIV class="f12_left" style="margin: 0; width: 210px; background: #fff; padding: 10px 0;">
<A HREF="/news.php?id=september_sales"><img src="images/september_sales.png"  width="190" border="0"></A>

</div>-->
<!--<hr NOSHADE size="1">
<DIV class="f12_left">

<IMG SRC="images/logo_fd.png" WIDTH="121"  BORDER="0" style="margin: 5px;">
<br>
����� ���������� �� ����
<br>
<A HREF="news.php?id=141015_3">�������� ����������� � ��������� Adobe Illustrator</A><br>
<br>
����������� �� ��������: <br><b>99-86-69</b>
<br>
<br>
<script type="text/javascript">
/*timeend2= new Date();
timeend2= new Date(timeend2.getYear()>1900?(timeend2.getYear()):(timeend2.getYear()+1900),10,21);

function time2() {
    today2 = new Date();
    today2 = Math.floor((timeend2-today2)/1000);
    tsec2=today2%60; today2=Math.floor(today2/60); if(tsec2<10)tsec2='0'+tsec2;
    tmin2=today2%60; today2=Math.floor(today2/60); if(tmin2<10)tmin2='0'+tmin2;
    thour2=today2%24; today2=Math.floor(today2/24);
   // timestr=today2 +" ���� "+ thour+" ����� "+tmin+" ����� "+tsec+" ������";
   daystr2 ='����';
   cut2=today2%10;
   if(today2<10||today2>20){ 
   switch (cut2) {
  case 1:
    daystr2 ='����';
    break;
  case 2: 
  case 3:
  case 4:
    daystr2 ='���';
    break;
  default:
   daystr2 ='����';
}
 }  

   timestr2=today2;
document.getElementById('t2').innerHTML=timestr2;
document.getElementById('d2').innerHTML=daystr2;
}
window.onload = time2;*/
</script>


<strong>����� � ������ ������������� ����� <span id="t2" style="font-size:20px; color: red;"></span> <span id="d2"></span></strong>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">

<A HREF="http://www.aptechsar.com/education.php?id=16"><IMG SRC="images/microsoft_imagine.png" WIDTH="180"  BORDER="0" style="margin: 5px;"></A>-->
<!--<br>
<A HREF="../education.php?id=57">����������� ��������� ���������� �������������� ������������ �����</A><br>
������ �������: <br>
<b>24 ������ 2014</b>
���� ������ ������� ��������� �� ��������: <b>99-86-69</b>
<br>
<br>-->
<script type="text/javascript">
timeend= new Date();
timeend= new Date(timeend.getYear()>1900?(timeend.getYear()):(timeend.getYear()+1900),3,19);

function time() {
    today = new Date();
    today = Math.floor((timeend-today)/1000);
    tsec=today%60; today=Math.floor(today/60); if(tsec<10)tsec='0'+tsec;
    tmin=today%60; today=Math.floor(today/60); if(tmin<10)tmin='0'+tmin;
    thour=today%24; today=Math.floor(today/24);
   // timestr=today +" ���� "+ thour+" ����� "+tmin+" ����� "+tsec+" ������";
   daystr ='����';
   cut=today%10;
   if(today<10||today>20){ 
   switch (cut) {
  case 1:
    daystr ='����';
    break;
  case 2: 
  case 3:
  case 4:
    daystr ='���';
    break;
  default:
   daystr ='����';
}
 }  

   timestr=today;
  document.getElementById('t').innerHTML=timestr;
document.getElementById('d').innerHTML=daystr;
}
//window.onload = time;
</script>


<!--<strong><a href="http://www.aptechsar.com/news.php?id=231215_1">����� � ������</a> ������������� ����� <span id="t" style="font-size:20px; color: red;"></span> <span id="d"></span></strong>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">

<img src="images/Cisco.png" width="180"  BORDER="0" style="margin: 5px;">
<br>
������� ����� �� �������� � 

<A HREF="education.php?id=cisco">������� �������� Cisco</A><br>
<br>
����������� �� ��������: <br><b>99-86-69</b>
<br>
<br>
<script type="text/javascript">
timeend3= new Date();
timeend3= new Date(timeend3.getYear()>1900?(timeend3.getYear()):(timeend3.getYear()+1900),11,16);

function time3() {
    today3 = new Date();
    today3 = Math.floor((timeend3-today3)/1000);
    tsec3=today3%60; today3=Math.floor(today3/60); if(tsec3<10)tsec3='0'+tsec3;
    tmin3=today3%60; today3=Math.floor(today3/60); if(tmin3<10)tmin3='0'+tmin3;
    thour3=today3%24; today3=Math.floor(today3/24);
   // timestr=today3 +" ���� "+ thour+" ����� "+tmin+" ����� "+tsec+" ������";
   daystr3 ='����';
   cut3=today3%10;
   if(today3<10||today3>20){ 
   switch (cut3) {
  case 1:
    daystr3 ='����';
    break;
  case 2: 
  case 3:
  case 4:
    daystr3 ='���';
    break;
  default:
   daystr3 ='����';
}
 }  

   timestr3=today3;
document.getElementById('t3').innerHTML=timestr3;
document.getElementById('d3').innerHTML=daystr3;
}
window.onload=function(){

 //time2();
 //time3();
}
</script>


<strong>����� � ������ ������������� ����� <span id="t3" style="font-size:20px; color: red;"></span> <span id="d3"></span></strong>
</DIV>
 
<hr NOSHADE size="1">

				<DIV class="f12_left">
						<a href="education.php?id=fdiz"><IMG SRC="images/arena_logo_100.jpg" WIDTH="150" HEIGHT="65" BORDER="0" style="margin: 10px 0px;"></a><br>
							<B>���������� ����� ���������� �� ��������� ��������� Arena Multimedia:</B>
							<UL>
								<LI><A HREF="education.php?id=14">��������� ���������� ������������������ ����������� �� ������������ ������� � ����������� �����������</A> <br><������ �������: <br><b>24 ������ 2014</b> ���� ������ ������� ��������� �� ��������: <b>99-86-69</b>
								<LI><A HREF="education.php?id=17">��������� ���������� Web �������</A><br>������ �������:<br><b>24 ������ 2014</b>���� ������ ������� ��������� �� ��������: <b>99-86-69</b>
							</UL>
						</DIV>
						<hr NOSHADE size="1">


<DIV class="f12_left">
	<A HREF="education.php?id=15"><IMG SRC="images/ACE_Logo.png" WIDTH="200"  BORDER="0" style="margin: 10px 0px;"></a><br>
	<!--<B>����� ���������� �� <A HREF="education.php?id=15">������a������ ��������� ���������� ������������������ ������������</A></B>
	<br> 
	����������� �� ��������: <br><b>99-86-69</b>-->
		
		<script type="text/javascript">
		timeendn= new Date();
		timeendn= new Date(timeend.getYear()>1900?(timeendn.getYear()):(timeendn.getYear()+1900),3,19);

		function time_n() {
			todayn = new Date();
			todayn = Math.floor((timeendn-todayn)/1000);
			tsecn=todayn%60; todayn=Math.floor(todayn/60); if(tsecn<10)tsec='0'+tsecn;
			tminn=todayn%60; todayn=Math.floor(todayn/60); if(tminn<10)tmin='0'+tminn;
			thourn=todayn%24; todayn=Math.floor(todayn/24);
		   // timestr=today +" ���� "+ thour+" ����� "+tmin+" ����� "+tsec+" ������";
		   daystrn ='����';
		   cutn=todayn%10;
		   if(todayn<10||todayn>20){ 
		   switch (cutn) {
		  case 1:
			daystrn ='����';
			break;
		  case 2: 
		  case 3:
		  case 4:
			daystrn ='���';
			break;
		  default:
		   daystrn ='����';
		}
		 }  

		   timestrn=todayn;
		 document.getElementById('tn').innerHTML=timestrn;
		document.getElementById('dn').innerHTML=daystrn;
		}
		window.onload=function(){
		time();
		 time_n();
		//time2();
		//  time3();
		}
		</script>

<!--<strong><a href="http://www.aptechsar.com/news.php?id=231215_2">����� � ������</a> ������������� ����� <span id="tn" style="font-size:20px; color: red;"></span> <span id="dn"></span></strong>
						
</DIV>
<hr NOSHADE size="1">
    <DIV class="f12_left"><A HREF="http://www.aptechsar.com/education.php?id=72"><img src="images/discount.png"  width="180" border="0"></A></DIV>

-->
<!--<hr NOSHADE size="1">
<DIV class="f12_left"><A HREF="registrationoncourse.php"><img src="images/regoncurse.png"  width="180" border="0"  style="margin: 5px;"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left"><A HREF="aptsubscriberegistration.php"><img src="images/iecnews.png"  width="180" border="0" style="margin: 5px;"></A>
</DIV>-->




<!--<hr NOSHADE size="1">
<DIV class="f12_left"><A HREF="<? echo graph_curses; ?>"><img src="images/courses_but.png" width="180"  border="0" style="margin: 5px;"></A></DIV>-->
<!--<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="http://www.aptechsar.com/Robots.zip"><IMG SRC="images/dopreal.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>-->
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="../education/augmented_reality.mp4"><IMG SRC="../images/but_dr.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV>
<!--<hr NOSHADE size="1">			

<DIV class="f12_left"><center>
<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
  codebase="http://active.macromedia.com/flash2/cabs/swflash.cab#version=4,0,0,0"
  ID=Untitled2 WIDTH=130 height=60>
<PARAM NAME=movie VALUE="../banners/vkontakte1.swf">
<PARAM NAME=quality VALUE=high>
<PARAM NAME=loop VALUE=true>
<param name="wmode" value="transparent" />
<EMBED src="../banners/vkontakte1.swf"  wmode="transparent" loop=true quality=high
  WIDTH=130 height=60 TYPE="application/x-shockwave-flash"
  PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash">
</EMBED>
</OBJECT>
</center>

</DIV>-->
<hr NOSHADE size="1">
<!-- <DIV class="f12_left">
<A HREF="https://www.facebook.com/groups/MFPITsstu/" target="_blank"><IMG SRC="images/facebook_but.png" WIDTH="180" BORDER="0" style="margin: 5px;"></A>
</DIV> -->
<DIV class="f12_left">
	<A HREF="https://vk.com/mfpits1stu" target="_blank"><IMG SRC="images/VK logo.png" WIDTH="45" BORDER="0" style="margin-left: 10px;"></A>
	<A HREF="https://www.facebook.com/groups/MFPITsstu/" target="_blank"><IMG SRC="images/Facebook logo.png" WIDTH="45" BORDER="0" style="margin-left: 7px;"></A>
  <A HREF="https://www.youtube.com/channel/UCK1Wnqt43iautpE6PekSWpA" target="_blank"><IMG SRC="images/youtube.png" style="width: 60px; margin-left: 5px" BORDER="0" style="margin: 0px;"></A>
</DIV>
<hr NOSHADE size="1">
<br>
				
					</TD>
				</TR>
				<TR>
					<TD><IMG SRC="images/1.gif" WIDTH="170" HEIGHT="5" BORDER="0"></TD>
					<TD><IMG SRC="images/1.gif" WIDTH="5" HEIGHT="5" BORDER="0"></TD>
				</TR>
			</TABLE>

		<!-- / ������� ������� -->
		</TD>
		<TD width="100%">
		<!-- ���������� ������� -->
		
<TABLE cellpadding="0" cellspacing="0" border="0" width="100%" style="margin: 10px 0px;">
	<TR>
		<TD><IMG SRC="images/1.gif" WIDTH="20" HEIGHT="1" BORDER="0"></TD>
		<TD width="50%">


			<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD bgcolor="#F0F0F0" colspan="2"><IMG SRC="images/title_news.gif" WIDTH="150" HEIGHT="35" BORDER="0" style="margin: 0px 0px 0px 10px;"></TD>
				</TR>
				<TR>
					<TD background="images/sq.gif"><IMG SRC="images/1.gif" WIDTH="50" HEIGHT="1" BORDER="0"></TD>
					<TD width="100%">


<DIV class="f12_colon">

<!--
<hr NOSHADE size="1">
<strong>������� ����������!</strong> ������������� ��������� �������� �������� ��������� 3 ���� � 15.00 � ������������ ����� ����

<hr NOSHADE size="1">
<strong><span style="color: red;">2 ���� � 15.00 � ��������� 422 ��������  ������� �� ��������� ���������� � ����������� � ������������ � ����� �������������� ����������</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=290618_1">[ ���������... ]</a>



<hr NOSHADE size="1">
<strong><span style="color: red;">������ ����� �� �������� �� ��������� ���������� � ����������� � ������������ � ����� �������������� ����������</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=300518_3">[ ���������... ]</a>-->

<hr NOSHADE size="1">
������� ����� ���� ��������� ������ �������
<a HREF="http://www.aptechsar.com/news.php?id=280618_1">[ ���������... ]</a>

<hr NOSHADE size="1">
������ � �������������  ����� �������� � �������� �� ������ ���������� ������
<a HREF="http://www.aptechsar.com/news.php?id=270618_2">[ ���������... ]</a>

<!--<hr NOSHADE size="1">
28 ���� �  ��������� ���������� �������������� ���������� � ������������ (�����) ������� ������������ ��� ����������� � ������������
<a HREF="http://www.aptechsar.com/news.php?id=270618_1">[ ���������... ]</a>-->


<hr NOSHADE size="1">
������� ����� � �������� ����������� ��������!
<a HREF="http://www.aptechsar.com/news.php?id=250618_1">[ ���������... ]</a>

<hr NOSHADE size="1">
������ ������ ��� ��������� ��������!
<a HREF="http://www.aptechsar.com/news.php?id=130618_2">[ ���������... ]</a>

<hr NOSHADE size="1">
����������� �������� �� ����� ������� ��������������� ��������. ������ ����� �����!
<a HREF="http://www.aptechsar.com/news.php?id=130618_1">[ ���������... ]</a>

<hr NOSHADE size="1">
� ����� ������ ������������� ������-������������ ����������� ������ � �������������� ��������: �������, �����������, �����
<a HREF="http://www.aptechsar.com/news.php?id=070618_2">[ ���������... ]</a>

<hr NOSHADE size="1">
� ����� ��������� ����������� �������������� ��������� ����� � ���� �21-� ����
<a HREF="http://www.aptechsar.com/news.php?id=080618_1">[ ���������... ]</a>

<hr NOSHADE size="1">
�������� ����� -  ������� �������� ������������ �� ������������ ��������� ��������
<a HREF="http://www.aptechsar.com/news.php?id=070618_1">[ ���������... ]</a>

<hr NOSHADE size="1">
������� ����� ����� � ������������� ��� ��������� �� ����������
<a HREF="http://www.aptechsar.com/news.php?id=040618">[ ���������... ]</a>

<hr NOSHADE size="1">
������������ ����� � ������ ������������ ����� ����!
<a HREF="http://www.aptechsar.com/news.php?id=080518_2">[ ���������... ]</a>

<hr NOSHADE size="1">
������� ���� � �������!
<a HREF="https://youtu.be/yjbEUNhV-88">[ ���������... ]</a>

<hr NOSHADE size="1">
������ ������� ���� ��������� � �������� �� ������������� ����������� � ���
<a HREF="http://www.aptechsar.com/news.php?id=250518_2">[ ���������... ]</a>

<hr NOSHADE size="1">
������ ����� �� �������� �� ����� "���������������� Lego-�������" � ������� ������������ ����� ����
<a HREF="http://www.aptechsar.com/news.php?id=190318_3">[ ���������... ]</a>

<hr NOSHADE size="1">
���� �������� � ���� ������ ����� 200 ���������
<a HREF="http://www.aptechsar.com/news.php?id=210518">[ ���������... ]</a>

<hr NOSHADE size="1">
��������������� ������� ������ �������������� � ��������� � ������������!
<a HREF="https://www.youtube.com/watch?v=8qCexQrXnZk">[ ���������... ]</a>

<hr NOSHADE size="1">
�������� ������ ������ ��������� ����������� ����������� �������� ��������� �����-2018�
<a HREF="https://www.youtube.com/watch?v=3VK8937HEz4&feature=youtu.be">[ ���������... ]</a>

<hr NOSHADE size="1">
�������� ����� � �������� ������� ����� �������� ����� ������ �������� ����� � �������� "������� 2.0."
<a HREF="http://www.aptechsar.com/news.php?id=080518_1">[ ���������... ]</a>

<hr NOSHADE size="1">
�������� ����� ������ �������� ����� � �������� ��������
<a HREF="http://www.aptechsar.com/news.php?id=070518">[ ���������... ]</a>

<hr NOSHADE size="1">
������������� ����� ������������� �� ����������� � ����������������
<a HREF="http://www.aptechsar.com/news.php?id=040518_1">[ ���������... ]</a>

<hr NOSHADE size="1">
�������� ����� �������� ������������� ����� ������������� ��������� "���������� ��������"
<a HREF="http://www.aptechsar.com/news.php?id=040518">[ ���������... ]</a>

<hr NOSHADE size="1">
� ���� ��������� ����������� �������� ��������� �����
<a HREF="http://www.aptechsar.com/news.php?id=270418_1">[ ���������... ]</a>

<hr NOSHADE size="1">
������ ����� �������� ����-��� �������� �� ������ ������-�����������
<a HREF="http://www.aptechsar.com/news.php?id=270418">[ ���������... ]</a>

<hr NOSHADE size="1">
���������� ���������� ������������ ��������� �� ���������� ��������� ����������
<a HREF="http://www.aptechsar.com/news.php?id=130418">[ ���������... ]</a>

<hr NOSHADE size="1">
����� ����� �� ���������� ����� � ���, ���� � ��� ���� � ���������
<a HREF="http://www.aptechsar.com/news.php?id=130418_1">[ ���������... ]</a>


<!--
<hr NOSHADE size="1">
���� ����� �� �������� �� ��������� ����������� �� SMM�
<a HREF="http://www.aptechsar.com/news.php?id=090418">[ ���������... ]</a>

<hr NOSHADE size="1">
<span style="color: red"><strong>��������� ����� ���������� ���������� � ��������� �� ������-������ �� IT-����������� � ���������� ������������</strong></span>
<a HREF="http://www.aptechsar.com/news.php?id=060418">[ ���������... ]</a> -->

<hr NOSHADE size="1">
������� ����� ������� ������ ���� ����������� ������ ������� ����� �� �������� ����� � ������ ������������ ����������� ������� 2018�
<a HREF="http://www.aptechsar.com/news.php?id=060418_1">[ ���������... ]</a>

<hr NOSHADE size="1">
���� ����� �� �������� �� ����������� ����������������� �� ����� ѻ
<a HREF="http://www.aptechsar.com/news.php?id=050418_1">[ ���������... ]</a>
<!--
<hr NOSHADE size="1">
����� ����������  �������������� �� ����������� ������������ MOS
<a HREF="http://www.aptechsar.com/news.php?id=050418">[ ���������... ]</a>
-->

<hr NOSHADE size="1">
���� ����� �� ����� �� ����������� ������ ����������
<a HREF="http://www.aptechsar.com/news.php?id=190318">[ ���������... ]</a>

<hr NOSHADE size="1">
���� ����� �� ����� �� ����������� ������������ ������������ ������
<a HREF="http://www.aptechsar.com/news.php?id=230318">[ ���������... ]</a>


<!--<hr NOSHADE size="1">
<strong><span style="color: blue;">���� ����� �� �������� �� ��������� �������������� ������������ �����</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=210318">[ ���������... ]</a>

<hr NOSHADE size="1">
���������� ���������� ������������� ������������� ����� �������� ��������� �����-2018�
<a HREF="http://www.aptechsar.com/news.php?id=200318">[ ���������... ]</a>
-->


<!--<hr NOSHADE size="1">
�������� ������� ������������ ����� ����� ������� �������� �������� �������
<a HREF="http://www.aptechsar.com/news.php?id=190318_2">[ ���������... ]</a>-->

<hr NOSHADE size="1">
<strong><span style="color: blue;">������������� ��������������� ����� �������������� ����������  ���������� �� ��������</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=190318_1">[ ���������... ]</a>
<!--
<hr NOSHADE size="1">
�������� ����� 2018
<a HREF="https://www.youtube.com/watch?v=rzKoih0nIeg">[ ���������... ]</a>

<hr NOSHADE size="1">
���� ���������� ���������� ������� �������  � ������������ ��������� �� ���������� ��������� ����������
<a HREF="http://www.aptechsar.com/news.php?id=160318">[ ���������... ]</a>-->

<hr NOSHADE size="1">
���� ��������� ����� ����� �������� � ���������� ������ ���� ����������� �������� ������ ���� � 2018�
<a HREF="http://www.aptechsar.com/news.php?id=140318_2">[ ���������... ]</a>

<hr NOSHADE size="1">
�������� ����� - ���������� �������������� �������� ���������� �������� ����� ���������� �����������
<a HREF="http://www.aptechsar.com/news.php?id=140318_1">[ ���������... ]</a>

<!--<hr NOSHADE size="1">
<strong><span style="color: red;">���� ����� �� �������� �� ��������� ���������-��������������� ����������������</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=140318">[ ���������... ]</a>

<hr NOSHADE size="1">
��������� � ���������� ���������� ������� ������� ��  ������������� �������� �� ����������� ������������� � ������������ �3D-���� � 3D-�����
<a HREF="http://www.aptechsar.com/news.php?id=120318">[ ���������... ]</a>

<hr NOSHADE size="1">
���������� ���������� ������������ ������������� ����� �������� ��������� �����-2018�
<a HREF="http://www.aptechsar.com/news.php?id=070318">[ ���������... ]</a> 

<hr NOSHADE size="1">
<strong><span style="color: red">������� ����� �� ��������� ���������� ���������������� ������������� �� ������������� �������������� ��������� ���������� Aptech</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=060318_3">[ ���������... ]</a>

<hr NOSHADE size="1">
���������� ���������� �������������� ������������� ����� �������� ��������� �����-2018�
<a HREF="http://www.aptechsar.com/news.php?id=060318_1">[ ���������... ]</a>  -->

<hr NOSHADE size="1">
� ���� ��������� ����������� ������������ ���� �������� ��������� ����� � ��������� �3D-���� � 3D-�����
<a HREF="http://www.aptechsar.com/news.php?id=060318">[ ���������... ]</a>

<!--<hr NOSHADE size="1">
������������� ������������� ������ ���������������� ������������������� � ��-�����  ����������� � ��������� ���������� ��������
<a HREF="http://www.aptechsar.com/news.php?id=060318_2">[ ���������... ]</a>-->

<hr NOSHADE size="1">
� ���� ������ ������������ ��������� ��� ���������� ����������� �3D-���� � 3D-�����
<a HREF="http://www.aptechsar.com/news.php?id=010318_1">[ ���������... ]</a>

<!--<hr NOSHADE size="1">
����� ����������� ���������� ����������� � ����������� ���������� �� ������������� ����������� ���
<a HREF="http://www.aptechsar.com/news.php?id=280218">[ ���������... ]</a>

<hr NOSHADE size="1">
��������� ����� ���� ����� � ���, ���� � ��� ���� � ������� ������������ �����
<a HREF="https://www.youtube.com/watch?v=1NDZipbpfhU">[ ���������... ]</a> 

<hr NOSHADE size="1">
��������� � ���������� ���������� ������� ������� � ���������� ��������
<a HREF="http://www.aptechsar.com/news.php?id=120218">[ ���������... ]</a>-->

<hr NOSHADE size="1">
���������� ��������� ���������� �������������� ���������� � ������������  ���� ����-��� �������������� �������� ������������ �������� � ����� ������� ����������
<a HREF="http://www.aptechsar.com/news.php?id=010218">[ ���������... ]</a>
<!--
<hr NOSHADE size="1">
��������� ���� ���������� ������� ������� � ������������� ���������������� ���������
<a HREF="http://www.aptechsar.com/news.php?id=300118">[ ���������... ]</a>

<hr NOSHADE size="1">
������� ��������� ����� �������� ������ ������������ ������ �������������� ������������� ���������������� ������
<a HREF="http://www.aptechsar.com/news.php?id=290118">[ ���������... ]</a>

<hr NOSHADE size="1">
������ ����� ����� �� XVII ������������� ������� ������������ ����� ��� �����, ��������� � ������������ �������� "�������� ����� - 2018"
<a HREF="http://www.aptechsar.com/news.php?id=211217_1">[ ���������... ]</a>


<hr NOSHADE size="1">
������ �������� ����� ���� - 2017� ������� ������� �����
<a href="http://www.aptechsar.com/news.php?id=140317">[ ���������... ]</a>


<hr NOSHADE size="1">
���� �������� ������� ������� � �������� ������� ��������������� ������������  � ������ ������� TEMPUS 
<a href="http://www.aptechsar.com/news.php?id=140316_1">[ ���������... ]</a>
<hr NOSHADE size="1">
�������� ������� ������� ����� ����������� ��������������-����������� ������������ TEMPUS ������� ���������� ����������� �����������  �����������: ����� ������������ ���������  � ������� �������� �������� �� ������������ �� ����������� �ѻ
<a href="http://www.aptechsar.com/news.php?id=010316_2">[ ���������... ]</a>-->
<!-- <hr NOSHADE size="1">
����� ���� ������������ ���� ���������� ��� ������ �������������� ���������� � �������������� �������. ������ � �������������� ������������ ������� 20 ����.</p>
<p><strong>����������: ���������������, 77, ������� ������ ����, �����, ���. 403 </strong></p>
<p><strong> ���������� ������� 99-87-34</strong></p>
<hr NOSHADE size="1">
����� ����� � ������ ������������� ���������� ������������� �������� �������� � ������� 
<A HREF="http://www.aptechsar.com/news.php?id=170615">[ ���������... ]</a>

<hr NOSHADE size="1">
������� ����������� �������� ����� ����� ������������ ������������� ���������� ISO<br>
<A HREF="http://www.aptechsar.com/news.php?id=210515_3">[ ���������... ]</a>
<hr NOSHADE size="1">
 ����� ���� ������� ���������� ��������������� ��������  �������� Autodesk
<A HREF="http://www.aptechsar.com/news.php?id=070714_2">[ ���������... ]</a>
<hr NOSHADE size="1">
������������� ��������� ���������� �������������� ���������� (�����) ���� ��. �������� �.�.  � ��������� ��� ���������� ���� ������� ���������������, ������� ������������� ������ �� ��������� TEMPUS ������������ �����.  
<A HREF="http://www.aptechsar.com/news.php?id=151013_2">[ ���������... ]</a>-->
<hr NOSHADE size="1">
�������� ����� ����� ����� ������� <b>������������� ���������� Autodesk</b> � ��������� ������������ �������� ����������� <b>Autodesk</b> <a href="http://students.autodesk.com/">http://students.autodesk.com</a>
<hr noshade size="1" />


						</DIV>
						<DIV class="curs"><A HREF="../news.php">[ ��� ������� ]</A></DIV> 
						<!--<DIV class="curs"><A HREF="">[ ��������� ]</A></DIV> -->
					</TD>
				</TR>
				<TR>
					<TD colspan="2"><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="10" BORDER="0"></TD>
				</TR>
			</TABLE>
	
	<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD bgcolor="#F0F0F0" colspan="2"><IMG SRC="images/title_vacan.gif" WIDTH="150" HEIGHT="35" BORDER="0" style="margin: 0px 0px 0px 10px;"></TD>
				</TR>
				<TR>
					<TD background="images/sq.gif"><IMG SRC="images/1.gif" WIDTH="50" HEIGHT="1" BORDER="0"></TD>
					<TD width="100%">
<DIV class="f12_colon">

<hr NOSHADE size="1">
<p><b>������������� ��������������� ����� ����� ���� ����� �������� �.�.</b></p>
<p><em>��������:</em> ��������<br />
<em>�����������:</em> ����������� ���������� ������� ������������� �����������.<br>
<em>����������:</em> ������ �����������, ������ ����� ��������������� digital-�����������,   ���� ����������� ������, ���������� �������� ������, ������������� � �������� ���������� �����, �������� ���������������� ������, ������ �������������� ����������.<br>
������ �����������<br>
<em>����������:</em> (8452) 99-86-67, 99-87-15 (����� ����������)<br>
<em>E-mail:</em> <a href="mailto:olga@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">olga@sstu.ru</a>
</p>
<!--
<hr NOSHADE size="1">
<p><b>������� ������������ ����� ���� ����� �������� �.�.</b></p>
<p><em>��������:</em> ��������<br />
<em>�����������:</em> ����������� �������� ��������, ������� ������������.<br>
<em>����������:</em> ������ �����������, ��������� ������ ����� ��������������� digital-�����������, ����������������, ����������������, �������� ���������������� ������,
������������ MS Office. ��������� ���� ������ � �����������.<br>
������ �����������<br>
<em>����������:</em> (8452) 99-86- 67, 99-87- 15 (����� ����������)<br>
<em>E-mail:</em> <a href="mailto:olga@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">olga@sstu.ru</a>
</p>


<hr NOSHADE size="1">
��������� ������������ � �������� �����<br>
���. 99-87-15 e-mail:  <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>
					
<hr NOSHADE size="1">
<b>������� �� ������������ ������������ ����, ������������ � ������� �������:</b>

				<br><B>����������:</B> ������ ����������� �����������, ���������� ����������  �����, �����.  ���������������, ������� �������� ������������.

				<br><b>���. 99-87-34 </b><A HREF="mailto:demidovaii@sstu.ru">demidovaii@sstu.ru</A>
<hr NOSHADE size="1">

<p><strong>��������&nbsp;Erle&nbsp;Robotics&nbsp;(�������, ������ ������)</strong>, ������������ ������������ � ������� ������������� � �������������� ����������, ������� ��� ��������� �������:<strong> ����������� ������������ ����������� (software&nbsp;engineer)</strong>, <strong>���������� �� �������� (sales&nbsp;and&nbsp;marketing&nbsp;specialist)</strong> � <strong>������� �� ������������(hardware&nbsp;engineer)</strong>.</p>

<p><strong>�������� ���������� � ����������: ������ � ���������&nbsp;ROS&nbsp;(������������ ������� ��� �������)</strong>.</p>

<p>����� ��������� ���������� � ����������� � ���������� ����� ����� �� ����� ��������:&nbsp;<a href="http://erlerobotics.com/blog/jobs/?utm_source=Jobs&amp;utm_medium=pdf&amp;utm_content=sales&amp;utm_campaign=jobs" target="_blank">erlerobotics.com</a></p>

<p>��������� ������ � ������ ������� �� ������ ��&nbsp;email:&nbsp;<a href="mailto:jobs@erlerobotics.com">jobs@erlerobotics.com</a></p>


--><!--

<hr NOSHADE size="1">
<p><b>� ������������� ��������������� ����� ��������� ��������</b>.</p>
<p>����������: ������ ��� ������������� ������ �����������, ������������������, ���������������, ���� ������ � ������.<br>
���������� �� ��, ������ ��������. �������� �� ����������� �������������.
</p>
<p>��������: ���. 99-86-69, ����� ��������, �������� ������������.</p>
<p>������ ���������� ��&nbsp;<a href="mailto:afanasiev@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">afanasiev@sstu.ru</a></p>




<hr NOSHADE size="1">
<p><strong>���� �������� ���������� �� ������ ��������� ��������� ������</strong></p>
<p><strong>���������:</strong> ���������� ������ �������������� ���������� <strong>����������� �������:</strong>��������� ������� �������� - ������������� ������� �������������� ����������� ������������(������-����).
������ � ���������� �������������� �����������.</p>
<p><strong>���������� � �������, ������� � ��������� ���������:</strong>
������ ��������� ����������������� ������ ����������, ������ �������� ��������� ���������� ������������ ������������� �� ������� ����������������� �� Windows ��������� ����, ������� ��������������� ��������, �������������������.</p>
<p>�� 13000 ���.(gross)</p>
<p>������ ��������� �� ����� office@sar.uralsib.ru</p>

<hr NOSHADE size="1">
<p>��������� <b>�������� �������������� ���������������� ������</b>.</p>
<p>����������� ������, ���� ����������� ������ � ������ �����������, ������� ������������ ��, ���������� ����, ������ �������� � �������, ���������������.</p>
<p>������ �������� �� 30 ���� 2014 ���� &nbsp;<a href="mailto:olga@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">olga@sstu.ru</a></p>
-->
<!--
<hr NOSHADE size="1">
�<b>��� ����</b>�  ���������� �� ������ ������������-������������� �� �� ������ ������� ���� (����� ��������). ������ � �������� ����. ���.  46-95-65
<hr NOSHADE size="1">
��������� ������������ �� ������ ������� ����. ����������� ������. ����� ��� ����� ������. ����������: ������������ �������� ������ ��, ��������������, ���������������, ����������������.
���. 99-87-15 e-mail:  <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

<hr NOSHADE size="1">

�������� ������-������ ������ ��������� �� ������ ���������. ����� ��� ����� ������, �� �� ������� MS Office, 1C �����������.
���. 99-87-15 e-mail:  <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>
--><!--



<hr NOSHADE size="1">

		<B>�������� � ������������� ��������������� �����</B>

	

				<br><B>����������:</B> ������ �����������, ��������� ������ ��, ���� ������.

				<br><b>���. 99-87-15 </b><A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

	


<hr NOSHADE size="1">
<b>������������� �������������� ����������:</b>
<br><br><b>���������� ������:</b> 
<ul><li>���������� �������� ���-����������, 
<li>���������������� �� Java, C#, 1C,
<li>Flash � Flex-����������,
<li>���������� ������������� ������� Adobe Premier.
</ul>
<br>����������� ������� ������� �����������.
 ������ ��������  �� ������: <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

<br><br><b>1. ������������ ���������������� ����������� �� ������������ �������</b><br>
<b>����������:</b> ������ �����������, ���� ����������� ������ �� ������� ������������,   ���������������, ����������������. ������� �� 35 ���. <br>

<b>������:</b> ��������� �������� MS Office, ������������ ��������.<br>
<br>
<b>2. ������������ ���������������� ����������� �� ������������� �����������</b><br>
<b>����������:</b> ������ �����������, ���� ������ � ����������� ��������� �� ����� 3-� ���, 
������ �������� � �������, ������ � ������� ����������, ��������� �������� ��.<br>
<br>
<b>3. ����������� ������������ �������� ������ �� ������������� �����</b><br>
<b>����������:</b> ������ �����������,  ���� ������ � ����������� ��������� �� ����� 3-� ���,  ���������������,
��������� �������� ��, ������ �������� � �����������.<br>
<br>
<br>���������� �� ���. 99-87-15. <br>������ ��������� �� <b>15 ������ 2011 ����</b> �� ������: <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>



<B>��������� ������� � ����� ����������� ���������</B>
<br><B>����������:</B> ������ �����������, ���� ������ �� ����� 1 ����, ������ ����������������� ����� Microsoft Windows, ��������� ������� � ������������ �������,���������������, ������ �������� � �������.<br><b>���. 50-93-75 </b><A HREF="mailto:aptechedu@sstu.ru">aptechedu@sstu.ru</A>

						<hr NOSHADE size="1">

<B>��������� ��������  �� ������ � ��������� � ������� ����� ����� (������)</B>
<br><B>����������:</B> �/�, ���� ������ �� ����� 1 ����, ���������������, ������ �������� � �������.<br><b>���. 50-93-75 </b><A HREF="mailto:aptechedu@sstu.ru">aptechedu@sstu.ru</A>

						<hr NOSHADE size="1">

<B>��������� �������� ������������� ���������� ���������</B>
<br><B>����������:</B> �/� ��� ������������� ������, ������� ������� ������-�������,������������.<br><b>���. 50-93-75 </b><A HREF="mailto:aptechedu@sstu.ru">aptechedu@sstu.ru</A>

						<hr NOSHADE size="1">

<B>��������� ��������� ������ ���������� � �������</B>
<br><B>����������:</B> ������ �����������, ���� ������ � ��������� ������� �� ����� 3-� ���.
<br><b>����� ������ �� 30 ���� 2010 ����</b> �� ������ <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

						<hr NOSHADE size="1">

						<b><font color="red">������</font></b> ��������� ������������� � <A HREF="../education.php?id=2">������� ������������ �����</A> �� ����������� <b>Flash, ActionScript, XML</b>

						<hr NOSHADE size="1">

						� ����� � ����������� ����� ������������ �� ���������� ������<br> <B>�������������</B> �� ������������: 
						<UL>
							<LI>���������������� (Java, C#, ASP, JSP) 
							<LI>���� ������ (MS SQL Server, Oracle/Developer) 
							<LI>������������ ������� (Adobe Photoshop, Corel Draw, Macromedia Flash, 3DMax) 
						</UL>
                        -->
<?
/*
						<hr NOSHADE size="1">
						<UL>
							<LI>������������ ����������� ��������������� ����������������� �����������
						</UL>	
*/
?>
<!--
<hr NOSHADE size="1">			
						<b>����������:</b> �/�, ���� ������ 
						<br>���. 50-93-75 <A HREF="mailto: aptechedu@sstu.ru">aptechedu@sstu.ru</A>
						<hr NOSHADE size="1">

						</DIV>
<hr NOSHADE size="1">
--><!--<hr NOSHADE size="1">
<b>������ ��� ��������� � ����������� �����</b>
<br> 
<p>��������� <strong>��������� � �����-����� �������-������������  ������</strong> ����������� �������. <strong>�����������:</strong> ���� � ���������� ���������� ��� ����� ����������.��, �����������������  �����,&nbsp;��������� ������� ��� � ��������, ������� ������������ �����-������  (��������, ������, ������ � ��. - �� ����� �����), ������� � ����������  �����������, ���������� �� ������� ������������ � ��������������� ���,  �������&nbsp;������&nbsp;�����-������, �������� � ���� � �������������,  ���������� ���� ������������� ���� - ��������������! <br />
	<strong>������ ������</strong> � 9 �� 18, ������. ��, ����. �������� 8 ���.&nbsp;<br />
	<strong>������ ���������</strong> �� ������&nbsp;<a href="mailto:press@sartpp.ru" target="_blank">press@sartpp.ru</a>, ����� <strong>390-433</strong>. <br />
<strong>���. ��� �������</strong> <strong>390-433</strong>.  �������� �����-������ ����� ������� �����������.</p>
<!--�����������-��������������� ����� ���������� �� ���������� ������ ����������. 
<br><b>����������</b>: ������ �������� CorelDraw (�����������), Photoshop (�����������); ������� ��������� (����������). 
<br><b>���.: 91-41-10, 93-40-83</b>.

						<DIV class="curs"><A HREF="http://aptechsar.com/about.php?id=3">[ ��� �������� ]</A></DIV> -->
                        
					</TD>
				</TR>
				<TR>
					<TD colspan="2"><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="10" BORDER="0"></TD>
				</TR>
			</TABLE>
		
	</TD>
		<TD><IMG SRC="images/1.gif" WIDTH="10" HEIGHT="1" BORDER="0"></TD>
		<TD>


		<TD width="50%">



<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD bgcolor="#F0F0F0" colspan="2"> <DIV class="blue" style="text-decoration: uppercase; padding: 5px 0 0 5px;"><span style="color:#be0000;">��������</span> ���������� <br>�������������� ����������  � ������������</DIV></TD>
				</TR>
				<TR>
					<TD background="images/sq.gif"><IMG SRC="images/1.gif" WIDTH="50" HEIGHT="1" BORDER="0"></TD>
					<TD width="100%">
						

<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
	<TR>
		<TD colspan="2">
			<DIV class="f12_colon">
				<hr NOSHADE size="1">
			</DIV>
		</TD>
	</TR>




<TR>
		<TD>
			<DIV class="f12_colon">
				�������� � 898-� �� 28.10.2016�. ������������� ��������� ���������� �������������� ���������� ������������ � �������� ���������� �������������� ���������� � ������������ (�����).<br> � ������ ����� �������� ������� ��������������� ������������ ������������������ ������ (���). 
			</div>
		</TD>
		<TD>
			<IMG SRC="images/logo_inpit.png" WIDTH="100" BORDER="0">
		</TD>																								
	</TR>
	<TR>
		<TD colspan="2">
			<DIV class="f12_colon">
				<hr NOSHADE size="1">
			</DIV>
		</TD>
	</TR>




<TR>
		<TD>
			<DIV class="f12_colon">
				<DIV class="blue"><A HREF="news.php?id=mfpit_sert13" target="_blank" class = "blue">������� ����������� �������� ISO</A></DIV>
			</div>
		</TD>
		<TD>
			<A HREF="news.php?id=mfpit_sert13" target="_blank"><IMG SRC="images/mfpit_sert13.jpg" WIDTH="100" BORDER="0"></A>
		</TD>																								
	</TR>						
	
	<tr>
		<TD colspan = "2">
			<DIV class="f12_colon">
				<hr NOSHADE size="1">
			
			</DIV>
		</TD>
	</tr>



	<TR>
		<TD>

<DIV class="f12_colon">

<DIV class="blue">������ �����������</DIV>
<UL>
<LI>������������ ���������� �� ������������:
  <UL>
    <LI><A HREF="education.php?id=61" target="_blank">����������� � �������������� ������� (������� ��������������� ������, ���������, ������� � ����)</A>
	<LI><A HREF="education.php?id=996" target="_blank">����������� � �������������� ������� (������� ������������ ����������� ������� �������������� ������� � ������������������ ������)</A>
	<LI><A HREF="education.php?id=62" target="_blank">�������������� ������� � ����������</A>
	<LI><A HREF="education.php?id=68" target="_blank">���������� �����������</A>
    <li><a href="education.php?id=998" target="_blank">�������������� ������������</a></li>
	<LI><A HREF="education.php?id=67" target="_blank">������� � ����� � ���������������</A>
	<LI><A HREF="education.php?id=58" target="_blank">������</A>
        <LI><A HREF="education.php?id=69" target="_blank">����������� ���������</A>
<LI><A HREF="education.php?id=74" target="_blank">�����������</A>
<LI><A HREF="education.php?id=77" target="_blank">��������������� ������� ����� ��������������</A>

</UL></li>
<li>
���������� ������������ �� �����������:

<ul>
	<li><a href="http://www.aptechsar.com/education.php?id=999" target="_blank">�������������� ������������ ������������������ ������</a></li>
</ul>
</li>
<LI>������������ �� ������������:
<UL>
	<LI><A HREF="education.php?id=60">����������� � �������������� ������� (������� ��������������-���������������� ��������)</A>
	<LI><A HREF="education.php?id=59">�������������� ������� � ����������</A>
    <LI><A HREF="education.php?id=73">���������� �����������</A>
	<LI><A HREF="education.php?id=78">����������� ���������</A>
	<LI><A HREF="education.php?id=79">�������������� ������������</A>
 
<li><a href="http://www.aptechsar.com/education.php?id=75" target="_blank">������� � ����� � ���������������</a></li>
</UL>
<LI>�����������
</UL>

<hr NOSHADE size="1">

<p><DIV class="blue">��������� �����</DIV>
<b>������� ���������</b>
<UL>
<LI><A HREF="education.php?id=64">������� ����������� �������������� ����������</A>
<LI><A HREF="education.php?id=65">������� ��������������-���������������� ������� � ����������� ����������</A>
<LI><A HREF="education.php?id=ibs">������� ��������������� ������������ ������������������ ������</A>
<LI><A HREF="education.php?id=66">������� ������������������</A>
<LI><A HREF="education.php?id=71">������� ������� � �������� ���������</A>
</UL>



<hr NOSHADE size="1">

<p><DIV class="blue">���������� � ������������, ���������� ������� � ������� ����������� ��� ����������� � ���� ����� �������� �.�.</DIV>
<UL>
<LI><a href="aboutmfpit.php?id=olymp_mob">������������ ��������� �� ���������� ��������� ����������</a>
<LI><a href="aboutmfpit.php?id=3dday18">�������� ������������� ������� �� ����������� ������������� � ������������ �3D-���� � 3D-�����</a>
<LI><a href="aboutmfpit.php?id=3dday">������������ ��������� �� ���������� ����������� �3D-���� � 3D-�����</a>
<LI><a href="aboutmfpit.php?id=dw18sar">����������� ������������ ��� XVII �������������� �������� ������������ ����� ��� �����, ��������� � ������������ �������� "�������� ����� - 2018"</a>
<LI><a href="aboutmfpit.php?id=dw18">������������� �������  ������������ ����� ����� �����, ��������� � ������������ �������� ��������� �����-2018�</a>
<LI><a href="aboutmfpit.php?id=digitalstart">������������� ������� ������������ ����� ����� ���������� "�������� ����� - 2017"</a>
<LI><a href="aboutmfpit.php?id=cryptolymp">��������������� ��������� ���������� �� ���������� � ������������</a>
<LI><a href="aboutmfpit.php?id=olymp_it">��������������� ��������� ���������� �� ����������� � ������������ ������������</a>
<LI><a href="aboutmfpit.php?id=dw17">XVI ������������� ������� ������������ ����� ��� �����, ��������� � ������������ �������� ��������� ����� - 2017�</a>
<LI><a href="aboutmfpit.php?id=sardw17">������������ ����������� ��� XVI �������������� �������� ������������ ����� ��� �����, ��������� � ������������ �������� ��������� ����� - 2017�</a>
<LI><a href="aboutmfpit.php?id=dstart_16">������������� ������� ������������ ����� ����� ���������� ��������� ����� - 2016�</a>


</UL>
<a href="education/poryadok-ucheta-ind-dostizh-2017.doc"> ������� ����� �������������� ���������� ����������� ��� ������ � ���� ����� �������� �.�. � 2018 ����
�� �������� �� ���������� ������������, ���������� ������������ � ���������� ������������</a>


<hr NOSHADE size="1">

<p><DIV class="blue">������������� ��������������� �����</DIV>

����� �������� �������� �� �������������� ������ � ������� �������������� ���������� ��� ����,<br> �������� �������� ������������ � ������� ��, � ������� �� ��������� �������������:

<UL>

	<LI>�������������� ������� ����� <a href="http://www.aptechsar.com/education.php?id=15">Aptech Computer Education</a>

<li>������� ����� ������������ ������� � �����������  <br><a href="http://www.focus-design.org/">�����-������</a>


	<!--<LI>�������������� ������� ����� ������������ ������� � ����������� <a href="http://www.aptechsar.com/education.php?id=14">Arena Multimedia</a>

	<LI>�������������� ������� ����� ������������ �������������� <a href="http://www.aptechsar.com/toonboom.php?id=tb_5">Toon Boom Technologies</a>

	
<LI>�������������� ������� ����� <a href="http://www.aptechsar.com/it-academy/"> Softline Academy</a>-->

	<LI>�������������� ������� ����� <a href="http://www.aptechsar.com/education.php?id=16"> Microsoft Imagine Academy</a>

	<!--<LI><a href="http://www.aptechsar.com/testsmain.php">������ ��������������� ������������</a>-->



	<LI>�������������� �������� <a href="http://www.cisco.com/web/learning/netacad/index.html">Cisco</a>

</UL>

<p><div class="blue">����� �������������� ���������� � �������������� ����������� </div>
	
<hr NOSHADE size="1">	


<p>� ������� ��� � ��:</p>
<ul>
  <li>����������� �������������� ����������</li>
  <li>����������� ����������� ����������</li>
  <li>Grid-���� �� ������ ���������� ��, ����������� ��������� ������ �������  �����������</li>
</ul>

<p>������������ ��� � �� �������������� ����������� ��������� ������������ ����  �����, &nbsp;���������� ������������ �����������, ��������� �����  �������������� ����������, ���������� ���������� ����������� ����������.</p>

<hr NOSHADE size="1">

<p><DIV class="blue">������-������������� ����� �������� ������������ �����</DIV>
<a href="http://digital-school.net">digital-school.net</a><br>
������������ ��� ���������� ���������� � ������� �������������� ����������. ����� ������������� ������������� ��������� �������� ����������������, ��������-����������, ������������ ������� � �����������, ������� ���������� �. �������� � ����������� �������, ����� �������������� �������������� ����������� � ������� ������, �������� ������ � ������ ����� ����������������.

<hr NOSHADE size="1">

<p><DIV class="blue">������-������-���������������� ������������� �����</DIV>
<!--������� ����� ������ �������������� ������ �������� ����������� �������� �������� �� �������������� <A href="../education.php?id=12" target="_blank">��������</A> � <A href="../education.php?id=43" target="_blank">��������������� ���������� � ��������������</A>.--> �� ���� ������ ����������  ������������ ������� �� ������, ��������� � ������������� ����������� � ������������, � ����� ������ ���������������� ��������.
<p>����� ������������� � �������������  ��������� ������, �������������-��������� ������, ������� ������ ��� ������������� ���� � ��������� �����������.




<!--<hr NOSHADE size="1">
<p><DIV class="blue">������ ����� �����</DIV>
<p><strong>������  ������� ������</strong>:</p>
<ol>
	<li>�������� �.�. &ndash; �������� �����, ���.&nbsp; �������� ��� - ������������ ������� ������</li>
	<li>������ �.�. &ndash; ������ ������� ���, ����������� ������������ ������� ������</li>
	<li>������ �.�., ���������� �������� ����</li>
	<li>������ �.�., ���������, ������� ����</li>
	<li>������ �.�., ������ ������� ����</li>
	<li>������ �.�., ������ ������� ����</li>
	<li>����������� �.�., ������� ������������� ������� ���</li>
	<li>�������� �.�., ��������� ������� ���</li>
	<li>������ �.�., ������ ������� ��� - ��������� ������� ������</li>
	<li>������� �.�., ���. �������� ���</li>
	<li>����� �.�., ������ ������� ���</li>
	<li>����� �.�., ������ ������� ���</li>
	<li>�������� �.�., �������� ������������� ���������� ��������� �����</li>
	<li>���������� �.�., �������� ��� � ��</li>
	<li>��������� �.�., ���. �������� ���</li>
	<li>��������� �.�., ������ ������� ���</li>
	<li>������������ �.�. &ndash; ������ ������� ���</li>
	<li>�������� �.�., ������ ������� ����</li>
	<li>������� �.�.,&nbsp;������ ������� ����, �������</li>
</ol>-->

<!--<br>
<p>������ <a href="http://aptechsar.com/�%20�������%20�������%20������%20�����.doc">�  ������� ������� ������ �����</a> <br />
������ <a href="http://aptechsar.com/council.doc">�� ��������� ������� ������� ������ �����</a> <br />
������ <a href="http://aptechsar.com/council_june15.doc">�� ��������� ������� ������� ������ ����� ���� 2015</a> <br />
  <a href="http://aptechsar.com/council_plan_2014-15.doc">����  ������ ������ ����� 2015.doc</a></p>-->




</DIV>

		</TD>
		<TD>


						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD>
									<A HREF="http://aptech-russia.com/" target="_blank"><IMG SRC="images/aptech-worldwide_logo.jpg" WIDTH="100"  BORDER="0"></A><br>
									<!--<A HREF="http://aptech-russia.com/index.php?option=com_content&view=article&id=21&Itemid=24" target="_blank"><IMG SRC="images/arena_logo_100.jpg" WIDTH="100" HEIGHT="43" BORDER="0" style="margin: 5px 0px 0px 0px;">--></A>
								</TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.microsoft.com/Rus/education/ita/default.mspx" target="_blank"><IMG SRC="images/microsoft_imagine.png" WIDTH="100" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.toonboom.com/" target="_blank"><IMG SRC="images/ToonBoom_logo.jpg" WIDTH="100" HEIGHT="53" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							
							<TR>
								<TD><A HREF="http://www.uwe.ac.uk/" target="_blank"><IMG SRC="images/UWE_logo.jpg" WIDTH="100" HEIGHT="39" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>							
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.certiport.com/" target="_blank"><IMG SRC="images/logo_certiport.jpg" WIDTH="100" HEIGHT="31" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.prometric.com/" target="_blank"><IMG SRC="images/logo_prometric.jpg" WIDTH="100" HEIGHT="35" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.hp.com/" target="_blank"><IMG SRC="images/logo_HP_100.jpg" WIDTH="100" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><a href="http://www.cisco.com/web/learning/netacad/index.html"><IMG SRC="images/Logo_Cisco_NA.jpg" WIDTH="100" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.alltests.ru/" target="_blank"><IMG SRC="images/logo_alltests.jpg" WIDTH="100" BORDER="0"></A></TD>
							</TR>
							<TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
							<TR>
								<TD><A HREF="http://www.iaite.org" target="_blank"><IMG SRC="images/logo_maito.jpg" WIDTH="100" BORDER="0"></A></TD>
							</TR>
                            <TR>
								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>
							</TR>
                            
							<TR>

								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>

							</TR>

                            <TR>

								<TD><A HREF="https://education.emc.com/academicalliance/default.aspx" target="_blank"><IMG SRC="images/EMC.jpg" WIDTH="100" BORDER="0"></A></TD>

							</TR>

<TR>

								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>

							</TR>

                            <TR>

								<TD><A HREF="http://www.autodesk.com/" target="_blank"><IMG SRC="images/autodesk_logo.png" WIDTH="100" BORDER="0"></A></TD>

							</TR><TR>

								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>

							</TR>
                                                        <TR>

								<TD><a href="http://aptechsar.com/certificate autodesk.pdf"><img src="images/certificate autodesk.png" width="100" border="0"></a></TD>

							</TR><TR>

								<TD><IMG SRC="images/1.gif" WIDTH="1" HEIGHT="25" BORDER="0"></TD>

							</TR>

						</TABLE>

		</TD>
	</TR>
</TABLE>

					</TD>
				</TR>
			<!-- -->	
				<TR>
					<TD colspan="2">
					<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD bgcolor="#F0F0F0" colspan="2"><IMG SRC="images/title_faq.gif" WIDTH="150" HEIGHT="35" BORDER="0" 	style="margin: 0px 0px 0px 10px;"></TD>
				</TR>
				<TR>
					<TD background="images/sq.gif"><IMG SRC="images/1.gif" WIDTH="50" HEIGHT="1" BORDER="0"></TD>
					<TD width="100%">
						<DIV class="f12_colon"><hr NOSHADE size="1"><b>��� ��������� �� �������������� ��������� Aptech?</b></DIV>
						<DIV class="f12_colon">
��� ����������� �� ��������� ���������� <A HREF="http://www.focus-design.o