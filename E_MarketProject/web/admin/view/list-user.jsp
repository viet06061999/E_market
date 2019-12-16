<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<c:url value="/view/admin/static" var="url"></c:url>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>List User</title>
            <!-- BOOTSTRAP STYLES-->
            <link href="admin/static/css/bootstrap.css" rel="stylesheet" />
            <!-- FONTAWESOME STYLES-->
            <link href="admin/static/css/font-awesome.css" rel="stylesheet" />
            <!-- MORRIS CHART STYLES-->

            <!-- CUSTOM STYLES-->
            <link href="admin/static/css/custom.css" rel="stylesheet" />
            <!-- GOOGLE FONTS-->
            <link href='http://fonts.googleapis.com/css?family=Open+Sans'
                  rel='stylesheet' type='text/css' />
            <!-- TABLE STYLES-->
            <link href="admin/static/js/dataTables/dataTables.bootstrap.css"
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
                                <h2>List User</h2>
                                <h5>You can edit , add, delete User</h5>

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
                                                        <th>ID</th>
                                                       
                                                        <th>Email</th>
                                                        <th>User Name</th>
                                                        <th>Address</th>
                                                        <th>Password</th>
                                                        <th>Status</th>
                                                        <th> Role </th>
                                                        <th>Action</th>


                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${userList }" var="list">
                                                    <tr class="odd gradeX">
                                                        <td>${list.getUser_id()}</td>
                                                        <td>${list.getEmail()}</td>
                                                        <td>${list.getUsername()}</td>
                                                        <td>${list.getDiachi()}</td>
                                                        <td>${list.getPassword()}</td>
                                                        <td class="center">Active</td>

                                                        <td class="center"><c:choose>
                                                                <c:when test="${list.getRole()==1}">
                                                                    Admin
                                                                </c:when>
                                                                <c:otherwise>Client</c:otherwise>
                                                            </c:choose></td>

                                                        <td><a
                                                                href="<c:url value='UserEditServlet?id=${list.getUser_id()}'/>"
                                                                class="center">Edit</a> | <a
                                                                href="<c:url value='UserDeleteServlet?id=${list.getUser_id()}'/>"
                                                                class="center">Delete</a></td>

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