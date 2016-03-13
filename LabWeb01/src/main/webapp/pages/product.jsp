<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />
<style>

</style>
<title>Product</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
function doFoucule(){
	/*
	var nodes=document.getElementsByTagName("h3");
	var a1=nodes[0].firstChild.cloneNode(false);
	var a2=nodes[1].firstChild.cloneNode(false);
	nodes[0].replaceChild(a2,nodes[0].firstChild);
	nodes[1].replaceChild(a1,nodes[1].firstChild);

	*/
	/*
var nodes=document.getElementsByTagName("h3");
	var text0= nodes[0].firstChild.cloneNode(false);
	var text1=nodes[1].firstChild.cloneNode(false);
	var formElement=document.getElementsByTagName("form")[0];
	alert("action="+formElement.getAttribute("action"));
	formElement.setAttribute("action","/LabWeb01/pages/product.view");
	*/
	var inputNode = document.createElement("input");
	inputNode.setAttribute("type","submit");
	inputNode.setAttribute("value","Click");
	
	var  testNode= document.getElementByld("h3");
	testNode.appendChild(inputNode);
}
</script>
</head>
<style>


</style>
<body>

<h3>Welcome, </h3>

<h3>Product Table</h3>

<form action="/LabWeb01/pages/product.controller" method="get">
<table>
	<tr>
		<td>ID : </td>
		<td><input type="text" name="id" value="${param.id}" onfocus="doFoucule()"></td>
		<td><span class="error">${error.id}</span></td>
	</tr>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td></td>
	</tr>

	<tr>
		<td>Price : </td>
		<td><input type="text" name="price" value="${param.price}"></td>
		<td><span class="error">${error.price}</span></td>
	</tr>
	<tr>
		<td>Make : </td>
		<td><input type="text" name="make" value="${param.make}"></td>
		<td><span class="error">${error.make}</span></td>
	</tr>
	<tr>
		<td>Expire : </td>
		<td><input type="text" name="expire" value="${param.expire}"></td>
		<td><span class="error">${error.expire}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
			<input type="submit" name="prodaction" value="Update">
		</td>
		<td>
			<input type="submit" name="prodaction" value="Delete">
			<input type="submit" name="prodaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>
</body>
</html>