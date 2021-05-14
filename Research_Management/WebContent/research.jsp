<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "model.ResearchManagement" %>
      
      
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Research Management</title>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/research.js"></script>
</head>

<body>
		<div class="container"><div class="row"><div class="col-6">
		<h1>Research Management</h1>
		<form id="formItem" name="formItem">
			userName:
			<input id="name" name="name" type="text"class="form-control form-control-sm">
			<br> 
			email:
			<input id="email" name="email" type="text"class="form-control form-control-sm">
			<br> 
			ProjectTitle:
			<input id="projectTitle" name="projectTitle" type="text"class="form-control form-control-sm">
			<br> 
			totalCost:
			<input id="totalCost" name="totalCost" type="text"class="form-control form-control-sm">
			<br>
			duration:
			<input id="duration" name="duration" type="text"class="form-control form-control-sm">
			<br>
			catogary:
			<input id="catogary" name="catogary" type="text"class="form-control form-control-sm">
			<br>
			<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
			<input type="hidden" id="rid" name="rid" value="">
		</form>
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
		<div id="divItemsGrid">
		<%
			ResearchManagement researchObj = new ResearchManagement();
			out.print(researchObj.readResearch());
		%>
		</div>
		</div> </div> </div>
</body>
</html>