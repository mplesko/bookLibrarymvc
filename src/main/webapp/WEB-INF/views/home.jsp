<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>"
	type="text/css" />
<title><fmt:message key="title" />
</title>
</head>
<body>
	<%@ include file="/includes/welcomebar.html" %>
	<%@ include file="/includes/toolbar.html" %>
	<%@ include file="/includes/leftbar.html" %>
	<div id="content">default booklibrarymvc contentx</div>
	
</body>
</html>