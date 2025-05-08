<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Contact List</title></head>
<body>
<h2>Contacts</h2>
<a href="new">Add New Contact</a>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Actions</th></tr>
    <c:forEach var="contact" items="${listContacts}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.phone}</td>
            <td>
                <a href="edit/${contact.id}">Edit</a>
                <a href="delete/${contact.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
