<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="data" value="USA,Tokyo,Japan"/>

        <c:set var="citiesArray" value="${fn:split(data, ',')}"/>

        <c:set var="citiesString" value="${fn:join(citiesArray, '$$')}"/>

        <ul>
            <c:forEach var="city" items="${citiesArray}">
                <li>${city}</li>
                </c:forEach>
        </ul>

        Result of joining: ${citiesString}
    </body>
</html>
