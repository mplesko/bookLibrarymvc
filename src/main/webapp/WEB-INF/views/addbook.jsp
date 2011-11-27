<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<h1>Add Book</h1>

		<form:form id="addBookForm" name="addBookForm" action="addbook" modelAttribute="addBookBean" method="post">
			<table>
				<tr>
					<td>Book Title</td>
					<td><form:input id="bookTitle" path="bookTitle" />
					</td>
				</tr>
				<tr>
					<td>Author</td>
					<td>
						<form:select path="authorId">
							<form:options items="${authors}" 
								itemValue="id" 
								itemLabel="authorLastNameFirstName" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" value="Add" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>