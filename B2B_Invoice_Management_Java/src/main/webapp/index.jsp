<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>H2H Forms</title>
</head>
<body>

<h2>Add User Form:</h2>
<form action="AddServlet" method="post">
	<label>CUSTOMER_ORDER_ID: </label><input type="number" name="CUSTOMER_ORDER_ID"><br>
	<label>SALES_ORG: </label><input type="number" name="SALES_ORG"><br>
	<label>DISTRIBUTION_CHANNEL: </label><input type="text" name="DISTRIBUTION_CHANNEL"><br>
	<label>COMPANY_CODE: </label><input type="number" name="COMPANY_CODE"><br>
	<label>ORDER_CREATION_DATE: </label><input type="text" name="ORDER_CREATION_DATE"><br>
	<label>ORDER_CURRENCY: </label><input type="text" name="ORDER_CURRENCY"><br>
	<label>CUSTOMER_NUMBER: </label><input type="number" name="CUSTOMER_NUMBER"><br>
	<label>AMOUNT_IN_USD: </label><input type="number" step=any name="AMOUNT_IN_USD"><br>
	<input type="submit" Value="Submit">
</form>

<h2>Edit Invoice Form:</h2>
<form action="EditServlet" method="post">
	<label>ID: </label><input type="number" name="UPD_ID"><br>
	<label>DISTRIBUTION_CHANNEL: </label><input type="text" name="UPD_DISTRIBUTION_CHANNEL"><br>
	<label>COMPANY_CODE: </label><input type="number" name="UPD_COMPANY_CODE"><br>
	<label>ORDER_CURRENCY: </label><input type="text" name="UPD_ORDER_CURRENCY"><br>
	<input type="submit" Value="Submit">
</form>	

<h2>Delete Invoice Form:</h2>
<form action="DeleteServlet" method="post">
	<label>ID: </label><input type="number" name="DEL_ID"><br>
	<input type="submit" Value="Submit">
</form>

</body>
</html>