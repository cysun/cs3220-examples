<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook</title>
</head>
<body>
<h2>GuestBook</h2>
<table border="1">
<c:forEach items="${entries}" var="entry">
<tr>
  <td>${entry.name} says</td>
  <td>${entry.message}</td>
  <td>
    <a href="EditEntry?id=${entry.id}">Edit</a> |
    <a href="DeleteEntry?id=${entry.id}">Delete</a>
  </td>
</tr>
</c:forEach>
</table>
<p><a href="AddComment">Add Comment</a></p>
</body>
</html>