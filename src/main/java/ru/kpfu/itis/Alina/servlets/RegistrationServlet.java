package ru.kpfu.itis.Alina.servlets;

import ru.kpfu.itis.Alina.utils.Database;

import javax.servlet.RequestDispatcher;
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
 * Created by Admin on 15.11.2016.
 */
public class RegistrationServlet extends HttpServlet {
    private Connection con;
    private PreparedStatement ps;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String name = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password1");
        try {
            con = Database.getConnection();
            ps = con.prepareStatement("insert into users values(?,?,?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            int i = ps.executeUpdate();
            resp.sendRedirect("/profile");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("/register?error_msg=Email+already+in+use");
        }
        PrintWriter out = resp.getWriter();
        out.write("Register successfull...");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/registration.html");
        rd.forward(req, resp);
    }
}