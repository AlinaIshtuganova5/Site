package ru.kpfu.itis.Alina.servlets;

import ru.kpfu.itis.Alina.utils.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Admin on 14.11.2016.
 */
public class AddProduct extends HttpServlet {
    Connection con;
    Statement st;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/addProduct.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String product_name = req.getParameter("product_name");
        String publisher = req.getParameter("publisher");
        String author = req.getParameter("author");
        int price = Integer.parseInt(req.getParameter("price"));
        String image = req.getParameter("image");
        int edition = Integer.parseInt(req.getParameter("edition"));
        String isbn = req.getParameter("isbn");
        String language = req.getParameter("language");
        int page = Integer.parseInt(req.getParameter("pages"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        int year = Integer.parseInt(req.getParameter("year"));
        try {
            con = Database.getConnection();
            st = con.createStatement();
            int k = st.executeUpdate("insert into products(product_name,publisher, author, price, image, edition, isbn, language, page, weight, year) values ('" + product_name + "','" + publisher + "','" + author + "','" + price + "','" + image + "','" + edition + "','" + isbn + "','" + language + "','" + page + "','" + weight + "','" + year + "')");
            resp.sendRedirect("/views/productsForAdmin.jsp?page=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
