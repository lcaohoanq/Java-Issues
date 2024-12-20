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
        
        <% 
            String str = "Hello World!";
        %>
        
        <c:set var="data" value="<%= str %>"/>

        Length of the string <b>${data}</b> : ${fn:length(data)} <br>
        
        Upper case version of the string <b>${data}</b> : ${fn:toUpperCase(data)} <br>
        
        Does the string <b>${data}</b> start with <b>Hello</b>?  : ${fn:startsWith(data, "Hello")} <br>
        
    </body>
</html>
