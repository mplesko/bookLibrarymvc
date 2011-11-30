<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>-->
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
		<h1>library</h1>

		<form id="libraryForm" name="libraryForm" action="editlibrary">
			<table border="1">
				<tr>
					<th>Remove From Library</th>
					<th>Book</th>
				</tr>
				<c:forEach items="${libraryBooks}" var="book">
					<tr>
						<td align="center"><input type="checkbox" name=selectedBookIds value="${book.id}"/></td>
						<td>${book.title} - ${book.authorName}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<input type="submit" name="removebooksfromlibrary" value="Remove Selected Book(s)" />
			<input type="submit" name="addabooktolibrary" value="Add a Book to Library" />
		</form>
	</div>
</body>
</html>