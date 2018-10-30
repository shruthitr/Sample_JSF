<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Menu page</title>
</head>
<body>
<a href="../f17g305/">Group Home Page</a>
<f:view>

<h3 align="center">Welcome to world schema</h3>
<h4> Please Select the operation</h4>

<a href="logout.jsp">Logout</a> 


<h:form id="menuForm">


			<h:outputLabel value="Please Select the query" />
					<h:selectOneMenu  value="#{loginBean.sqlQuery}" >
			
				<f:selectItem itemValue="SELECT AVG(population)FROM country" itemLabel="Find average population from country" />
				<f:selectItem itemValue="SELECT AVG(LIFEEXPECTANCY) FROM  country" itemLabel="Find average life expectancy from country" />
				<f:selectItem itemValue="select MAX(Population) FROM  city" itemLabel="Find maximum life expectancy from city" />
				<f:selectItem itemValue="Select avg(percentage) from countrylanguage" itemLabel="Find average percentage from country" />
							</h:selectOneMenu >
		<br /><br />
			
				<center>
<h:commandButton type="submit" value="DisplayResults" action="#{loginBean.displayResults}" >
				</h:commandButton>
			</center>

		</h:form>
<h:outputLabel value="Result" />
<h:inputText value="#{loginBean.finalResult}" />
			<br />



</f:view>
</body>
</html>