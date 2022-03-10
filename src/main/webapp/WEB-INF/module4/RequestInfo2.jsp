<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestInfo</title>
</head>
<body>
<ul>
  <li>Request method: ${pageContext.request.method}</li>
  <li>Client address: ${pageContext.request.remoteAddr}</li>
  <li>hello: ${hello}</li>
  <li>request scope hello: ${requestScope.hello}, ${requestScope["hello"]}</li>
  <li>session scope hello: ${sessionScope.hello}, ${sessionScope["hello"]}</li>
  <li>parameter a: ${param.a}, ${param["a"]}</li>
  <li>Value of the cookie JSESSIONID: ${cookie.JSESSIONID.value}, ${cookie["JSESSIONID"].value}</li>
</ul>
</body>
</html>