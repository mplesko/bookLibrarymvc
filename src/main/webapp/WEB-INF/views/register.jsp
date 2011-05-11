<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>"
	type="text/css" />
<title><fmt:message key="login" /></title>
</head>
<body>
	<%@ include file="/includes/welcomebar.html"%>
	<%@ include file="/includes/toolbar.html"%>
	<%@ include file="/includes/leftbar.html"%>
	<div id="content">
		<form:form modelAttribute="registerBean">
			<table>
				<tr>
					<td><fmt:message key="email" /></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><fmt:message key="username" /></td>
					<td><form:input path="username" id="usernamefield" /></td>
				</tr>
				<tr>
					<td><fmt:message key="password" /></td>
					<td><form:password path="password" id="passwordfield" showPassword="true"/></td>
				</tr>
				<tr>
					<td><fmt:message key="passwordConfirm" /></td>
					<td><form:password path="passwordConfirm" id="passwordconfirmfield" showPassword="true"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="<fmt:message key="register" />"  /></td>
				</tr>
			</table>			
		</form:form>
	</div>
</body>
</html>