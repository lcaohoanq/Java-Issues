# What is a JSP file?

- AN HTM page with some Java code embedded in it
- Include dynamic content from a Java code

# Where is the JSP processed?
- JSP is processed on the server
- The server generates an HTML page and sends it to the client

# Where to place JSP file?
- The JSP file goes in your WebContent folder
- Must have the `.jsp` extension 

![img_1.png](img_1.png)

# Hello world
![img_2.png](img_2.png)!
![img.png](img.png)

# JSP Expression
## 1. JSP expression:
  - `<%= some Java expression %>`

![img_3.png](img_3.png)
![img_4.png](img_4.png)

### Example:

![img_5.png](img_5.png)
![img_6.png](img_6.png)

## 2. JSP Scriptlet:
  - `<% some Java code: 1 to many lines %>`
  - Insert 1 to many line of Java code
  - To include content in the HTML page use `out.print()`
> Best practice
- Minimize the amount of scriptlet code in a JSP
- Avoid dumping a lot of Java code in a JSP
- Refactor this into separate class... make use of MVC
### Example:

![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)

## 3. JSP Declaration:
  - `<%! variable or method declaration %>`
  - Declare a method or variable
  - Call it in the same JSP page
### Example:

![img_10.png](img_10.png)
![img_11.png](img_11.png)
![img_12.png](img_12.png)

# Call a Java class From JSP
- Comma to separate the many import you need
![img_13.png](img_13.png)

# JSP Built-in Server Object

![img_14.png](img_14.png)get

# JSP including files

![img_15.png](img_15.png)