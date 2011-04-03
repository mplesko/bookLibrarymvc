<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/resources/styles.css"/>"
	type="text/css" />
<title><fmt:message key="title" />
</title>
</head>
<body>
	<div id="header">
		<table>
			<tr>
				<td><img src="/resources/deckView.jpg" alt="Deck View"
					height="100" /></td>
				<td>
					<h1>
						<fmt:message key="welcome" />
					</h1>
					<h1>
						<fmt:message key="welcome2" />
					</h1>
				</td>
			</tr>
		</table>
	</div>
	<div id="toolBar">toolbar</div>
	<div id="leftBar">leftbar</div>
	<div id="content">default booklibrarymvc contentx</div>
</body>
</html>