<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<c:url value="/admin/static" var="url"></c:url>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Order Management</title>
            <!-- BOOTSTRAP STYLES-->
            <link href="${url}/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="${url}/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->

        <!-- CUSTOM STYLES-->
        <link href="${url}/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans'
              rel='stylesheet' type='text/css' />
        <!-- TABLE STYLES-->
        <link href="${url}/js/dataTables/dataTables.bootstrap.css"
              rel="stylesheet" />
    </head>
    <body>
        <div id="wrapper">

            <jsp:include page="/admin/view/nav-bar.jsp"></jsp:include>

                <!-- /. NAV TOP  -->
            <jsp:include page="/admin/view/slide-bar.jsp"></jsp:include>
                <!-- /. NAV SIDE  -->
                <div id="page-wrapper">
                    <div id="page-inner">
                        <div class="row">
                            <div class="col-md-12">
                                <h2>Order Management</h2>


                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />

                        <div class="row">
                            <div class="col-md-12">
                                <!-- Advanced Tables -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">Advanced Tables</div>
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover"
                                                   id="dataTables-example">
                                                <thead>
                                                    <tr>
                                                        <th>index</th>
                                                        <th>ID</th>
                                                        <th>Username</th>
                                                        <th>Buyer</th>
                                                        <th>Email</th>
                                                        <th>Date</th>
                                                        <th>Product</th>
                                                        <th>Quantity</th>
                                                        <th>Price</th>
                                                        <th>Sum</th>
                                                        <th>Status</th>
                                                        <th>Action</th>


                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    </a>
                                                <c:set var="index" value="${0}" />
                                                <c:forEach items="${list}" var="list">
                                                    <tr class="odd gradeX">
                                                        <c:set var="index" value="${index + 1}" />
                                                        <td>${index }</td>
                                                        <td>${list.order_id}</td>
                                                        <td>${list.u.username}</td>
                                                        <td>${list.fullname}</td>
                                                        <td>${list.email }</td>
                                                        <td>${list.create_time }</td>
                                                        <td>${list.p.ten_san_pham}</td>
                                                        <td>${list.quantity}</td>
                                                        <td>${list.p.gia_ban} vnd</td>
                                                        <td> ${ list.quantity * list.p.gia_ban} vnd</td>
                                                         <td>${list.tinh_trang}</td>


                                                        <td> <form action="OrderConfirmServlet" method="post">
                                                                    <input type="hidden" value="${list.order_id}" name="order_id"/>
                                                                    <input type="hidden" value="${list.p.ma_san_pham}" name="p_id"/>
                                                                    <input type="submit" value="Confirm">
                                                                </form> 
                                                                <form action="OrderDeleteServlet" method="post">
                                                                    <input type="hidden" value="${list.order_id}" name="order_id"/>
                                                                    <input type="hidden" value="${list.p.ma_san_pham}" name="p_id"/>
                                                                    <input type="submit" value="Delete">
                                                                </form>
                                                                      
                                                        
                                                        </td>

                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                            <!--End Advanced Tables -->
                        </div>
                    </div>

                </div>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
        <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="${url}/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="${url}/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="${url}/js/jquery.metisMenu.js"></script>
        <!-- DATA TABLE SCRIPTS -->
        <script src="${url}/js/dataTables/jquery.dataTables.js"></script>
        <script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
        </script>
        <!-- CUSTOM SCRIPTS -->
        <script src="${url}/js/custom.js"></script>

    </body>
</html>