 <?
include ("head_end.php");
include ("banners.php");
require("db_vars.php4");

if (isset($Email)) {

		//майл проверка
        function lfpregtrim($str) {
                 return preg_replace("/[^\x20-\xFF]/","",@strval($str));
                 }
        $error = null;
        // mail прогон
        if(lfcheck_mail($Email)==false) $error = "Введите пожалуйста корректный Email";
        if($error == null){

			if (connect_bd()){
				$res_bd = query_bd("SELECT * FROM new_mail_list WHERE mail='$Email'");
				if (mysql_num_rows($res_bd) > "0"){
					$error = "Такой Email уже зарегистрирован!";
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
<TITLE>Международный образовательный центр компьютерных технологий Aptech </TITLE>

<META NAME="Author" CONTENT="Fissenko N.P.">
<META NAME="Keywords" CONTENT="АРТЕСН World-Wide, Aptech Саратов, Computer Education, Высшее государственное  образование, Высшее образование, Детская компьютерная школа, Международное образование, Международное профессиональное IT-образование, Профессиональные IT-курсы, Образование по рекламе, Цифровой ветер">
<META NAME="Description" CONTENT="Учебный центр АРТЕСН один из крупнейших в России. Мы постоянно совершенствуем свои образовательные программы, разрабатываем новые учебно-методические пособия. Мы даем возможность получить образование мирового уровня. Саратов.">

<META content="text/html; charset=windows-1251" http-equiv=Content-Type>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel=stylesheet href="stylesheet.css" type="text/css">
</HEAD>

<BODY bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0" leftmargin="0" topmargin="0" bottommargin="0">

<script>
function validate() {
        if (document.newsMail.Email.value=="E-mail") {
                alert("Введите Email пожалуйста");
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
	alert("Спасибо за регистрацию");
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
	<a href="/special" style="color: #44679e; text-decoration: none; font-size: 14px; text-transform: uppercase;"><img src="/special/versiya-dlya-slabovidyashih.png" style="width:30px"> <span style="vertical-align: super;">Версия для слабовидящих</span></a>
</div>

<!-- /versiya-dlya-slabovidyashih -->

<!-- Центральная часть -->
<TABLE width="100%" cellpadding="0" cellspacing="0" border="0">
	<TR>
		<TD align="center">

		<IMG SRC="images/1.gif" WIDTH="135" HEIGHT="5" BORDER="0">

		<!-- Баннеры -->
<?
	show_banners();
?>
	
		<!-- / Баннеры -->
		</TD>
		<TD bgcolor="#F0F0F0">
		<!-- Средняя колонка -->

			<TABLE width="175" cellpadding="0" cellspacing="0" border="0">
				<TR>
					<TD colspan="2"><IMG SRC="images/1.gif" WIDTH="175" HEIGHT="5" BORDER="0"></TD>
				</TR>
				<TR>
					<TD bgcolor="#124090" style="vertical-align: middle;"><DIV class="zag"><!--БЛИЖАЙШИЕ КУРСЫ--></DIV></TD>
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
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#16DEDE, #09B8B8);"><a href="http://digitalwind.ru/registration/masterList.php" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">"Цифровой ветер"<br>Регистрация на мастер-классы</span></a></p>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#874CC2, #5D17A3);"><a href="http://digital-school.net/o_start.php" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Олимпиада по разработке мобильных приложений</span></a></p>
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
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:10px; border-radius:7px; background: linear-gradient(#7015C3, #590599);"><A HREF="/courses" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Курсы Unity 3D</span></A></p> 
</DIV>
<hr NOSHADE size="1"> -->


<!--
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#f00, #be0000);"><a href="/courses" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Дополнительное профессиональное образование</span></a></p>
</DIV> -->


<!-- href="/courses" 
<hr NOSHADE size="1"> -->
<DIV class="f12_left">
<A HREF="http://digital-school.net/"><img src="images/dks_but.png"  width="180" border="0" style="margin: 5px;" alt="Детская компьютерная школа"></A>
</div>
<hr NOSHADE size="1">
<DIV class="f12_left">
<A HREF="http://digitalwind.ru"  target="_blank"><IMG SRC="images/digitalwind_logo.png" WIDTH="180" BORDER="0" style="margin: 5px;" align="center"></A>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:4px; border-radius:7px; background: linear-gradient(#f00, #be0000);"><a href="/courses/courses2018.doc" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">График курсов дополнительного образования</span></a></p>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:6px; border-radius:7px; background: linear-gradient(#121212, #000000);"><A HREF="http://www.aptechsar.com/courses/programmistaptech/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Обучение по сертифицированной программе <span style="color: yellow"><i>"Aptech"</i></span></span></A></p>
</DIV>
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding:6px; border-radius:7px; background: linear-gradient(#40ce40, #028a02);"><A HREF="http://www.aptechsar.com/courses/programmist/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Обучение технологиям программирования</span></A></p>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding: 8px; border-radius:7px; background: linear-gradient(#1878D9, #084F9C);"><A HREF="http://www.aptechsar.com/courses/administrator/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Сетевая академия ИнПИТ</span></A></p>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">
<p style="text-align:center; 2px solid rgb(199, 17, 17); padding: 8px; border-radius:7px; background: linear-gradient(#D1611B, #D12B1B);"><A HREF="http://www.aptechsar.com/courses/designer/" style="text-decoration:none;"><span style="color:white; text-decoration:none; font-size:14px; font-family:Arial; font-weight:bold;">Технологии дизайна и маркетинга</span></A></p>
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
<A HREF="3dLabels.zip">Скачать файлы с метками для приложения «Magic News»</A>
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
Набор слушателей на курс
<br>
<A HREF="news.php?id=141015_3">Создание иллюстраций в программе Adobe Illustrator</A><br>
<br>
Подробности по телефону: <br><b>99-86-69</b>
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
   // timestr=today2 +" дней "+ thour+" часов "+tmin+" минут "+tsec+" секунд";
   daystr2 ='дней';
   cut2=today2%10;
   if(today2<10||today2>20){ 
   switch (cut2) {
  case 1:
    daystr2 ='день';
    break;
  case 2: 
  case 3:
  case 4:
    daystr2 ='дня';
    break;
  default:
   daystr2 ='дней';
}
 }  

   timestr2=today2;
document.getElementById('t2').innerHTML=timestr2;
document.getElementById('d2').innerHTML=daystr2;
}
window.onload = time2;*/
</script>


<strong>Набор в группу заканчивается через <span id="t2" style="font-size:20px; color: red;"></span> <span id="d2"></span></strong>
</DIV>
<hr NOSHADE size="1">

<DIV class="f12_left">

<A HREF="http://www.aptechsar.com/education.php?id=16"><IMG SRC="images/microsoft_imagine.png" WIDTH="180"  BORDER="0" style="margin: 5px;"></A>-->
<!--<br>
<A HREF="../education.php?id=57">Комплексная программа подготовки администратора компьютерных сетей</A><br>
Начало занятий: <br>
<b>24 ноября 2014</b>
Дату начала занятий уточняйте по телефону: <b>99-86-69</b>
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
   // timestr=today +" дней "+ thour+" часов "+tmin+" минут "+tsec+" секунд";
   daystr ='дней';
   cut=today%10;
   if(today<10||today>20){ 
   switch (cut) {
  case 1:
    daystr ='день';
    break;
  case 2: 
  case 3:
  case 4:
    daystr ='дня';
    break;
  default:
   daystr ='дней';
}
 }  

   timestr=today;
  document.getElementById('t').innerHTML=timestr;
document.getElementById('d').innerHTML=daystr;
}
//window.onload = time;
</script>


<!--<strong><a href="http://www.aptechsar.com/news.php?id=231215_1">Набор в группу</a> заканчивается через <span id="t" style="font-size:20px; color: red;"></span> <span id="d"></span></strong>
</DIV>
<hr NOSHADE size="1">
<DIV class="f12_left">

<img src="images/Cisco.png" width="180"  BORDER="0" style="margin: 5px;">
<br>
Ведется набор на обучение в 

<A HREF="education.php?id=cisco">сетевой академии Cisco</A><br>
<br>
Подробности по телефону: <br><b>99-86-69</b>
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
   // timestr=today3 +" дней "+ thour+" часов "+tmin+" минут "+tsec+" секунд";
   daystr3 ='дней';
   cut3=today3%10;
   if(today3<10||today3>20){ 
   switch (cut3) {
  case 1:
    daystr3 ='день';
    break;
  case 2: 
  case 3:
  case 4:
    daystr3 ='дня';
    break;
  default:
   daystr3 ='дней';
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


<strong>Набор в группу заканчивается через <span id="t3" style="font-size:20px; color: red;"></span> <span id="d3"></span></strong>
</DIV>
 
<hr NOSHADE size="1">

				<DIV class="f12_left">
						<a href="education.php?id=fdiz"><IMG SRC="images/arena_logo_100.jpg" WIDTH="150" HEIGHT="65" BORDER="0" style="margin: 10px 0px;"></a><br>
							<B>Проводится набор слушателей на следующие программы Arena Multimedia:</B>
							<UL>
								<LI><A HREF="education.php?id=14">Программа подготовки сертифицированного специалиста по компьютерной графике и мультимедиа технологиям</A> <br><Начало занятий: <br><b>24 ноября 2014</b> Дату начала занятий уточняйте по телефону: <b>99-86-69</b>
								<LI><A HREF="education.php?id=17">Программа подготовки Web мастера</A><br>Начало занятий:<br><b>24 ноября 2014</b>Дату начала занятий уточняйте по телефону: <b>99-86-69</b>
							</UL>
						</DIV>
						<hr NOSHADE size="1">


<DIV class="f12_left">
	<A HREF="education.php?id=15"><IMG SRC="images/ACE_Logo.png" WIDTH="200"  BORDER="0" style="margin: 10px 0px;"></a><br>
	<!--<B>Набор слушателей на <A HREF="education.php?id=15">Междунaродную программу подготовки сертифицированного программиста</A></B>
	<br> 
	Подробности по телефону: <br><b>99-86-69</b>-->
		
		<script type="text/javascript">
		timeendn= new Date();
		timeendn= new Date(timeend.getYear()>1900?(timeendn.getYear()):(timeendn.getYear()+1900),3,19);

		function time_n() {
			todayn = new Date();
			todayn = Math.floor((timeendn-todayn)/1000);
			tsecn=todayn%60; todayn=Math.floor(todayn/60); if(tsecn<10)tsec='0'+tsecn;
			tminn=todayn%60; todayn=Math.floor(todayn/60); if(tminn<10)tmin='0'+tminn;
			thourn=todayn%24; todayn=Math.floor(todayn/24);
		   // timestr=today +" дней "+ thour+" часов "+tmin+" минут "+tsec+" секунд";
		   daystrn ='дней';
		   cutn=todayn%10;
		   if(todayn<10||todayn>20){ 
		   switch (cutn) {
		  case 1:
			daystrn ='день';
			break;
		  case 2: 
		  case 3:
		  case 4:
			daystrn ='дня';
			break;
		  default:
		   daystrn ='дней';
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

<!--<strong><a href="http://www.aptechsar.com/news.php?id=231215_2">Набор в группу</a> заканчивается через <span id="tn" style="font-size:20px; color: red;"></span> <span id="dn"></span></strong>
						
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

		<!-- / Средняя колонка -->
		</TD>
		<TD width="100%">
		<!-- Содержание раздела -->
		
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
<strong>Дорогие выпускники!</strong> Торжественная церемония вручения дипломов состоится 3 июля в 15.00 в Студенческом клубе СГТУ

<hr NOSHADE size="1">
<strong><span style="color: red;">2 июля в 15.00 в аудитории 422 начнутся  занятия по программе подготовки к поступлению в магистратуру в сфере информационных технологий</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=290618_1">[ Подробнее... ]</a>



<hr NOSHADE size="1">
<strong><span style="color: red;">Открыт набор на обучение по программе подготовки к поступлению в магистратуру в сфере информационных технологий</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=300518_3">[ Подробнее... ]</a>-->

<hr NOSHADE size="1">
Студент ИнПИТ стал лауреатом премии «Успех»
<a HREF="http://www.aptechsar.com/news.php?id=280618_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Ученые и преподаватели  ИнПИТ победили в конкурсе на лучшую творческую работу
<a HREF="http://www.aptechsar.com/news.php?id=270618_2">[ Подробнее... ]</a>

<!--<hr NOSHADE size="1">
28 июня в  Институте прикладных информационных технологий и коммуникаций (ИнПИТ) пройдут консультации для поступающих в магистратуру
<a HREF="http://www.aptechsar.com/news.php?id=270618_1">[ Подробнее... ]</a>-->


<hr NOSHADE size="1">
Смотрим видео – выбираем направление обучения!
<a HREF="http://www.aptechsar.com/news.php?id=250618_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Летний пленэр для любителей живописи!
<a HREF="http://www.aptechsar.com/news.php?id=130618_2">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Завершилось обучение по курсу «Основы изобразительной грамоты». Открыт новый набор!
<a HREF="http://www.aptechsar.com/news.php?id=130618_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
В ИнПИТ прошла Международная научно-практическая конференция «Медиа в информационном обществе: эффекты, возможности, риски»
<a HREF="http://www.aptechsar.com/news.php?id=070618_2">[ Подробнее... ]</a>

<hr NOSHADE size="1">
В ИнПИТ наградили победителей Всероссийского фестиваля видео и кино «21-й кадр»
<a HREF="http://www.aptechsar.com/news.php?id=080618_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студенты ИнПИТ -  призеры конкурса видеороликов по безопасности дорожного движения
<a HREF="http://www.aptechsar.com/news.php?id=070618_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студент ИНПИТ вышел в международный тур олимпиады по математике
<a HREF="http://www.aptechsar.com/news.php?id=040618">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Продолжается набор в Летнюю компьютерную школу СГТУ!
<a HREF="http://www.aptechsar.com/news.php?id=080518_2">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Проведи лето с пользой!
<a HREF="https://youtu.be/yjbEUNhV-88">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Доцент кафедры ИКСП выступила с докладом на международной конференции в МГУ
<a HREF="http://www.aptechsar.com/news.php?id=250518_2">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Открыт набор на обучение по курсу "Программирование Lego-роботов" в Детской компьютерной школе СГТУ
<a HREF="http://www.aptechsar.com/news.php?id=190318_3">[ Подробнее... ]</a>

<hr NOSHADE size="1">
День СИБИНТЕК в СГТУ собрал более 200 студентов
<a HREF="http://www.aptechsar.com/news.php?id=210518">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Конструирование изделий легкой промышленности – креативно и технологично!
<a HREF="https://www.youtube.com/watch?v=8qCexQrXnZk">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Смотрите полную версию церемонии награждения победителей конкурса «Цифровой ветер-2018»
<a HREF="https://www.youtube.com/watch?v=3VK8937HEz4&feature=youtu.be">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студенты ИнПИТ и учащиеся Детской школы искусств ИнПИТ заняли призовые места в конкурсе "Саратов 2.0."
<a HREF="http://www.aptechsar.com/news.php?id=080518_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студенты ИнПИТ заняли победное место в эстафете Тимакова
<a HREF="http://www.aptechsar.com/news.php?id=070518">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Первокурсники ИнПИТ соревновались по информатике и программированию
<a HREF="http://www.aptechsar.com/news.php?id=040518_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студенты ИнПИТ выиграли Всероссийский финал международной олимпиады "Траектория будущего"
<a HREF="http://www.aptechsar.com/news.php?id=040518">[ Подробнее... ]</a>

<hr NOSHADE size="1">
В СГТУ наградили победителей конкурса «Цифровой ветер»
<a HREF="http://www.aptechsar.com/news.php?id=270418_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Ученые ИнПИТ получили ГРАН-ПРИ конкурса на лучшее бизнес-предложение
<a HREF="http://www.aptechsar.com/news.php?id=270418">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Определены победители региональной Олимпиады по разработке мобильных приложений
<a HREF="http://www.aptechsar.com/news.php?id=130418">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Новое видео от телецентра ИнПИТ о том, чему и как учат в институте
<a HREF="http://www.aptechsar.com/news.php?id=130418_1">[ Подробнее... ]</a>


<!--
<hr NOSHADE size="1">
Идет набор на обучение по программе «Специалист по SMM»
<a HREF="http://www.aptechsar.com/news.php?id=090418">[ Подробнее... ]</a>

<hr NOSHADE size="1">
<span style="color: red"><strong>«Цифровой ветер» приглашает школьников и студентов на мастер-классы по IT-технологиям и творческим направлениям</strong></span>
<a HREF="http://www.aptechsar.com/news.php?id=060418">[ Подробнее... ]</a> -->

<hr NOSHADE size="1">
Студент ИнПИТ Дмитрий Минаев стал обладателем титула «Мистер спорт» на конкурсе «Мисс и Мистер Студенчество Саратовской области 2018»
<a HREF="http://www.aptechsar.com/news.php?id=060418_1">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Идет набор на обучение по направлению «Программирование на языке С»
<a HREF="http://www.aptechsar.com/news.php?id=050418_1">[ Подробнее... ]</a>
<!--
<hr NOSHADE size="1">
ИнПИТ приглашает  преподавателей на прохождение сертификации MOS
<a HREF="http://www.aptechsar.com/news.php?id=050418">[ Подробнее... ]</a>
-->

<hr NOSHADE size="1">
Идет набор на курсы по технической защите информации
<a HREF="http://www.aptechsar.com/news.php?id=190318">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Идет набор на курсы по обеспечению безопасности персональных данных
<a HREF="http://www.aptechsar.com/news.php?id=230318">[ Подробнее... ]</a>


<!--<hr NOSHADE size="1">
<strong><span style="color: blue;">Идет набор на обучение по программе «Администратор компьютерных сетей»</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=210318">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Определены победители Астраханского регионального этапа конкурса «Цифровой ветер-2018»
<a HREF="http://www.aptechsar.com/news.php?id=200318">[ Подробнее... ]</a>
-->


<!--<hr NOSHADE size="1">
Учащиеся Детской компьютерной школы ИнПИТ успешно защитили итоговые проекты
<a HREF="http://www.aptechsar.com/news.php?id=190318_2">[ Подробнее... ]</a>-->

<hr NOSHADE size="1">
<strong><span style="color: blue;">Международный образовательный центр информационных технологий  приглашает на обучение</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=190318_1">[ Подробнее... ]</a>
<!--
<hr NOSHADE size="1">
Цифровой ветер 2018
<a HREF="https://www.youtube.com/watch?v=rzKoih0nIeg">[ Подробнее... ]</a>

<hr NOSHADE size="1">
СГТУ приглашает школьников принять участие  в Региональной Олимпиаде по разработке мобильных приложений
<a HREF="http://www.aptechsar.com/news.php?id=160318">[ Подробнее... ]</a>-->

<hr NOSHADE size="1">
Дуэт студентов ИнПИТ Елены Власовой и Александра Ненько стал победителем конкурса «Танцы СГТУ – 2018»
<a HREF="http://www.aptechsar.com/news.php?id=140318_2">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студенты ИнПИТ - победители Всероссийского конкурса молодежных проектов среди Молодежных коллективов
<a HREF="http://www.aptechsar.com/news.php?id=140318_1">[ Подробнее... ]</a>

<!--<hr NOSHADE size="1">
<strong><span style="color: red;">Идет набор на обучение по программе «Объектно-ориентированное программирование»</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=140318">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Студентов и школьников приглашают принять участие во  Всероссийском конкурсе по трехмерному моделированию и визуализации «3D-день и 3D-ночь»
<a HREF="http://www.aptechsar.com/news.php?id=120318">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Определены победители Ульяновского регионального этапа конкурса «Цифровой ветер-2018»
<a HREF="http://www.aptechsar.com/news.php?id=070318">[ Подробнее... ]</a> 

<hr NOSHADE size="1">
<strong><span style="color: red">Ведется набор на программу подготовки Профессиональных программистов по международной авторизованной программе корпорации Aptech</span></strong>
<a HREF="http://www.aptechsar.com/news.php?id=060318_3">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Определены победители Новосибирского регионального этапа конкурса «Цифровой ветер-2018»
<a HREF="http://www.aptechsar.com/news.php?id=060318_1">[ Подробнее... ]</a>  -->

<hr NOSHADE size="1">
В СГТУ наградили победителей саратовского тура конкурса «Цифровой ветер» и олимпиады «3D-день и 3D-ночь»
<a HREF="http://www.aptechsar.com/news.php?id=060318">[ Подробнее... ]</a>

<!--<hr NOSHADE size="1">
Представители Студенческого центра технологического предпринимательства в ИТ-сфере  встретились с министром молодежной политики
<a HREF="http://www.aptechsar.com/news.php?id=060318_2">[ Подробнее... ]</a>-->

<hr NOSHADE size="1">
В СГТУ прошла региональная Олимпиада про трехмерным технологиям «3D-день и 3D-ночь»
<a HREF="http://www.aptechsar.com/news.php?id=010318_1">[ Подробнее... ]</a>

<!--<hr NOSHADE size="1">
ИнПИТ презентовал разработки дополненной и виртуальной реальности на корпоративном мероприятии РЖД
<a HREF="http://www.aptechsar.com/news.php?id=280218">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Телецентр ИнПИТ снял ролик о том, чему и как учат в детской компьютерной школе
<a HREF="https://www.youtube.com/watch?v=1NDZipbpfhU">[ Подробнее... ]</a> 

<hr NOSHADE size="1">
Студентов и школьников приглашают принять участие в творческом конкурсе
<a HREF="http://www.aptechsar.com/news.php?id=120218">[ Подробнее... ]</a>-->

<hr NOSHADE size="1">
Магистрант Института прикладных информационных технологий и коммуникаций  взял гран-при Всероссийского конкурса студенческих проектов в сфере высоких технологий
<a HREF="http://www.aptechsar.com/news.php?id=010218">[ Подробнее... ]</a>
<!--
<hr NOSHADE size="1">
Студентов СГТУ приглашают принять участие в Международной сертификационной олимпиаде
<a HREF="http://www.aptechsar.com/news.php?id=300118">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Команда студентов ИнПИТ признана лучшим студенческим клубом Всероссийского студенческого образовательного форума
<a HREF="http://www.aptechsar.com/news.php?id=290118">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Открыт прием работ на XVII Международный конкурс компьютерных работ для детей, юношества и студенческой молодежи "Цифровой ветер - 2018"
<a HREF="http://www.aptechsar.com/news.php?id=211217_1">[ Подробнее... ]</a>


<hr NOSHADE size="1">
Звание «Золотой голос СГТУ - 2017» получил студент ИнПИТ
<a href="http://www.aptechsar.com/news.php?id=140317">[ Подробнее... ]</a>


<hr NOSHADE size="1">
СГТУ подписал сетевой договор о создании единого информационного пространства  в рамках проекта TEMPUS 
<a href="http://www.aptechsar.com/news.php?id=140316_1">[ Подробнее... ]</a>
<hr NOSHADE size="1">
Подписан сетевой договор между российскими университетами-участниками европейского TEMPUS проекта «Улучшение российского креативного  образования: новая магистерская программа  в области цифровых искусств во соответствии со стандартами ЕС»
<a href="http://www.aptechsar.com/news.php?id=010316_2">[ Подробнее... ]</a>-->
<!-- <hr NOSHADE size="1">
ИнПИТ СГТУ осуществляет сбор экспонатов для «Музея информационных технологий и вычислительной техники». Примем с благодарностью компьютерную технику 20 века.</p>
<p><strong>Обращаться: Политехническая, 77, главный корпус СГТУ, ИнПИТ, ауд. 403 </strong></p>
<p><strong> Контактный телефон 99-87-34</strong></p>
<hr NOSHADE size="1">
МФПИТ вошел в состав Международной ассоциации университетов цифровых искусств и дизайна 
<A HREF="http://www.aptechsar.com/news.php?id=170615">[ Подробнее... ]</a>

<hr NOSHADE size="1">
Система менеджмента качества МФПИТ вновь подтверждена международным стандартом ISO<br>
<A HREF="http://www.aptechsar.com/news.php?id=210515_3">[ Подробнее... ]</a>
<hr NOSHADE size="1">
 МФПИТ СГТУ получил сертификат стратегического партнера  компании Autodesk
<A HREF="http://www.aptechsar.com/news.php?id=070714_2">[ Подробнее... ]</a>
<hr NOSHADE size="1">
Международный факультет прикладных информационных технологий (МФПИТ) СГТУ им. Гагарина Ю.А.  в очередной раз подтвердил свой высокий профессионализм, выиграв международный проект по программе TEMPUS Европейского Союза.  
<A HREF="http://www.aptechsar.com/news.php?id=151013_2">[ Подробнее... ]</a>-->
<hr NOSHADE size="1">
Студенты ИнПИТ могут стать членами <b>Студенческого сообщества Autodesk</b> и бесплатно пользоваться учебными материалами <b>Autodesk</b> <a href="http://students.autodesk.com/">http://students.autodesk.com</a>
<hr noshade size="1" />


						</DIV>
						<DIV class="curs"><A HREF="../news.php">[ Все новости ]</A></DIV> 
						<!--<DIV class="curs"><A HREF="">[ Подробнее ]</A></DIV> -->
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
<p><b>Международный образовательный центр ИнПИТ СГТУ имени Гагарина Ю.А.</b></p>
<p><em>Вакансия:</em> Директор<br />
<em>Обязанности:</em> оперативное управление центром компьютерного образования.<br>
<em>Требования:</em> высшее образование, знание рынка дополнительного digital-образования,   опыт руководства людьми, построения процесса работы, распределения и контроля выполнения задач, отличные коммуникабельные навыки, знание информационных технологий.<br>
Резюме обязательно<br>
<em>Обращаться:</em> (8452) 99-86-67, 99-87-15 (Ольга Николаевна)<br>
<em>E-mail:</em> <a href="mailto:olga@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">olga@sstu.ru</a>
</p>
<!--
<hr NOSHADE size="1">
<p><b>Детская компьютерная школа СГТУ имени Гагарина Ю.А.</b></p>
<p><em>Вакансия:</em> Менеджер<br />
<em>Обязанности:</em> организация учебного процесса, ведение документации.<br>
<em>Требования:</em> высшее образование, начальные знания рынка дополнительного digital-образования, организованность, исполнительность, отличные коммуникабельные навыки,
пользователь MS Office. Желателен опыт работы с документами.<br>
Резюме обязательно<br>
<em>Обращаться:</em> (8452) 99-86- 67, 99-87- 15 (Ольга Николаевна)<br>
<em>E-mail:</em> <a href="mailto:olga@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">olga@sstu.ru</a>
</p>


<hr NOSHADE size="1">
Требуется документовед в дирекцию ИнПИТ<br>
тел. 99-87-15 e-mail:  <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>
					
<hr NOSHADE size="1">
<b>Инженер по обслуживанию компьютерной сети, компьютерной и офисной техники:</b>

				<br><B>Требования:</B> высшее техническое образование, желательно выпускники  МФПИТ, ИнЭТМ.  Ответственность, желание повышать квалификацию.

				<br><b>Тел. 99-87-34 </b><A HREF="mailto:demidovaii@sstu.ru">demidovaii@sstu.ru</A>
<hr NOSHADE size="1">

<p><strong>Компания&nbsp;Erle&nbsp;Robotics&nbsp;(Витория, страна Басков)</strong>, занимающаяся разработками в области робототехники и искусственного интеллекта, открыла три вакантные позиции:<strong> разработчик программного обеспечения (software&nbsp;engineer)</strong>, <strong>специалист по продажам (sales&nbsp;and&nbsp;marketing&nbsp;specialist)</strong> и <strong>инженер по оборудованию(hardware&nbsp;engineer)</strong>.</p>

<p><strong>Основное требование к кандидатам: знание и понимание&nbsp;ROS&nbsp;(операционная система для роботов)</strong>.</p>

<p>Более подробную информацию о требованиях к кандидатам можно найти на сайте компании:&nbsp;<a href="http://erlerobotics.com/blog/jobs/?utm_source=Jobs&amp;utm_medium=pdf&amp;utm_content=sales&amp;utm_campaign=jobs" target="_blank">erlerobotics.com</a></p>

<p>Отправить резюме и задать вопросы вы можете по&nbsp;email:&nbsp;<a href="mailto:jobs@erlerobotics.com">jobs@erlerobotics.com</a></p>


--><!--

<hr NOSHADE size="1">
<p><b>В Международный образовательный центр требуется менеджер</b>.</p>
<p>Требования: высшее или незаконченнее высшее образование, коммуникабельность, ответственность, опыт работы с людьми.<br>
Оформление по ТК, полный соцпакет. Зарплата по результатам собеседования.
</p>
<p>Контакты: тел. 99-86-69, Елена Ивановна, Светлана Валентиновна.</p>
<p>Резюме отправлять на&nbsp;<a href="mailto:afanasiev@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">afanasiev@sstu.ru</a></p>




<hr NOSHADE size="1">
<p><strong>Банк «Уралсиб» приглашает на работу студентов последних курсов</strong></p>
<p><strong>Должность:</strong> специалист отдела информационных технологий <strong>Выполняемые функции:</strong>Поддержка внешних клиентов - пользователей системы дистанционного банковского обслуживания(Клиент-Банк).
Работа с первичными бухгалтерскими документами.</p>
<p><strong>Требования к знаниям, умениям и качествам кандидата:</strong>
Знание принципов криптографической защиты информации, знание основных принципов банковской деятельности Представление об основах администрирования ОС Windows Грамотная речь, хорошие коммуникативные качества, стрессоустойчивость.</p>
<p>до 13000 руб.(gross)</p>
<p>Резюме присылать на адрес office@sar.uralsib.ru</p>

<hr NOSHADE size="1">
<p>Требуется <b>директор международного образовательного центра</b>.</p>
<p>Образование высшее, опыт руководящей работы в данном направлении, опытный пользователь ПК, английский язык, умение работать в команде, ответственность.</p>
<p>Резюме подавать до 30 июля 2014 года &nbsp;<a href="mailto:olga@sstu.ru" style="color: rgb(17, 85, 204);" target="_blank">olga@sstu.ru</a></p>
-->
<!--
<hr NOSHADE size="1">
«<b>Дом кино</b>»  приглашает на работу киномеханика-видеоинженера на не полный рабочий день (можно студента). Работа в вечерние часы. Тел.  46-95-65
<hr NOSHADE size="1">
Требуется документовед на полный рабочий день. Образование высшее. Можно без опыта работы. Требования: пользователь офисного пакета ПК, внимательность, ответственность, исполнительность.
тел. 99-87-15 e-mail:  <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

<hr NOSHADE size="1">

Учебному бизнес-центру АРТЕСН требуется на работу бухгалтер. Можно без опыта работы, но со знанием MS Office, 1C Бухгалтерии.
тел. 99-87-15 e-mail:  <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>
--><!--



<hr NOSHADE size="1">

		<B>Менеджер в международный образовательный центр</B>

	

				<br><B>Требования:</B> высшее образование, уверенное знание ПК, опыт работы.

				<br><b>Тел. 99-87-15 </b><A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

	


<hr NOSHADE size="1">
<b>Преподаватель информационных технологий:</b>
<br><br><b>Желательно знание:</b> 
<ul><li>технологий создания веб-приложений, 
<li>программирования на Java, C#, 1C,
<li>Flash и Flex-технологий,
<li>технологий компьютерного монтажа Adobe Premier.
</ul>
<br>Обязательно наличие высшего образования.
 Резюме высылать  по адресу: <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

<br><br><b>1. Руководитель образовательного направления по компьютерной графике</b><br>
<b>Требования:</b> высшее образование, опыт руководящей работы по профилю деятельности,   ответственность, исполнительность. Возраст от 35 лет. <br>

<b>Знания:</b> Уверенное владение MS Office, графическими пакетами.<br>
<br>
<b>2. Руководитель образовательного направления по компьютерному образованию</b><br>
<b>Требования:</b> высшее образование, опыт работы в руководящей должности не менее 3-х лет, 
умение работать в команде, знания в области маркетинга, уверенное владение ПК.<br>
<br>
<b>3. Заместитель руководителя учебного центра по хозяйственной части</b><br>
<b>Требования:</b> высшее образование,  опыт работы в аналогичной должности не менее 3-х лет,  ответственность,
уверенное владение ПК, умение работать с документами.<br>
<br>
<br>Обращаться по тел. 99-87-15. <br>Резюме присылать до <b>15 ноября 2011 года</b> по адресу: <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>



<B>Требуется инженер в отдел технической поддержки</B>
<br><B>Требования:</B> Высшее образование, опыт работы не менее 1 года, навыки администрирования сетей Microsoft Windows, поддержки офисной и компьютерной техники,ответственность, умение работать в команде.<br><b>Тел. 50-93-75 </b><A HREF="mailto:aptechedu@sstu.ru">aptechedu@sstu.ru</A>

						<hr NOSHADE size="1">

<B>Требуется менеджер  по работе с клиентами в учебный центр АПТЭК (АРТЕСН)</B>
<br><B>Требования:</B> в/о, опыт работы не менее 1 года, ответственность, умение работать в команде.<br><b>Тел. 50-93-75 </b><A HREF="mailto:aptechedu@sstu.ru">aptechedu@sstu.ru</A>

						<hr NOSHADE size="1">

<B>Требуется директор студенческого рекламного агентства</B>
<br><B>Требования:</B> в/о или незаконченное высшее, желание сделать бизнес-карьеру,креативность.<br><b>Тел. 50-93-75 </b><A HREF="mailto:aptechedu@sstu.ru">aptechedu@sstu.ru</A>

						<hr NOSHADE size="1">

<B>Требуется начальник отдела маркетинга и рекламы</B>
<br><B>Требования:</B> Высшее образование, опыт работы в рекламном бизнесе не менее 3-х лет.
<br><b>Прием резюме до 30 июля 2010 года</b> по адресу <A HREF="mailto:olga@sstu.ru">olga@sstu.ru</A>

						<hr NOSHADE size="1">

						<b><font color="red">Срочно</font></b> требуется преподаватель в <A HREF="../education.php?id=2">детскую компьютерную школу</A> по направлению <b>Flash, ActionScript, XML</b>

						<hr NOSHADE size="1">

						В связи с расширением штата приглашаются на конкурсной основе<br> <B>Преподаватели</B> по направлениям: 
						<UL>
							<LI>программирование (Java, C#, ASP, JSP) 
							<LI>базы данных (MS SQL Server, Oracle/Developer) 
							<LI>компьютерная графика (Adobe Photoshop, Corel Draw, Macromedia Flash, 3DMax) 
						</UL>
                        -->
<?
/*
						<hr NOSHADE size="1">
						<UL>
							<LI>руководитель направления дополнительного профессионального образования
						</UL>	
*/
?>
<!--
<hr NOSHADE size="1">			
						<b>Требования:</b> в/о, опыт работы 
						<br>Тел. 50-93-75 <A HREF="mailto: aptechedu@sstu.ru">aptechedu@sstu.ru</A>
						<hr NOSHADE size="1">

						</DIV>
<hr NOSHADE size="1">
--><!--<hr NOSHADE size="1">
<b>Работа для студентов и выпускников ИнПИТ</b>
<br> 
<p>Требуется <strong>сотрудник в пресс-центр Торгово-промышленной  палаты</strong> Саратовской области. <strong>Обязанности:</strong> сбор и подготовка информации для сайта саратовтпп.рф, администрирование  сайта,&nbsp;поддержка страниц ТПП в соцсетях, ведение документации пресс-центра  (договоры, письма, списки и др. - не очень много), участие в подготовке  мероприятий, переговоры по заданию руководителя с представителями СМИ,  желание&nbsp;писать&nbsp;пресс-релизы, работать с фото и изображениями,  предлагать свои нестандартные идеи - приветствуется! <br />
	<strong>График работы</strong> с 9 до 18, выходн. сб, вскр. зарплата 8 тыс.&nbsp;<br />
	<strong>Резюме присылать</strong> по адресу&nbsp;<a href="mailto:press@sartpp.ru" target="_blank">press@sartpp.ru</a>, факсу <strong>390-433</strong>. <br />
<strong>Тел. для справок</strong> <strong>390-433</strong>.  директор пресс-центра Шварц Татьяна Григорьевна.</p>
<!--Издательско-полиграфическая фирма приглашает на постоянную работу дизайнеров. 
<br><b>Требования</b>: знание программ CorelDraw (обязательно), Photoshop (обязательно); наличие портфолио (желательно). 
<br><b>Тел.: 91-41-10, 93-40-83</b>.

						<DIV class="curs"><A HREF="http://aptechsar.com/about.php?id=3">[ Все вакансии ]</A></DIV> -->
                        
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
					<TD bgcolor="#F0F0F0" colspan="2"> <DIV class="blue" style="text-decoration: uppercase; padding: 5px 0 0 5px;"><span style="color:#be0000;">Институт</span> прикладных <br>информационных технологий  и коммуникаций</DIV></TD>
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
				Приказом № 898-П от 28.10.2016г. Международный факультет прикладных информационных технологий преобразован в Институт прикладных информационных технологий и коммуникаций (ИнПИТ).<br> В состав ИнПИТ включена кафедра «Информационная безопасность автоматизированных систем» (ИБС). 
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
				<DIV class="blue"><A HREF="news.php?id=mfpit_sert13" target="_blank" class = "blue">Система менеджмента качества ISO</A></DIV>
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

<DIV class="blue">Высшее образование</DIV>
<UL>
<LI>Бакалаврская подготовка по направлениям:
  <UL>
    <LI><A HREF="education.php?id=61" target="_blank">Информатика и вычислительная техника (Профиль «Вычислительные машины, комплексы, системы и сети»)</A>
	<LI><A HREF="education.php?id=996" target="_blank">Информатика и вычислительная техника (Профиль «Программное обеспечение средств вычислительной техники и автоматизированных систем»)</A>
	<LI><A HREF="education.php?id=62" target="_blank">Информационные системы и технологии</A>
	<LI><A HREF="education.php?id=68" target="_blank">Прикладная информатика</A>
    <li><a href="education.php?id=998" target="_blank">Информационная безопасность</a></li>
	<LI><A HREF="education.php?id=67" target="_blank">Реклама и связи с общественностью</A>
	<LI><A HREF="education.php?id=58" target="_blank">Дизайн</A>
        <LI><A HREF="education.php?id=69" target="_blank">Программная инженерия</A>
<LI><A HREF="education.php?id=74" target="_blank">Телевидение</A>
<LI><A HREF="education.php?id=77" target="_blank">Конструирование изделий лёгкой промышленности</A>

</UL></li>
<li>
Подготовка специалистов по направлению:

<ul>
	<li><a href="http://www.aptechsar.com/education.php?id=999" target="_blank">Информационная безопасность автоматизированных систем</a></li>
</ul>
</li>
<LI>Магистратура по направлениям:
<UL>
	<LI><A HREF="education.php?id=60">Информатика и вычислительная техника (Профиль «Информационно-коммуникационные системы»)</A>
	<LI><A HREF="education.php?id=59">Информационные системы и технологии</A>
    <LI><A HREF="education.php?id=73">Прикладная информатика</A>
	<LI><A HREF="education.php?id=78">Программная инженерия</A>
	<LI><A HREF="education.php?id=79">Информационная безопасность</A>
 
<li><a href="http://www.aptechsar.com/education.php?id=75" target="_blank">Реклама и связи с общественностью</a></li>
</UL>
<LI>Аспирантура
</UL>

<hr NOSHADE size="1">

<p><DIV class="blue">Структура ИнПИТ</DIV>
<b>Кафедры института</b>
<UL>
<LI><A HREF="education.php?id=64">Кафедра «Прикладные информационные технологии»</A>
<LI><A HREF="education.php?id=65">Кафедра «Информационно-коммуникационные системы и программная инженерия»</A>
<LI><A HREF="education.php?id=ibs">Кафедра «Информационная безопасность автоматизированных систем»</A>
<LI><A HREF="education.php?id=66">Кафедра «Медиакоммуникации»</A>
<LI><A HREF="education.php?id=71">Кафедра «Дизайн и цифровые искусства»</A>
</UL>



<hr NOSHADE size="1">

<p><DIV class="blue">Информация о мероприятиях, результаты участия в которых учитываются при поступлении в СГТУ имени Гагарина Ю.А.</DIV>
<UL>
<LI><a href="aboutmfpit.php?id=olymp_mob">Региональная Олимпиада по разработке мобильных приложений</a>
<LI><a href="aboutmfpit.php?id=3dday18">Открытый Всероссийский конкурс по трехмерному моделированию и визуализации «3D-день и 3D-ночь»</a>
<LI><a href="aboutmfpit.php?id=3dday">Региональная Олимпиада по трехмерным технологиям «3D-день и 3D-ночь»</a>
<LI><a href="aboutmfpit.php?id=dw18sar">Саратовский региональный тур XVII Международного конкурса компьютерных работ для детей, юношества и студенческой молодежи "Цифровой ветер - 2018"</a>
<LI><a href="aboutmfpit.php?id=dw18">Международный конкурс  компьютерных работ среди детей, юношества и студенческой молодежи «Цифровой ветер-2018»</a>
<LI><a href="aboutmfpit.php?id=digitalstart">Всероссийский конкурс компьютерных работ среди школьников "Цифровой старт - 2017"</a>
<LI><a href="aboutmfpit.php?id=cryptolymp">Межрегиональная олимпиада школьников по математике и криптографии</a>
<LI><a href="aboutmfpit.php?id=olymp_it">Межрегиональная олимпиада школьников по информатике и компьютерной безопасности</a>
<LI><a href="aboutmfpit.php?id=dw17">XVI Международный конкурс компьютерных работ для детей, юношества и студенческой молодежи «Цифровой ветер - 2017»</a>
<LI><a href="aboutmfpit.php?id=sardw17">Региональный Саратовский тур XVI Международного конкурса компьютерных работ для детей, юношества и студенческой молодежи «Цифровой ветер - 2017»</a>
<LI><a href="aboutmfpit.php?id=dstart_16">Всероссийский конкурс компьютерных работ среди школьников «Цифровой старт - 2016»</a>


</UL>
<a href="education/poryadok-ucheta-ind-dostizh-2017.doc"> Порядок учета индивидуальных достижений поступающих при приеме в СГТУ имени Гагарина Ю.А. в 2018 году
на обучение по программам бакалавриата, программам специалитета и программам магистратуры</a>


<hr NOSHADE size="1">

<p><DIV class="blue">Международный образовательный центр</DIV>

Центр проводит обучение по авторизованным курсам в области информационных технологий для всех,<br> желающих повысить квалификацию в области ИТ, и состоит из следующих подразделений:

<UL>

	<LI>Авторизованный учебный центр <a href="http://www.aptechsar.com/education.php?id=15">Aptech Computer Education</a>

<li>Учебный центр компьютерной графики и мультимедиа  <br><a href="http://www.focus-design.org/">Фокус-дизайн</a>


	<!--<LI>Авторизованный учебный центр компьютерной графики и мультимедиа <a href="http://www.aptechsar.com/education.php?id=14">Arena Multimedia</a>

	<LI>Авторизованный учебный центр компьютерной мультипликации <a href="http://www.aptechsar.com/toonboom.php?id=tb_5">Toon Boom Technologies</a>

	
<LI>Авторизованный учебный центр <a href="http://www.aptechsar.com/it-academy/"> Softline Academy</a>-->

	<LI>Авторизованный учебный центр <a href="http://www.aptechsar.com/education.php?id=16"> Microsoft Imagine Academy</a>

	<!--<LI><a href="http://www.aptechsar.com/testsmain.php">Центры авторизованного тестирования</a>-->



	<LI>Авторизованная Академия <a href="http://www.cisco.com/web/learning/netacad/index.html">Cisco</a>

</UL>

<p><div class="blue">Центр информационных технологий и дистанционного образования </div>
	
<hr NOSHADE size="1">	


<p>В составе ЦИТ и ДО:</p>
<ul>
  <li>лаборатория распределенных вычислений</li>
  <li>лаборатория виртуальных технологий</li>
  <li>Grid-узел на основе технологий НР, позволяющий вычислять задачи большой  размерности</li>
</ul>

<p>Сотрудниками ЦИТ и ДО осуществляется техническая поддержка компьютерной сети  ИнПИТ, &nbsp;разработка программного обеспечения, апробация новых  информационных технологий, разработка приложений виртуальной реальности.</p>

<hr NOSHADE size="1">

<p><DIV class="blue">Учебно-инновационный центр «Детская компьютерная школа»</DIV>
<a href="http://digital-school.net">digital-school.net</a><br>
Предназначен для подготовки школьников в области информационных технологий. Центр разрабатывает инновационные программы изучения программирования, Интернет-технологий, компьютерной графики и мультимедиа, обучает школьников г. Саратова и Саратовской области, ведет переподготовку преподавателей информатики в средних школах, проводит летние и зимние школы программирования.

<hr NOSHADE size="1">

<p><DIV class="blue">Учебно-научно-производственный телевизионный центр</DIV>
<!--Главной целью работы телевизионного центра является обеспечение учебного процесса по специальностям <A href="../education.php?id=12" target="_blank">«Реклама»</A> и <A href="../education.php?id=43" target="_blank">«Информационные технологии в медиаиндустрии»</A>.--> На базе центра проводятся  практические занятия по курсам, связанным с телевизионным творчеством и телерекламой, а также летние производственные практики.
<p>Центр разрабатывает и изготавливает  рекламные ролики, информационно-рекламные сюжеты, учебные фильмы для подразделений СГТУ и сторонних организаций.




<!--<hr NOSHADE size="1">
<p><DIV class="blue">Ученый Совет ИнПИТ</DIV>
<p><strong>Состав  Ученого Совета</strong>:</p>
<ol>
	<li>Долинина О.Н. &ndash; директор ИнПИТ, зав.&nbsp; кафедрой ПИТ - председатель Ученого совета</li>
	<li>Кумова С.В. &ndash; доцент кафедры ПИТ, заместитель председателя Ученого совета</li>
	<li>Сытник А.А., заведующий кафедрой ИКСП</li>
	<li>Шульга Т.Э., профессор, кафедры ИКСП</li>
	<li>Сытник И.Ф., доцент кафедры ИКСП</li>
	<li>Умнова Е.Г., доцент кафедры ИКСП</li>
	<li>Каликинская Е.Ю., старший преподаватель кафедры ПИТ</li>
	<li>Печенкин В.В., профессор кафедры ПИТ</li>
	<li>Бровко А.В., доцент кафедры ПИТ - секретарь Ученого совета</li>
	<li>Карпова Г.Г., зав. кафедрой МКМ</li>
	<li>Лейни Р.Н., доцент кафедры МКМ</li>
	<li>Осина О.Н., доцент кафедры МКМ</li>
	<li>Демидова И.И., директор студенческого рекламного агентства ИнПИТ</li>
	<li>Бороздюхин А.А., директор ЦИТ и ДО</li>
	<li>Забродина Г.Д., зав. кафедрой ДЦИ</li>
	<li>Загоруйко М.В., доцент кафедры ДЦИ</li>
	<li>Александрова Т.В. &ndash; доцент кафедры ДЦИ</li>
	<li>Торопова О.А., доцент кафедры ИКСП</li>
	<li>Глухова Р.М.,&nbsp;доцент кафедры ИКСП, профорг</li>
</ol>-->

<!--<br>
<p>Приказ <a href="http://aptechsar.com/О%20составе%20Ученого%20Совета%20МФПИТ.doc">О  составе Ученого Совета МФПИТ</a> <br />
Приказ <a href="http://aptechsar.com/council.doc">Об изменении состава Ученого совета МФПИТ</a> <br />
Приказ <a href="http://aptechsar.com/council_june15.doc">Об изменении состава Ученого совета МФПИТ июнь 2015</a> <br />
  <a href="http://aptechsar.com/council_plan_2014-15.doc">План  работы совета МФПИТ 2015.doc</a></p>-->




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
						<DIV class="f12_colon"><hr NOSHADE size="1"><b>Как поступить на авторизованные программы Aptech?</b></DIV>
						<DIV class="f12_colon">
Для поступления на программу подготовки <A HREF="http://www.focus-design.o