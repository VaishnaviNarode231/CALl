<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Add Contact</title></head>
<body>
<h2>${contact.id != null ? 'Edit' : 'Add'} Contact</h2>
<form action="/save" method="post">
    <input type="hidden" name="id" value="${contact.id}"/>
    Name: <input type="text" name="name" value="${contact.name}"/><br/>
    Email: <input type="text" name="email" value="${contact.email}"/><br/>
    Phone: <input type="text" name="phone" value="${contact.phone}"/><br/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
