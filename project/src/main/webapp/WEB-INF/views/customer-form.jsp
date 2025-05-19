<html>
<head><title>Add/Edit Customer</title></head>
<body>
<h2>Customer Form</h2>
<form action="saveCustomer" method="post">
    <input type="hidden" name="id" value="${customer.id}" />
    First Name: <input type="text" name="firstName" value="${customer.firstName}" /><br/>
    Last Name: <input type="text" name="lastName" value="${customer.lastName}" /><br/>
    Email: <input type="email" name="email" value="${customer.email}" /><br/>
    <input type="submit" value="Save"/>
</form>
<a href="list">Back to List</a>
</body>
</html>
