<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PropertyTest</title>
</head>
<body>
<p>There are ${fn:length(a.numbers)} values in a.numbers.</p>
<p><fmt:formatDate value="${a.date}" pattern="M/d/yyyy" /></p>
<p><c:out value="a<b>c" /></p>
<p><c:url value="/abcd" /></p>
<p>The regular for loop:</p>
<ul>
  <c:forEach begin="0" end="9" step="1" var="i">
  <li><fmt:formatNumber value="${a.numbers[i]}" pattern="0.###" /></li>
  </c:forEach>
</ul>
<p>The enhanced for loop:</p>
<ul>
  <c:forEach items="${a.numbers}" var="number" varStatus="status">
  <li>${status.index} - ${number}</li>
  </c:forEach>
</ul>
<p>
  <c:if test="${a.weekdays[0] == 'mon'}">Monday</c:if>
</p>
</body>
</html>
