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
<title>Log in Page</title>
</head>
<body>
<f:view>
	<h:form id="loginForm">
		<h:outputLabel  value="username:" />
		<h:inputText value="#{loginBean.userName}" />
			<br /><br />
		<h:outputLabel value="password" />
		<h:inputSecret value="#{loginBean.passWord}"></h:inputSecret>
			<br /><br />
			<h:outputLabel value="SQLServer" />
		<h:inputText value="MYSQL" readonly="true" />
			<br /><br />
		<h:outputLabel value="SchemaName" />
		<h:inputText value="World" readonly="true" />
			<br /><br />
				<h:outputLabel value="HostName" />
		<h:selectOneListbox value="#{loginBean.hostName}" size="1">
			<f:selectItem itemValue="131.193.209.54" itemLabel="131.193.209.54" />
			<f:selectItem itemValue="131.193.209.57" itemLabel="131.193.209.57" />
			<f:selectItem itemValue="131.193.209.68" itemLabel="131.193.209.68" />
			<f:selectItem itemValue="131.193.209.69" itemLabel="131.193.209.69" />
			<f:selectItem itemValue="localhost" itemLabel="Local Host" />
		</h:selectOneListbox>
			<br /><br />
		<center>
			<h:commandButton type="submit" value="Login"
				action="#{loginBean.getConnection}">
			</h:commandButton>
		</center>
	</h:form>
</f:view>
</body>
</html>