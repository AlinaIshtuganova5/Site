<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.11.2016
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var request;
    function postComment() {
        var comment = document.commentform.comment.value;
        var email = document.commentform.email.value;
        var product = document.commentform.product.value;
        var url = "/addComment?comment=" + comment + "&email=" + email + "&product=" + product;
        if (window.XMLHttpRequest) {
            request = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) {
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }
        try {
            request.onreadystatechange = function () {
                if (request.readyState == 4) {
                    var val = request.responseText;
                    document.getElementById('mylocation').innerHTML = val;
                }
            }
            request.open("GET", url, true);
            request.send();
        } catch (e) {
            alert("Unable to connect to server");
        }
    }
</script>
<head>
    <meta charset="UTF-8">
    <title>Описание товара</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
        </div>
    </div>
    <div id="header" class="center clearfix">
    </div>
    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="/views/productsForUser.jsp?page=1" class="link-home"></a>
                <h2 class="title-home">КНИГИ.РУ</h2>
            </div>
        </div>
    </div>
    <div class="middle clearfix center">
        <div class="content">
            <div class="descr">
                <form class="simple_form" action="/addtocart" method="POST">
                    <div class="main">
                        <br/><br/>
                        <input type="hidden" name="product_id" value="<%=request.getParameter("product_id")%>">
                        <img src="<%=request.getParameter("image")%>" height="245" width="191"
                             alt="Обложка"/>
                        <br/><br/>
                        НАЗВАНИЕ: <input type="hidden" name="name"
                                         value="<%=request.getParameter("name")%>"><%=request.getParameter("name")%>
                        <br/><br/>
                        ЦЕНА: <input type="hidden" name="pricee"
                                     value="<%=request.getParameter("pricee")%>"><%=request.getParameter("pricee") %>
                        руб.
                        <br/><br/>
                        АВТОР: <%=request.getParameter("author")%>
                        <br/><br/>
                        КОЛИЧЕСТВО СТРАНИЦ: <%=request.getParameter("pages")%>
                        <br/><br/>
                        ГОД ВЫПУСКА: <%=request.getParameter("year")%>
                        <br/><br/>
                        ISBN: <%=request.getParameter("isbn")%>
                        <br/><br/>
                        ТИРАЖ: <%=request.getParameter("edition")%>
                        <br/><br/>
                        ИЗДАТЕЛЬСТВО: <%=request.getParameter("publisher") %>
                        <br/><br/>
                        ЯЗЫК ИЗДАНИЯ: <%=request.getParameter("language")%>
                        <br/><br/>
                        ВЕС В УПАКОВКЕ, Г: <%=request.getParameter("weight")%>
                        <br/><br/><br/>
                        <input type='submit' class='submit-class' value='ДОБАВИТЬ В КОРЗИНУ'/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="comment">
    <form name="commentform">
        ВАШ КОММЕНТАРИЙ:<br/>
        <input id="comment" name="comment" type="text"><br/>
        ВАШЕ ИМЯ:<br/>
        <input id="email" type="text" name="email"/><br/><br/>
        <input type="hidden" name="product" value="<%=request.getParameter("product_id")%>"/>
        <input type="button" class="add-cart" value="ДОБАВИТЬ КОММЕНТАРИЙ" onclick="postComment()"><br/><br/>
    </form>
</div>
<span id="mylocation"></span>
<div id="footer">
    <div class="center clearfix">
        <div class="f-about">
            <h5 class="f-title">Контакты</h5>
            <p>Книжный интернет-магазин "Книги.ру"
                Электронная почта: shop@knigi.ru</p>
        </div>
    </div>
</div>