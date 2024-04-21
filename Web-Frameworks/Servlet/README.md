# Web Server
- Web Server là máy chủ cài đăt chương trình phục vụ các ứng dụng web
- Web Server có nhiệm vụ nhận **request** (yêu cầu) từ client, xử lý và trả về **response** (phản hồi) cho client thông qua giao thức HTTP (hoặc các giao thức khác)
> HTTP Request: Yêu cầu từ client
> 
> HTTP Response: Phản hồi từ server

# HTTP là gì?
- HTTP (HyperText Transfer Protocol) là giao thức truyền tải siêu văn bản

# HTTP Headers 
## Request Headers:
- Chứa những thông tin kèm theo khi client gửi request lên server
- Sample data:
  - Host: địa chỉ trang web mà client muốn gửi request
  - Accept-Encoding: định dạng dữ liệu mà client muốn nhận từ server
  - User-Agent: thông tin về hệ điều hành và trình duyệt của client
  - Cookie: thông tin về phiên làm việc của client
  - Accept-Language: ngôn ngữ mà client muốn nhận từ server
## Response Headers:
- Chứa những thông tin kèm theo khi server trả về response cho client
- Sample data:
  - Content-Type: định dạng dữ liệu mà server trả về cho client
  - Content-Length: kích thước dữ liệu mà server trả về cho client
  - Set-Cookie: thông tin về phiên làm việc của client
  - Expires: thời gian mà dữ liệu trả về từ server sẽ hết hạn

# Java Servlet
- Servlet là một bộ thư viện của Java dùng để tạo các ứng dụng web (website/web application)
- Mặc định root ('/') là một trang Hello World!

- Default index.jsp

![img.png](img.png)

- Serve `hello.jsp` file

![img_1.png](img_1.png)
# Servlet LifeCycle
### Có 5 bước:
  1. Load Servlet: Servlet Container tải Servlet vào bộ nhớ
  2. Create Servlet: Servlet Container tạo một instance của Servlet
  3. Call `init()` method: Servlet Container gọi phương thức init() của Servlet
  4. Call `service`()` method: Servlet Container gọi phương thức service() của Servlet
  5. Call `destroy()` method: Servlet Container gọi phương thức destroy() của Servlet

- doGet(), doPost(), doPut(), doDelete()... là các phương thức của service() method được gọi đi gọi lại nhiều lần

# JSP
- JSP (Java Server Pages) là một công nghệ cho phép viết mã Java và HTML trong cùng một file
- Default index.jsp

![img.png](img.png)

- Serve `hello.jsp` file

![img_1.png](img_1.png)

# GET - POST 