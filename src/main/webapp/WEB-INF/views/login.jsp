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
<title><fmt:message key="login" />
</title>
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
					<td><input id="usernamefield" type="text" name="j_username" />
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="passwordfield" type="password"
						name="j_password" />
					</td>
					<td align="right"><input type="submit" value="Login" />
					</td>
				</tr>
			</table>
		</form>
		<br>
		<h4>
			New to Book Library? <em>Join today!</em>
		</h4>
		<form id="registerForm" name="registerForm" action="register" method="post">
			<table>
				<tr>
					<td><fmt:message key="email" />
					</td>
					<td><input id="registeremailfield" type="text" name="registeremail" />
					</td>
				</tr>
				<tr>
					<td><fmt:message key="username" />
					</td>
					<td><input id="registerusernamefield" type="text" name="registerusername" />
					</td>
				</tr>
				<tr>
					<td><fmt:message key="password" />
					</td>
					<td><input id="registerpasswordfield" type="password" name="registerpassword" />
					</td>
				</tr>
				<tr>
					<td><fmt:message key="passwordConfirm" />
					</td>
					<td><input id="registerpasswordconfirmfield" type="password" name="registerpasswordconfirm" />
					</td>
					<td align="right"><input type="submit" value="<fmt:message key="register" />" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>