<form method="post" action="PlayerServlet">
Name: <input name="name" required><br>
Full Name: <input name="fullName" required><br>
Age: <input type="number" name="age" min="10" max="60"><br>
Index ID: <input name="indexId"><br>
<button type="submit">Save</button>
</form>

<p style="color:red">${error}</p>
