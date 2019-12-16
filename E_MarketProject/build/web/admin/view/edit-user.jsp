<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<c:url value="/view/admin/static" var="url"></c:url>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Edit User</title>
            <!-- BOOTSTRAP STYLES-->
            <link href="admin/static/css/bootstrap.css" rel="stylesheet" />
            <!-- FONTAWESOME STYLES-->
            <link href="admin/static/css/font-awesome.css" rel="stylesheet" />
            <!-- CUSTOM STYLES-->
            <link href="admin/static/css/custom.css" rel="stylesheet" />
            <!-- GOOGLE FONTS-->
            <link href='http://fonts.googleapis.com/css?family=Open+Sans'
                  rel='stylesheet' type='text/css' />
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
                                <h2>Edit User</h2>
                                <h5>You can edit info user in here</h5>
                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">Info you can change</div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <h3>User:${user.getUsername()}</h3>
                                            
                                                                                   
                                            <form role="form" action="UserEditServlet" method="post" >
                                                <input name="id" value="${user.getUser_id()}" type="text" hidden="">
                                              
                                                <div class="form-group">
                                                    <label>Password</label> <input class="form-control"
                                                                                   value="${user.getPassword()}" type="password" name="password" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Email:</label> <input class="form-control"
                                                                                 value="${user.getEmail()}" name="email" />
                                                </div>
                                                  <div class="form-group">
                                                    <label>Address:</label> <input class="form-control"
                                                                                     value="${user.getDiachi()}" name="diachi" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Phone number:</label> <input class="form-control"
                                                                                     value="${user.getSdt()}" name="sdt" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Role</label>
                                                    <div class="checkbox">
                                                        <label> <input type="radio" value="1" name="role" />Admin
                                                        </label> <br> <label> <input type="radio" value="2"
                                                                                     name="role" checked="checked"/>Client
                                                        </label>
                                                    </div>

                                                </div>
                                                <button type="submit" class="btn btn-default">Edit</button>
                                                <button type="reset" class="btn btn-primary">Reset</button>
                                            </form>



                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Form Elements -->
                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <div class="row">
                        <div class="col-md-12"></div>
                    </div>
                    <!-- /. ROW  -->
                </div>
                <!-- /. PAGE INNER  -->
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="${url}/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="${url}/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="${url}/js/jquery.metisMenu.js"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="${url}/js/custom.js"></script>

    </body>
</html>