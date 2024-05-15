# MVC (Model-View-Controller)

![img.png](img.png)

# Servlet can call JSP using a request dispatcher
```java
request.getRequestDispatcher("/login.jsp").forward(request, response);
```

# Sending data from Servlet to JSP

- Using request.setAttribute("name", "value")
- You can as long as many attribute as you want, but it need to have unique name 

![img_1.png](img_1.png)

![img_2.png](img_2.png)

## Perform demo MVC

/demo

![img_3.png](img_3.png)

- included the jstl tag core

![img_4.png](img_4.png)

- Result

![img_5.png](img_5.png)

## A little advanced

![img_6.png](img_6.png)
![img_7.png](img_7.png)

- /book

![img_8.png](img_8.png)
![img_9.png](img_9.png)
![img_10.png](img_10.png)

- Now we need to convert this object data to a table format