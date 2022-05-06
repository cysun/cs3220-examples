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
<tr data-entry-id="${entry.id}">
  <td>${entry.name} says</td>
  <td>${entry.message}</td>
  <td>
  	<button class="delete">Delete</button>
  </td>
</tr>
</c:forEach>
<tr id="form">
  <td><input id="name" type="text" name="name"></td>
  <td><input id="message" type="text" name="message"></td>
  <td><button id="add">Add</button></td>
</tr>
</table>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
$(function(){
	$(".delete").click(function(){
		var row = $(this).closest("tr");
		var id = row.attr("data-entry-id");
		$.ajax({
			url: "DeleteEntry",
			data: {id: id},
			success: function() { row.remove(); }
		});
	});
	$("#add").click(function(){
		var name = $("#name").val();
		var message = $("#message").val();
		$.ajax({
			url: "AddComment",
			method: "post",
			data: {
				name: name,
				message: message
			},
			success: function(data){
				var row = $("<tr><td>" + name + "</td><td>" + message + "</td><td></td></tr>");
				var button = $("<button>Delete</button>");
				button.click(function(){
					$.ajax({
						url: "DeleteEntry",
						data: {id: data},
						success: function() { row.remove(); }
					});
				});
				row.children("td:last").append(button);
				$("#form").before(row);
				$("#name").val("");
				$("#message").val("");
			}
		})
	});
});
</script>
</body>
</html>