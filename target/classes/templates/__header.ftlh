<#macro header>
<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Task</title>
    <style>
        .body {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        .main-container {
            display: flex;
            height: 95vh;
        }

        .right-background {
            flex-basis: 50%;
            background-color: #dfdfe5;
        }
        .left-background {
            flex-basis: 50%;
            background-color: #062580;
        }
        .right-background2 {
            background-color: #8e8e8e;
        }
        .left-background2 {
            background-color: #062580;
        }
        .left-img {
            width: 60%;
            display: block;
            margin-left: auto;
            margin-right: auto;
            margin-top: 10%;
        }
        .img {
            box-shadow: 0 10px 15px 10px #000;
            border: 10px white;
        }
        .form_sing {
            width: 70%;
            padding-left: 5%;
        }
        .btn_sing {
            padding: 5%;
        }
        .btn {
            background-color: #062580;
        }
        .sing_href {
            color: #062580;
        }
        .text-container {
            padding: 25px;

        }
        .text-container span {
            font-weight: bold;
            text-decoration: underline;
        }

        .img.d-block {
            box-shadow: 0 0 10px rgba(0,0,0,0.5)
        }

        .blue {
            background: #062580;
            color: white;
        }
    </style>
    <script type="text/javascript" th:src="@{/productScript.js}"> </script>
    <script>

    </script>
</head>
</#macro>