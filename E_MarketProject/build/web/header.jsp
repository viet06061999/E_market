<%-- 
    Document   : header
    Created on : Nov 24, 2019, 3:13:01 PM
    Author     : lovelan
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="head">
            <img src="images/banner.jpg" width="1057px" height="220px" />
        </div>

        <%
            String username = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    }
                }
            }

            if (username != null) {
        %>
        <div id="head-link">
            <div id='menungang'>
                <ul>
                    <li class='last'><a href="index.jsp"><span>Trang
                                chủ</span></a></li>
                    <li class='last'><a href="product.jsp"><span>Sản phẩm</span></a></li>
                    <li class='last'><a href="cart.jsp"><span>Giỏ hàng</span></a></li>
                    <li class='last'><a href="search_page.jsp"><span>Tìm kiếm</span></a></li>
                     <li class='last'><a href="order_pending.jsp"><span>Đơn hàng</span></a> </li>
                    
                    <li class='last' style="float: right;"><a href="LogoutServlet"><span>Đăng
                                xuất</span></a></li>
                    <li class='last' style="float: right;"><a href="update_user.jsp?username=<%=username%>"><span><%=username%></span></a></li>
                </ul>
            </div>
        </div>
        <%
        } else {
        %>
        <div id="head-link">
            <div id='menungang'>
                <ul>
                    <li class='last'><a href="index.jsp"><span>Trang
                                chủ</span></a></li>
                    <li class='last'><a href="product.jsp"><span>Sản phẩm</span></a></li>
                    <li class='last'><a href="search_page.jsp"><span>Tìm kiếm</span></a></li>
                    <li class='last' style="float: right;"><a href="register.jsp"><span>Đăng
                                ký</span></a></li>
                    <li class='last' style="float: right;"><a href="login.jsp"><span>Đăng
                                nhập</span></a></li>
                </ul>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
