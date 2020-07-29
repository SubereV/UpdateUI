<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <script type="text/javascript" src="//cdn.ckeditor.com/4.4.0/full/ckeditor.js"></script>
        <!-- <link rel="stylesheet" href="css/responsive.css"> -->
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
                            <h3>Create New Post</h3>
                            <p>Share your experience to help other had a better travel</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/ bradcam_area  -->

        <!-- ================ contact section start ================= -->
        <section class="contact-section">
            <div class="container">
                <div class="row">
                    <form action="editPost" id="frm-fr">
                        <div class="form-group" hidden>
                            <input name="Id" type="text" class="form-control" id="Id" />
                        </div>
                        <div class="form-group">
                            <label for="Name" class="required">Tiêu đề:</label>
                            <input name="title" type="text" class="form-control" id="title" value="${post.title}" />
                        </div><br>
                        <div class="form-group">
                            <label for="Name" class="required">Background:</label>
                            <input name="backGround" type="text" class="form-control" id="title" />
                        </div><br>
                        <div class="form-group">
                            <label class="required">Vị trí:</label>
                            <div id="locationField">
                                <input id="autocomplete"
                                       name="location"
                                       placeholder="Enter your address"
                                       onFocus="geolocate()"
                                       type="text"
                                       value="${post.location}"/>
                            </div>
                            <br>
                            <div class="form-group">
                                <label class="required">Chuyên mục:</label><br>
                                <select name = "cate">
                                    <c:forEach items="${parentList}" var="parent">
                                        <option value ="${parent.getCategoryId()}"><p style="color:red;">${parent.getName()}</p></option>
                                        <c:if test="${dao.findChildrenCategories(parent) ne null}">
                                            <c:forEach items="${dao.findChildrenCategories(parent)}" var="child">
                                                <option value="${child.getCategoryId()}">${child.getName()}</option>
                                            </c:forEach>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                            <br><br>
                            <div class="form-group">
                                <label class="required">Nội dung</label><br>
                                <textarea id="editor1" class="form-control tinymce" rows="10" cols="80" name="content">
                                    ${post.content}
                                </textarea>
                            </div>
                            <script>
                                CKEDITOR.replace('editor1');
                            </script>
                            <div class="form-group pull-right action">
                                <a class="btn btn-default mr-3" onclick="goBack()">Cancel</a>
                                <button type="submit" class="btn btn-default mr-3">Post</button>
                            </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- ================ contact section end ================= -->

        <!-- footer start -->
        <jsp:include page="components/footer.jsp" />
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

        <script src="js/main.js"></script>
        <script>
                                    function goBack() {
                                        window.history.back();
                                    }

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

                                    /**
                                     * Copyright (c) 2003-2020, CKSource - Frederico Knabben. All rights reserved.
                                     * For licensing, see LICENSE.md or https://ckeditor.com/legal/ckeditor-oss-license
                                     */

                                    /* exported initSample */

                                    if (CKEDITOR.env.ie && CKEDITOR.env.version < 9)
                                        CKEDITOR.tools.enableHtml5Elements(document);

// The trick to keep the editor in the sample quite small
// unless user specified own height.
                                    CKEDITOR.config.entities_latin = false;
                                    CKEDITOR.config.height = 350;
                                    CKEDITOR.config.width = 'auto';

                                    var initSample = (function () {
                                        var wysiwygareaAvailable = isWysiwygareaAvailable(),
                                                isBBCodeBuiltIn = !!CKEDITOR.plugins.get('bbcode');

                                        return function () {
                                            var editorElement = CKEDITOR.document.getById('editor');

                                            // :(((
                                            if (isBBCodeBuiltIn) {
                                                editorElement.setHtml(
                                                        'Hello world!\n\n' +
                                                        'I\'m an instance of [url=https://ckeditor.com]CKEditor[/url].'
                                                        );
                                            }

                                            // Depending on the wysiwygarea plugin availability initialize classic or inline editor.
                                            if (wysiwygareaAvailable) {
                                                CKEDITOR.replace('editor');
                                            } else {
                                                editorElement.setAttribute('contenteditable', 'true');
                                                CKEDITOR.inline('editor');

                                                // TODO we can consider displaying some info box that
                                                // without wysiwygarea the classic editor may not work.
                                            }
                                        };

                                        function isWysiwygareaAvailable() {
                                            // If in development mode, then the wysiwygarea must be available.
                                            // Split REV into two strings so builder does not replace it :D.
                                            if (CKEDITOR.revision == ('%RE' + 'V%')) {
                                                return true;
                                            }

                                            return !!CKEDITOR.plugins.get('wysiwygarea');
                                        }
                                    })();


        </script>
    </body>

</html>