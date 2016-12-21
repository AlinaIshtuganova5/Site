<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.11.2016
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Редактирование</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
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
                <a href="/views/productsForAdmin.jsp?page=1" class="link-home"></a>
                <h2 class="title-home">КНИГИ.РУ</h2>
            </div>
        </div>
    </div>
    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <div class="content">
            <div class="add-product">
                <form class="simple_form" action="/edit" method="POST">
                    <div class="main">
                        <% request.setCharacterEncoding("utf-8"); %>
                        <% response.setCharacterEncoding("utf-8"); %>
                        <br/><br/><br/>
                        НАЗВАНИЕ: <br/><br/><input type="text" class="input-class" name="name"
                                                   value="<%=request.getParameter("name")%>"/>
                        <br/><br/>
                        АВТОР: <br/><br/><input type="text" class="input-class" name="author"
                                                value="<%=request.getParameter("author")%>"/>
                        <br/><br/>
                        ЦЕНА: <br/><br/><input type="text" class="input-class" name="price"
                                               value="<%=request.getParameter("price") %>"/>
                        <br/><br/>
                        КОЛИЧЕСТВО СТРАНИЦ: <br/><br/><input type="text" class="input-class" name="pages"
                                                             value="<%=request.getParameter("pages")%>"/>
                        <br/><br/>
                        ГОД ВЫПУСКА: <br/><br/><input type="text" class="input-class" name="year"
                                                      value="<%=request.getParameter("year")%>"/>
                        <br/><br/>
                        ISBN: <br/><br/><input type="text" class="input-class" name="isbn"
                                               value="<%=request.getParameter("isbn")%>"/>
                        <br/><br/>
                        ТИРАЖ: <br/><br/><input type="text" class="input-class" name="edition"
                                                value="<%=request.getParameter("edition")%>"/>
                        <br/><br/>
                        ИЗДАТЕЛЬСТВО: <br/><br/><input type="text" class="input-class" name="publisher"
                                                       value="<%=request.getParameter("publisher") %>"/>
                        <br/><br/>
                        ЯЗЫК ИЗДАНИЯ: <br/><br/><input type="text" class="input-class" name="language"
                                                       value="<%=request.getParameter("language")%>"/>
                        <br/><br/>
                        ВЕС В УПАКОВКЕ, Г: <br/><br/><input type="text" class="input-class" name="weight"
                                                            value="<%=request.getParameter("weight")%>"/>
                        <br/><br/>
                        ИЗОБРАЖЕНИЕ: <br/><br/><input type="text" class="input-class" name="image"
                                                      value="<%=request.getParameter("image")%>"/><br/><br/><br/>
                        <input type='submit' class='submit-class' value='РЕДАКТИРОВАТЬ'/>
                        <input type="hidden" name="product_id" value="<%=request.getParameter("product_id")%>">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="footer">
    <a href="#home-link" class="home-link">&nbsp;</a>
    <div class="center clearfix">
        <div class="f-about">
            <h5 class="f-title">Контакты</h5>
            <p>Книжный интернет-магазин "Книги.ру"
                Электронная почта: shop@knigi.ru</p>
        </div>
    </div>
</div>
