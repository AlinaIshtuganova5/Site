<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.11.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@page import="ru.kpfu.itis.Alina.models.Book" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Книги.ру</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="login">
                <a href="/logout">Выход</a>
            </div>
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

    <% int spageid = Integer.parseInt(request.getParameter("page"));
        int pageid = spageid;
        int total = 6;
        if (pageid == 1) {
        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
    %>

    <form action="/addProduct">
        <input type="submit" class="submit-class-add" value="ДОБАВИТЬ"/><br/><br/>
    </form>
    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <jsp:useBean id="bookList" class="ru.kpfu.itis.Alina.repositories.BookRepository" scope="page"/>
        <h3>${param.name}</h3>
        <% for (Book book : bookList.getRecords(pageid, total)) {
        %>
        <div class="productsForUser">
            <form action="/views/edit.jsp">
                <input type="hidden" name="product_id" value="<%=book.getId()%>">
                <div class="img">
                    <center><input type="hidden" name="image" value="<%=book.getImage()%>"><img
                            src="<%=book.getImage()%>" height="245" width="191" alt="Обложка"/></center>
                </div>
                <div class="p-footer">
                    <h6><input type="hidden" name="name"
                               value="<%=book.getName()%>"><%=book.getName()%><p><span><input type="hidden"
                                                                                              name="author"
                                                                                              value="<%=book.getAuthor()%>"><%=book.getAuthor()%></span>
                    </h6>
                    <input type="hidden" name="publisher" value="<%=book.getPublisher()%>">
                    <input type="hidden" name="edition" value="<%=book.getEdition()%>">
                    <input type="hidden" name="isbn" value="<%=book.getIsbn()%>">
                    <input type="hidden" name="language" value="<%=book.getLanguage()%>">
                    <input type="hidden" name="pages" value="<%=book.getPages()%>">
                    <input type="hidden" name="weight" value="<%=book.getWeight()%>">
                    <input type="hidden" name="year" value="<%=book.getYear()%>">
                    <div class="p-footer-price clearfix">
                        <span class="price"><input type="hidden" name="price"
                                                   value="<%=book.getPrice()%>"><%=book.getPrice()%> руб.</span>
                        <input type="submit" class="right add-cart" value="РЕДАКТИРОВАТЬ"/>
                    </div>
                </div>
            </form>
            <form name="form1" action="/deleteProduct" method="post">
                <input type="hidden" name="product_id" value="<%=book.getId()%>">
                <input type="submit" class="add-cart-delete" value="УДАЛИТЬ" onclick="return confirm('УДАЛИТЬ ЛИ ДАННЫЙ ПРОДУКТ?')"/>
            </form>
        </div>
        <%}%>
    </div>
</div>
</div>

<div class="pagination">
    <ul class="clearfix"><a href="/views/productsForAdmin.jsp?page=1">1</a>
        <a href="/views/productsForAdmin.jsp?page=2">2</a></ul>
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
