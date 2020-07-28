<%-- 
    Document   : notFound
    Created on : Jul 14, 2020, 9:14:05 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>404 error</title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:500" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Titillium+Web:700,900" rel="stylesheet">
        <link href="css/NotFoundCSS.css" rel="stylesheet" type="text/css"/>
        
        <style>
            .notfound .notfound-404 h1 {
                font-family: 'Titillium Web', sans-serif;
                font-size: 186px;
                font-weight: 900;
                margin: 0px;
                text-transform: uppercase;
                background: url("image/fancy.jpg");
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                background-size: cover;
                background-position: center;
            }
        </style>
    </head>
    <body>
        <div id="notfound">
            <div class="notfound">
                <div class="notfound-404">
                    <h1>404</h1>
                </div>
                <h2>Oops! This Page Could Not Be Found</h2>
                <p>There could be some thing wrong, come back later!</p>
                
                <a href="home">Back To Home</a>
            </div>
        </div>
    </body>

</html>
