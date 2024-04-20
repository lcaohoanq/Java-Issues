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