<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] cities = {"Thanh Hoa", "Da Nang", "Ho Chi Minh"};
            pageContext.setAttribute("myCities", cities);
        %>
        
        <c:forEach var="citiesList" items="${myCities}">
            <ul>
                <li>${citiesList}</li> <br>
            </ul>
        </c:forEach>
        
    </body>
</html>
