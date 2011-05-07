<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>"
	type="text/css" />
<title><fmt:message key="login" /></title>
</head>
<body onload='document.loginForm.j_username.focus();'>
	<%@ include file="/includes/welcomebar.html"%>
	<%@ include file="/includes/toolbar.html"%>
	<%@ include file="/includes/leftbar.html"%>
	<div id="content">
		<c:if test="${!empty param.login_error}">
			<h2>
				<font color="red"> <spring:message code="login.invalid" /> </font>
			</h2>
		</c:if>
		<form id="loginForm" name="loginForm" action="j_spring_security_check" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input id="usernamefield" type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="passwordfield" type="password" name="j_password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Login" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button" value="<fmt:message key="register" />" 
					    onclick="location.href="registration"/></td>
					<td><a href="registration"><fmt:message key="register" /> </a></td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>