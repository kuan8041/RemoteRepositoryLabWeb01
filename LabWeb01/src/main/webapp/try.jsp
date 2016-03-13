<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function doClick(){
document.getElementByld("img1").style.display = "inline";

setTimeout(function(){
document.getElementByld("img1").style.display = "none"; } , 10000);

}
function setStyle(x)
{
document.getElementById(x).style.background="blue"
}
function upperCase(){
	
	var x= document.getElementByld("fname").value;
	document.getElementByld("fname").value=x.toUpperCase();
	
}
function trew(){
	var node=document.getElementsByTagName("h1");
	var temp1=node[0].firstChild.cloneNode(false);
	var temp2=node[1].firstChild.cloneNode(false);
	node[0].replaceChild(temp2,node[0].firstChild);
	node[1].replaceChild(temp1,node[1].firstChild);
	
	
}
</script>
</head>
<body>
<h1>  no key</h1>
<h1> key</h1>
<input type="button" value="Load" onclick="doClick()">
<img id="img1" src="img/01.gif" style="display:none"><br/>
First name: <input type="text" onfocus="setStyle(this.id)" id="fname">
<br />
Last name: <input type="text"  id="fname" onblur="upperCase()">
good<input type="text" name="id" onfocus="trew()">


</body>
</html>