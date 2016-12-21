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
import java.sql.ResultSet;

/**
 * Created by Admin on 06.11.2016.
 */

public class AddComment extends HttpServlet {
    Connection con;
    PreparedStatement ps;
    PreparedStatement ps2;
    ResultSet rs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String comment = req.getParameter("comment");
        String email = req.getParameter("email");
        long product = Long.parseLong(req.getParameter("product"));
        if (comment == null || email == null || comment.trim().equals("") || email.trim().equals("")) {
            out.print("<p><center>Заполните все поля</center></p>");
        } else {
            try {
                con = Database.getConnection();
                ps = con.prepareStatement("insert into comments(comment,email,product) values(" + comment + "," + email + "," + product + ")");
                int i = ps.executeUpdate();
                ps2 = con.prepareStatement("select * from comments where product=" + product + "order by com_id desc");
                rs = ps2.executeQuery();
                while (rs.next()) {
                    out.print("<div class='box'><p>" + rs.getString(1) + "</p><p><b>" + rs.getString(3) + "</b></p></div>");
                }
                con.close();
            } catch (Exception e) {
                out.print(e);
            }
        }
    }
}