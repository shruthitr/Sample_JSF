<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fail</title>
</head>
<body>
<f:view>
<h3 align="center"> <h:outputText value="#{loginBean.errorMessage}" /> </h3>
<div align="center"><a href="index.jsf">Try Again.</a>
<a href="../f17g305/">Group Home Page</a>
</div>
</f:view>
</body>
</html>