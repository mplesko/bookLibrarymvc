<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>"
	type="text/css" />
<title><fmt:message key="login" />
</title>
</head>
<
<body onload='document.loginForm.j_username.focus();'>
	<%@ include file="/includes/welcomebar.html"%>
	<%@ include file="/includes/toolbar.html"%>
	<%@ include file="/includes/leftbar.html"%>
	<div id="content">
		<form id="loginForm" name="loginForm" action="j_spring_security_check" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input id="usernameField" type="text" name="j_username" />
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="passwordField" type="password" name="j_password" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Login" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>