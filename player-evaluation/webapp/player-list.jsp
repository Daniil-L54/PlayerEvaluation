<table border="1">
<tr>
<th>ID</th><th>Name</th><th>Age</th><th>Action</th>
</tr>

<c:forEach items="${list}" var="p">
<tr>
<td>${p.playerId}</td>
<td>${p.name}</td>
<td>${p.age}</td>
<td>
<a href="PlayerServlet?action=edit&id=${p.playerId}">Edit</a>
<a href="PlayerServlet?action=delete&id=${p.playerId}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
