<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Entry</title>
</head>
<body>
<h2>Edit Entry</h2>
<form action="EditEntry" method="post">
<input type="hidden" name="id" value="${entry.id}">
Name: <input type="text" name="name" value="${entry.name}"><br>
<textarea name="message" rows="6" cols="40">${entry.message}</textarea><br>
<button>Save</button>
</form>
</body>
</html>