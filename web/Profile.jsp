<%-- 
    Document   : Profile
    Created on : Jun 19, 2020, 7:55:25 PM
    Author     : ADMIN
--%>

<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Level"%>
<%@page import="Entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Cutive+Mono&family=Poppins:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">    
        <!-- <link rel="stylesheet" href="style.css">  -->

        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <link href="css/ProfileCSS.css" rel="stylesheet" type="text/css"/>
        <style>
            a.Back{
                color: #fff;
                text-decoration: none;
            }
        </style>

        <title>Profile Card</title>
    </head>
    <body>
        <div class="modal">

            <div class="close"></div>
        </div>

        <div class="container">
            <div class="card">
                <div class="header">
                    <div class="hamburger-menu">
                        <a onclick="goBack()" class="Back">Back</a>
                    </div>
                    <a href="" class="mail">
                        <i class="far fa-envelope"></i>
                    </a>
                    <div class="main">
                        <div class="image"> <img src="image/nmhieu.jpg"width="102" height="102">
                            <div class="hover">
                                <i class="fas fa-camera fa-2x"></i>
                            </div>
                        </div>
                        <h3 class="name"></h3>
                        <h3 class="sub-name">${blogger.name}</h3>
                    </div>
                </div>

                <div class="content">
                    <div class="left">
                        <div class="about-container">
                            <h3 class="title">About</h3>
                            <p class="text">${blogger.description}"</p>
                        </div>
                        <div class="icons-container">
                            <!--    <a href="#" class="icon"> -->
                            <a href="https://www.facebook.com/profile.php?id=100045452231544" class="icon">
                                <i class="fab fa-facebook"></i>
                            </a>
                            <a href="https://www.instagram.com/nmhieu2902/?hl=vi" class="icon">
                                <i class="fab fa-instagram"></i>
                            </a>
                            <a href="#" class="icon">
                                <i class="fab fa-google-plus-g"></i>
                            </a>
                            <a href="#" class="icon">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </div>
                        <div class="buttons-wrap">
                            <div class="follow-wrap">
                                <a href="wall?id=${blogger.userId}" class="follow">View Wall</a>
                                <c:if test="${blogger.userId==id}">
                                    <a href="edit?id=${id}" class="follow">Edit</a>
                                </c:if>
                            </div>
                            <!--                            <div class="share-wrap">
                                                            <a href="#" class="share">Share</a>
                                                        </div>-->
                        </div>

                    </div>

                    <div class="right">
                        <div>
                            <h3 class="number">91</h3>
                            <h3 class="number-title">Posts</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function goBack() {
                window.history.back();
            }
        </script>
        <script src="app.js"></script>
    </body>
</html>