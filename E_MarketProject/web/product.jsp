<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/taglib139.tld" prefix="pg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sản phẩm</title>
        <link rel="stylesheet" href="css/product.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/menu.css" />

    </head>
    <body>
        <pg:paging pageSize="4">
            <div id="main">
                <jsp:include page="header.jsp"></jsp:include>

                    <div id="content_center" >

                    <%
                        ProductDAOImpl productDAO = new ProductDAOImpl();

                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumFractionDigits(0);
                    %>

                    <div id="site-wrapper-p" style="float: left; margin-left: 120px">
                        <ul class="products homepage">

                            <%	for (Product p : productDAO.getList()) {
                            %>
                            <pg:item>
                                <li class="preorder"><span class="tagimg "></span> <a
                                        href="detail.jsp?ma_san_pham=<%=p.getMa_san_pham()%>"> <img
                                            src="sanpham/<%=p.getHinh_anh()%>" width=" 250px"
                                            height="250px" />
                                        <h3><%=p.getTen_san_pham()%></h3>
                                        <h4>
                                            Giá:
                                            <%=nf.format(p.getGia_ban())%>
                                            VNĐ
                                        </h4> <span class="textkm">Khuyến mãi trị giá đến <strong>500.000₫</strong>
                                        </span>
                                        <p class="info">
                                            <span>Hãng sx: <%=p.getHang_san_xuat()%></span> <span>Giá:
                                                <%=nf.format(p.getGia_ban())%> VNĐ</span> <span>Thông tin: <%=p.getThong_tin()%>
                                        </p>
                                    </a></li>
                                </pg:item>
                                <%
                                    }

                                %>
                        </ul>
                    </div>

                    <div id="footer" align= "center">
                        <pg:index>
                            <pg:page><%=thisPage%></pg:page>
                        </pg:index>
                    </div>
                </div>
            </pg:paging>

    </body>
</html>