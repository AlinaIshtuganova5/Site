package ru.kpfu.itis.Alina.servlets;

import ru.kpfu.itis.Alina.utils.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Admin on 05.11.2016.
 */
public class EditServlet extends HttpServlet {
    private Connection con;
    private PreparedStatement ps;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String publisher = req.getParameter("publisher");
        String author = req.getParameter("author");
        Integer price = Integer.parseInt(req.getParameter("price"));
        String image = req.getParameter("image");
        Long product_id = Long.valueOf(req.getParameter("product_id"));
        int edition = Integer.parseInt(req.getParameter("edition"));
        String isbn = req.getParameter("isbn");
        String language = req.getParameter("language");
        int page = Integer.parseInt(req.getParameter("pages"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        int year = Integer.parseInt(req.getParameter("year"));
        try {
            con = Database.getConnection();
            ps = con.prepareStatement("UPDATE products SET product_name='" + name + "', publisher='" + publisher + "', author='" + author + "', price='" + price + "', image='" + image + "', edition='" + edition + "', isbn='" + isbn + "', language='" + language + "', page='" + page + "', weight='" + weight + "', year='" + year + "' WHERE product_id=" + product_id);
            int i = ps.executeUpdate();
            resp.sendRedirect("/views/productsForAdmin.jsp?page=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
    }
}