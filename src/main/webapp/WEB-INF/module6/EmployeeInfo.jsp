<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>Employee Info</title>
</head>
<body>

<table border="1">
  <tr><th>ID</th><th>Username</th><th>Password</th><th>Birthday</th><th>Salary</th></tr>
  <c:forEach items="${employees}" var="employee">
  <tr>
    <td>${employee.id}</td>
    <td>${employee.username}</td>
    <td>${employee.password}</td>
    <td>${employee.birthday}</td>
    <td>${employee.salary}</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>
