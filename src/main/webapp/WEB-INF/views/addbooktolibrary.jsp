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
		<h1>Add Book To Library</h1>

		<form:form id="addBookToLibraryForm" name="addBookToLibraryForm" 
			action="addbooktolibrary" modelAttribute="addBookToLibraryBean" 
			method="post">
			<table>
				<tr>
					<td>Book</td>
					<td>
						<form:select path="bookId">
							<form:options items="${books}" 
								itemValue="id" 
								itemLabel="title" />
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