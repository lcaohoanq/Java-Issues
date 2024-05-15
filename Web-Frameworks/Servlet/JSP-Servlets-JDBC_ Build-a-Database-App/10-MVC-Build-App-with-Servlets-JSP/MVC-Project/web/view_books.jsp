<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <ul>
            <c:forEach var="book" items="${book_list}">
                <li>
                    ${book}
                </li>
            </c:forEach>
        </ul>

        <h1 style="color: blue">This is my Book Shop</h1>

        <ul>
            <table border="1">


            </table>

            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${myBookStore}">
                        <tr>
                            <td>${book.getId()}</td>
                            <td>${book.getName()}</td>
                            <td>${book.getPrice()}</td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </ul>


    </body>
</html>
