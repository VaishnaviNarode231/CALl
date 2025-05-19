<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>CRM - Home</title></head>
<body>
<h2>Customer List</h2>
<a href="showFormForAdd">Add Customer</a>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName} ${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>
                <a href="showFormForUpdate?customerId=${customer.id}">Update</a>
                <a href="delete?customerId=${customer.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
