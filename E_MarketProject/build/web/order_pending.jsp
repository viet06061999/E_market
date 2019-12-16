<%@page import="model.User"%>
<%@page import="dao.UserDAOImpl"%>
<%@page import="model.Order"%>
<%@page import="dao.OrderDAOImpl"%>
<%@page import="dao.OrderDAOImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chờ xác nhận</title>
        <link rel="stylesheet" href="css/cart.css" />
        <link rel="stylesheet" href="css/menu.css" />
        <link rel="stylesheet" href="css/menu1.css" />
        <link rel="stylesheet" href="css/main.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />


        <style type="text/css">
            #main {
                width: 1060px;
                padding: 0;
                margin-left: auto;
                margin-right: auto;
            }

            #head {
                height: 200px;
                background-color: #F5F5F5;
                border: 1px solid #CDCDCD;
                margin-bottom: 5px;
                margin-top: 5px;
            }

            #head-link {
                height: 50px;
                line-height: 30px;
                border: 1px solid #CDCDCD;
                background-color: #F5F5F5;
                margin-bottom: 5px;
                clear: both;
            }

            #content {
                width: 1060px;
                min-height: 430px;
                border: 1px solid #CDCDCD;
                float: left;
                margin-bottom: 5px;
                clear: both;
            }

            #footer {
                height: 50px;
                clear: both;
                border: 1px solid #CDCDCD;
                background-color: #F8F8FF;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <%
            String username = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                    }
                }
            }
        %>
        <div id="main">
            <div id="head">
                <img src="images/banner.jpg" width="1057px" height="200px" />
            </div>
            <div id="head-link">
                <div id='menungang'>
                    <ul>
                        <li class='last'><a href="index.jsp"><span>Trang
                                    chủ</span></a></li>
                        <li class='last'><a href="product.jsp"><span>Sản phẩm</span></a></li>
                        <li class='last'><a href="cart.jsp"><span>Giỏ hàng</span></a></li>
                        <li class='last'><a href="search_page.jsp"><span>Tìm kiếm</span></a></li>
                         <li class='last'><a href="order_pending.jsp"><span>Đơn hàng</span></a> </li>
                        <li class='last' style="float: right;"><a href="login.jsp"><span>Đăng
                                    xuất</span></a></li>
                        <li class='last' style="float: right;"><a href="update_user.jsp?username=<%=username%>"><span><%= username%></span></a></li>			
                    </ul>
                </div>
            </div>
            <div id="content">
                <div id='menu'>
                    <ul>
                       
                         <li class='last'><a href="order_pending.jsp"><span>Chờ xác nhận</span></a> </li>
                   	<li class='last'><a href="order_delivery.jsp"><span>Đang giao hàng</span></a> </li>	
                    </ul>
                </div>
                 <%  String notice = null;
                    if (request.getAttribute("notice") != null) {
                        notice = (String) request.getAttribute("notice");
                    }
                %>
                <%if (notice != null) {%>
                <li style="color: red;font-size: 32px "><%=notice%></li>
                    <%}%>
                <div class="shopping-cart">

                    <div class="column-labels">
                        <label class="product-image">Hình ảnh</label> <label
                            class="product-details">Product</label> <label
                            class="product-price">Giá bán</label> <label
                            class="product-quantity">Số lượng</label><label
                            class="product-line-price">Tổng tiền</label>
                    </div>
                    <%
                            UserDAOImpl u=new UserDAOImpl();
                        User user = u.getUser(username);
                        int id = user.getUser_id();
                        OrderDAOImpl order = new OrderDAOImpl();
                        List<Order> list = order.getPending(id);

                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumIntegerDigits(0);

                    %>
                    <%                        for (Order o : list) {

                    %>
                    <div class="product">
                        <div class="product-image">
                            <img
                                src="sanpham/<%=o.getP()
                                        .getHinh_anh()%>">
                        </div>
                        <div class="product-details">
                            <div class="product-title">
                                <%=o.getP()
                                        .getTen_san_pham()%>
                            </div>
                            <p class="product-description"></p>
                        </div>
                        <div class="product-price"><%=nf.format(o.getP().getGia_ban())%>
                            VNĐ
                        </div>
                        <div class="product-quantity cart_quantity_button">

                            <%=o.getQuantity()%>

                        </div>
                        <div class="product-line-price" style="text-align: right"><%=nf.format(o.getP().getGia_ban()
                                * o.getQuantity())%>
                            VNĐ


                        </div>

                    </div>
                    <%
                        }

                    %>


                </div>

            </div>



            <div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
        </div>

    </body>
</html> 

