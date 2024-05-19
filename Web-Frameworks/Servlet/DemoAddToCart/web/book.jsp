<%@page import="sample.product.CartDTO"%>
<%@page import="sample.book.BookDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books Shop</title>
</head>
<body>
    <h1>Books Shop</h1>

    <a href="./login.html">Back to Login</a>

    <table border="1">
        <thead>
            <tr>
                <th>SKU</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Quantity</th>
                <td style="width: 100px; text-align: center">AddToCart</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${booksList}">
                <tr>
                    <form action="BookController" method="POST">
                        <td>${book.SKU}</td>
                        <td>${book.Name}</td>
                        <td>${book.Price}</td>
                        <td>${book.description}</td>
                        <td>${book.quantity}</td>
                        <td style="width: 20px; text-align: center; background-color: #C7C8CC; cursor: pointer">
                            <input type="hidden" name="command" value="ADD_TO_CART" />
                            <input type="hidden" name="bookID" value="${book.SKU}" />
                            <input type="submit" value="Add to cart" />
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="CartController">Click here to show your cart</a>
</body>
</html>
