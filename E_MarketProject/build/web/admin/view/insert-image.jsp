<%-- 
    Document   : insert-image
    Created on : Dec 9, 2019, 10:57:21 AM
    Author     : lovelan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<c:url value="/admin/static" var="url"></c:url>
    <!DOCTYPE html>
    <html>
        <head>
            <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Edit Product</title>
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
                                <h2>Add Your Product's image</h2>
                                <h5>Add product you can sell</h5>
                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">Add Product</div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                

                                                <form role="form" action="InsertImageServlet" method="post"
                                                      enctype="multipart/form-data">
                                                <input name="id" value="${id}" hidden="">
                                                <div class="form-group">
                                                    <label>image</label> <input type="file" name="image" value="${product.getHinh_anh()}" />
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
        <script type="text/javascript" language="javascript">
            CKEDITOR.replace('editer', {width: '700px', height: '300px'});
        </script>
    </body>
</html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
