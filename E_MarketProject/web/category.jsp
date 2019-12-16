<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/menu.css" />
        <link rel="stylesheet" href="css/product.css" />

    </head>
    <body>

        <div id="main">
            <jsp:include page="header.jsp"></jsp:include>
            <div id="content">
                <div id="left"><jsp:include page="sidebar.jsp"></jsp:include></div>
                    <div id="right">
                    <%
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumFractionDigits(0);
                    %>
                    <div id="site-wrapper" style="float: left">
                        <ul class="products homepage">
                          
                         <c:forEach var="p" items="${listProduct}">
                            <li class="preorder"><span class="tagimg "></span> <a
                                    href="detail.jsp?ma_san_pham=${p.getMa_san_pham()}"> <img
                                        src="sanpham/${p.getHinh_anh()}" width=" 250px" height="250px" />
                                    <h3>${p.getTen_san_pham()}</h3>
                                    <h4>
                                        Giá:
                                        ${nf.format(p.getGia_ban())}
                                        VNĐ
                                    </h4> <span class="textkm">Khuyến mãi trị giá đến <strong>500.000₫</strong>
                                    </span>
                                    <p class="info">
                                        <span>Hãng sx: ${p.getHang_san_xuat()}</span> <span>Giá:
                                            ${nf.format(p.getGia_ban())} VNĐ</span> <span>Thông tin: ${p.getThong_tin()}
                                    </p>
                                </a></li>
                                </c:forEach>
                             
                        </ul>
                    </div>
                </div>
            </div>
            <div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
        </div>

    </body>
</html>