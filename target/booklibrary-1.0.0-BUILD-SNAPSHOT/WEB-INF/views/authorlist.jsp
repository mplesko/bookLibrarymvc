<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>Author List</h1>

		<ul>
			<c:forEach items="${authors}" var="author">
				<li>${author.firstName} ${author.lastName}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>