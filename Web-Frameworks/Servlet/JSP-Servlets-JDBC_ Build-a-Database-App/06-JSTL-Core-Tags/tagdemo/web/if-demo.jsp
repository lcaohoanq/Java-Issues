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

            List<Student> studentList = new ArrayList<Student>();

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
                    <!--<td>-->
                        <%--<c:if test="${student.goldCustomer}">--%>
                            <!--Special Price-->
                        <%--</c:if>--%>
                        <%--<c:if test="${ not student.goldCustomer}">--%>
                            <!-----> 
                        <%--</c:if>--%>
                    <!--</td>-->

                    <td>
                        <c:choose>
                            <c:when test="${student.goldCustomer}">
                                Special Price
                            </c:when>
                            <c:otherwise>
                                Normal Price
                            </c:otherwise>
                        </c:choose>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </body>
</html>
