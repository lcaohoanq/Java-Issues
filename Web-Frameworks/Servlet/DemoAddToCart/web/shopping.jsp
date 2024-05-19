<%@page import="sample.product.ProductCartDTO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CART</title>
    </head>
    <body>
        <%
            String searchCart = request.getParameter("searchCart");
            if (searchCart == null) {
                searchCart = "";
            }
        %>
        <h1>Welcome to product Store</h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <form action="MainController" method="POST">
            Search<input type="text" name="searchCart" value="<%= searchCart%>"/>
            <input type="submit" name="action" value="SearchCart"/>
            <input type="submit" name="action" value="View"/>
        </form>
        <%
            List<ProductCartDTO> productList = (List<ProductCartDTO>) request.getAttribute("Product_List");
            if (productList != null && !productList.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th> 
                    <th>Product name</th> 
                    <th>Price</th>
                    <th>size</th> 
                    <th>Description</th>
                    <th>quantity</th>
                    <th>Add to cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProductCartDTO product : productList) {
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++ %></td>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getSize() %></td>
                    <td><%= product.getDescription() %></td>
                    
                    <td><select name="cmbQuantity">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="50">50</option>
                        </select></td>
                    <td>
                        <input type="hidden" name="id" value="<%= product.getId() %>">
                        <input type="hidden" name="name" value="<%= product.getName() %>">
                        <input type="hidden" name="price" value="<%= product.getPrice() %>">
                        <input type="hidden" name="description" value="<%= product.getDescription() %>">
                        <input type="hidden" name="size" value="<%= product.getSize() %>">
                        <input type="hidden" name="quantity" value="<%= product.getQuantity() %>">
                        <input type="hidden" name="searchCart" value="<%= searchCart %>">
                        
                        <input type="submit" name="action" value="Add">
                    </td>
                    
                </tr>
            </form>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            }
        %>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <%= message %>
    </body>
</html>
