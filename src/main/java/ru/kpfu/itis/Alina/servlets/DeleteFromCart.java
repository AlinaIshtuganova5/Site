package ru.kpfu.itis.Alina.servlets;

import ru.kpfu.itis.Alina.models.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Admin on 05.11.2016.
 */
public class DeleteFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    protected void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        Cart shoppingCart;
        shoppingCart = (Cart) session.getAttribute("cart");
        shoppingCart.deleteFromCart(name);
        session.setAttribute("cart", shoppingCart);
        shoppingCart = (Cart) session.getAttribute("cart");
        PrintWriter out = resp.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta http-equiv='Content-Type' content='text/html'; charset='utf-8'/>" +
                    "<title>Корзина</title><link rel='stylesheet' href='css/style.css'/></head><body>" +
                    "<div id='wrapper'><div class='panel-top'><div class='center clearfix'></div></div>" +
                    "<div id='header' class='center clearfix'></div><div id='home'><div class='home-bg'>" +
                    "<div class='center'><a href='/views/productsForUser.jsp?page=1' class='link-home'></a>" +
                    "<h2 class='title-home'>КНИГИ.РУ</h2></div></div></div>" +
                    "<div class='middle clearfix center'><div class='sidebar'></div><div class='content'>" +
                    "<div class='registr'><div class='header-login'><br><br><h4>КОРЗИНА</h4><br><br><br></div>");
            HashMap<String, Integer> items = shoppingCart.getCartItems();
            out.println("<div class='cartTable'><table border='1px' width='750px'><col width='460px'><col width='145px'><col width='145px'>");
            for (String key : items.keySet()) {
                out.println("<form action='deleteItem'><input type='hidden' name='name' value='" + key + "'><tr><td>" + key + "</td><td>" + items.get(key) + " руб.</td><td><input type='submit' class='right add-cart' value='УДАЛИТЬ'></td></tr></form>");
            }
            if (items.isEmpty()) {
                out.println("<div class=cartFont>Корзина пуста</div>");
            }
            out.println("</table></div></div></div></div></div>");
            out.println("<div id='footer'><a href='#home-link' class='home-link'>&nbsp;</a>" +
                    "<div class='center clearfix'><div class='f-about'><h5 class='f-title'>Контакты</h5>" +
                    "<p>Книжный интернет-магазин 'Книги.ру' " +
                    "Электронная почта: shop@knigi.ru</p></div></div></div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
        }
    }
}
