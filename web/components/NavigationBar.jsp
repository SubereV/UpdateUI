<%-- 
    Document   : header
    Created on : Jul 23, 2020, 11:07:47 AM
    Author     : kinvo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="header-area ">
        <div id="sticky-header" class="main-header-area">
            <div class="container-fluid">
                <div class="header_bottom_border">
                    <div class="row align-items-center">
                        <div class="col-xl-2 col-lg-2">
                            <div class="logo">

                                <a href="">
                                    <h2><img src="img/favicon.jpg" alt="">Fancy</h2>
                                </a>

                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">

                                        <li><a href="home">Trang chủ</a></li>
                                            <c:forEach items="${parentList}" var="parent">
                                            <li><a class="" href="Category?cate=${parent.categoryId}">${parent.getName()}${dao.findChildrenCategories(parent).size() > 0 ? "<i class=\"ti-angle-down\"></i>":""}</a>
                                                <ul class="submenu">
                                                    <c:forEach items="${dao.findChildrenCategories(parent)}" var="child">
                                                        <li><a href="Category?cate=${child.categoryId}">${child.getName()}</a></li>
                                                        </c:forEach>
                                                </ul>  
                                            </li>
                                        </c:forEach>
                                        <li><a href="contact">Liên hệ</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-4 d-none d-lg-block">
                            <div class="social_wrap d-flex align-items-center justify-content-end">
                                <!--                                        <div class="number">
                                                                            <p> <i class="fa fa-phone"></i> 10(256)-928 256</p>
                                                                        </div>-->
                                <div class="main-menu">
                                    <c:choose>
                                        <c:when test="${session.user eq null}">
                                            <div class="">
                                                <a data-toggle="modal" data-target="#modalLoginForm" href="#">
                                                    <i class="fa fa-sign-in"> Login </i>
                                                </a>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <ul>
                                                <li class="main-menu d-none d-lg-block">
                                                    <i class="fa fa-user-circle-o fa-2x" data-toggle="dropdown"></i>
                                                    <ul class="submenu">
                                                        <li>${session.user.name}</li> 
                                                        <li><a href="createPost">Create Post</a></li>
                                                        <li><a href="profile?id=${session.user.userId}">Profile</a></li>
                                                            <c:if test="${session.user.permission == '1'}">
                                                            <li><a href="admin">Admin</a></li>
                                                            </c:if>
                                                        <li><a href="logout">Log Out</a></li>
                                                    </ul> 
                                                </li>
                                            </ul
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</header>