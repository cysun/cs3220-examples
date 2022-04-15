<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>
</head>
<body>

<p>Please enter your username and password:</p>

<form action="ShowEmployee" method="post">
Username: <input type="text" name="username" size="40" /> <br/>
Password: <input type="text" name="password" size="40" /> <br/>
<input type="submit" name="submit" value="OK" /> <br />
</form>

<p>The valid username/password pairs are:</p>
<ul>
  <li>john/abc</li>
  <li>jane/123</li>
  <li>joe/xyz</li>
</ul>

<p>Because the code create the SQL query statement using string concatenation:</p>
<code>
"select * from employees where username = '" + username + "' and password = '" + password + "'"
</code>
<p>It is vulnerable to SQL injection attack. For example, an attacker who does
not know any username or password can enter anything for username, and the
following as password:</p>
<code>' or '1' = '1</code>
<p>Note that regardless of what's entered for username/password,
<code>or '1'='1'</code> will force the selection condition to be always true,
so all records will be returned.</p>
</body>
</html>
