<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/resources/tablesorter/tablesorterstyles.css"/>" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/tablesorter/jquery.tablesorter.js" />"></script>
<script language="javascript"> 
$(document).ready(function(){
    $('#booktable').tablesorter(); });
</script>

<title><fmt:message key="title" /></title>
</head>
<body>
	<%@ include file="/includes/welcomebar.html"%>
	<%@ include file="/includes/toolbar.html"%>
	<%@ include file="/includes/leftbar.html"%>
	<div id="content">
		<h1>Book List</h1>

		<table id="booktable" class="tablesorter">
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.sortableTitle}</td>
					<td>${book.sortableAuthorName}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</body>
</html>