<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>"
	type="text/css" />
<title><fmt:message key="title" /></title>
</head>
<body>
	<%@ include file="/includes/welcomebar.html"%>
	<%@ include file="/includes/toolbar.html"%>
	<%@ include file="/includes/leftbar.html"%>
	<div id="content">
		<h1>Add Authors</h1>

		<form id="addAuthorForm" name="addAuthorForm" action="addauthor" method="post">
			<table>
				<tr>
					<td>Author First Name</td>
					<td><input id="authorfirstnamefield" type="text" name="authorfirstname" />
					</td>
				</tr>
				<tr>
					<td>Author Last Name</td>
					<td><input id="authorlastnamefield" type="text" name="authorlastname" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" value="Add" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>