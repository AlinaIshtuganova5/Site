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
 * Created by Admin on 12.11.2016.
 */
public class DeleteProduct extends HttpServlet {
    private Connection con;
    private PreparedStatement ps1;
    private PreparedStatement ps2;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Long product_id = Long.valueOf(req.getParameter("product_id"));
        try {
            con = Database.getConnection();
            ps1 = con.prepareStatement("delete from comments where product=" + product_id);
            int i1 = ps1.executeUpdate();
            ps2 = con.prepareStatement("delete from products where product_id=" + product_id);
            int i2 = ps2.executeUpdate();
            resp.sendRedirect("/views/productsForAdmin.jsp?page=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/productsForAdmin.jsp?page=1").forward(req, resp);
    }
}

