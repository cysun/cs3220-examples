<%! int counter = 1; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>You are visitor #
<%= counter %>.
<% ++counter; %>
</body>
</html>
