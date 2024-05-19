<%-- 
    Document   : viewCart
    Created on : Oct 15, 2022, 4:36:03 PM
    Author     : hd
--%>

<%@page import="sample.product.ProductCartDTO"%>
<%@page import="sample.product.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <h1>Product inside the cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Change</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (ProductCartDTO p : cart.getCart().values()) {
                        total += p.getPrice() * p.getQuantity();
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td> 
                        <input type="text" name="id" value="<%= p.getId()%>" readonly=""/>
                    </td>
                    <td><%= p.getName()%></td>
                    <td>
                        <input type="number" min="1" name="quantity" value="<%= p.getQuantity()%>" required=""/>
                    </td>
                    <td><%= p.getPrice()%>$</td>
                    <td><%= p.getPrice() * p.getQuantity()%>$</td>
                    <td>
                        <input type="submit" name="action" value="Change"/>
                    </td>
                    
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                </tr>
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <h1>Total:<%= total%> $  </h1>      
    <%
        }
    %>
    </br>
    <a href="shopping.jsp">Add more</a>
</body>
</html>
