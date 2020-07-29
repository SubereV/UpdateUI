<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>interior</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- <link rel="manifest" href="site.webmanifest"> -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <!-- Place favicon.ico in the root directory -->

        <!-- CSS here -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/gijgo.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/slicknav.css">
        <link rel="stylesheet" href="css/style.css">

        <link rel="stylesheet" href="css/table.css">
        <!-- <link rel="stylesheet" href="css/responsive.css"> -->
        <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
    </head>

    <body>
        <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

        <!-- header-start -->
        <jsp:include page="components/NavigationBar.jsp" />
        <!-- header-end -->

        <!-- bradcam_area  -->
        <div class="bradcam_area bradcam_bg_4">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="bradcam_text text-center">
                            <h3 style="color: whitesmoke">Admin Page</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/ bradcam_area  -->

        <!-- ================ contact section start ================= -->

         <p id="display"></p>
        <br><br><br>
        <div class="row">

            <div class="col-md-12">


                <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%" style="table-layout:fixed">
                    <thead>
                        <tr>
                            <th>UserID</th>
                            <th>Name</th>
                            <th>Permission</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Description</th>
                            <th>Date Modify</th>
                            <th>Avatar</th>
                            <th>Link Facebook</th>
                            <th>Address</th>
                            <th>Major</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>

                    <tfoot>
                        <tr>
                            <th>UserID</th>
                            <th>Name</th>
                            <th>Permission</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Description</th>
                            <th>Date Modify</th>
                            <th style="width:10px">Avatar</th>
                            <th>Link Facebook</th>
                            <th>Address</th>
                            <th>Major</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </tfoot>

                    <tbody>
                        <c:forEach items="${userList}" var="u">
                            <tr>
                                <td>${u.userId}</td>
                                <td>${u.name}</td>
                                <td>${u.permission}</td>
                                <td>${u.email}</td>
                                <td>${u.password}</td>
                                <td>${u.description}</td>
                                <td>${u.dateModify}</td>
                                <td style="width:10px">${u.avatar}</td>
                                <td>${u.fbLink}</td>
                                <td>${u.adress}</td>
                                <td>${u.major}</td>
                                <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button onclick='edit(${u})' class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></button></p></td>
                                <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button onclick='deleteU(${u.userId})' class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>




        <!-- ================ contact section end ================= -->

        <!-- footer start -->
        <jsp:include page="components/footer.jsp"/>
        <!--/ footer end  -->

        <!-- Modal -->
        <jsp:include page="components/modal.jsp"/>

        <!-- JS here -->
        <script src="js/vendor/modernizr-3.5.0.min.js"></script>
        <script src="js/vendor/jquery-1.12.4.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/ajax-form.js"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>
        <script src="js/imagesloaded.pkgd.min.js"></script>
        <script src="js/scrollIt.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/nice-select.min.js"></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/gijgo.min.js"></script>

        <!--contact js-->
        <script src="js/contact.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.form.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/table.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.parallax.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>
        <script src="js/modernizr.custom.js"></script>
        <script src="js/smoothscroll.js"></script>
        <script src="js/custom.js"></script>
        <!--            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>-->
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
        <script src="js/main.js"></script>
        <script>
                                    $('#datepicker').datepicker({
                                        iconsLibrary: 'fontawesome',
                                        icons: {
                                            rightIcon: '<span class="fa fa-caret-down"></span>'
                                        }
                                    });
                                    $('#datepicker2').datepicker({
                                        iconsLibrary: 'fontawesome',
                                        icons: {
                                            rightIcon: '<span class="fa fa-caret-down"></span>'
                                        }

                                    });
        </script>
    </body>

</html>