<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Step 1: Create new HTML Form -->

        <form action="todolist-demo.jsp">
            <label for="data">Add new item: </label>
            <input type="text" id="data" name="input-data">
            <button> Submit </button>
        </form>

        <br>

        <!-- Step 2: Add new item to "To do" List-->
        <%

            List<String> items = (List<String>) session.getAttribute("myToDoList");

            if (items == null) {
                items = new ArrayList<String>();
                session.setAttribute("myToDoList", items);
            }

            String data = request.getParameter("input-data");

            boolean isItemNotEmpty = data != null && data.trim().length() > 0;
            boolean isItemNotDuplicate = data != null && !items.contains(data.trim());

            if (isItemNotEmpty && isItemNotDuplicate) {
                items.add(data.trim());
            }

        %>   

        <!-- Step 3: Display all "To do" item from Session -->

        <hr>

        <h1>To do list today:</h1>

        <ol>
            <%                for (String item : items) {
                    out.println("<li>" + item + "</li>");
                }
            %>
        </ol>



    </body>
</html>
