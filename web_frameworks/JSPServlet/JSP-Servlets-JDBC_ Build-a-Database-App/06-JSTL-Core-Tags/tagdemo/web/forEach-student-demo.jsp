<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="models.Student" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            List<Student> studentList = new ArrayList<>();

            studentList.add(new Student("Hoang", "Luu", true));
            studentList.add(new Student("Minh", "Nhu", true));
            studentList.add(new Student("Ke", "Bi An", false));

            pageContext.setAttribute("myStudentList", studentList);
        %>
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gold Customer</th>
            </tr>
            <c:forEach var="student" items="${myStudentList}">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.goldCustomer}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
