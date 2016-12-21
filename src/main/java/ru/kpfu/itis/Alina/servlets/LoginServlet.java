package ru.kpfu.itis.Alina.servlets;

import ru.kpfu.itis.Alina.utils.Database;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Admin on 24.09.2016.
 */

public class LoginServlet extends HttpServlet {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        HttpSession s = req.getSession();
        String email = req.getParameter("email");
        s.setAttribute("email", email);
        try {
            con = Database.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from users where email='" + email + "'");
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    String password = cookie.getValue();
                    if (rs.next()) {
                        if (rs.getString(2).equals(password)) {
                            s.setAttribute("email", name);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (s.getAttribute("email") != null) {
            resp.sendRedirect("/profile");
        } else {
            getServletContext().getRequestDispatcher("/views/login.html").forward(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession s = req.getSession();
        if (s.getAttribute("email") != null) {
            resp.sendRedirect("/profile");
        } else {
            String email = req.getParameter("email");
            s.setAttribute("email", email);
            String password = req.getParameter("password");
            boolean remember = req.getParameter("remember") != null;
            try {
                con = Database.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("select * from users where email='" + email + "'");
                if (email.equals("admin@knigi.ru") && password.equals("admin"))
                    resp.sendRedirect("/views/productsForAdmin.jsp?page=1");
                else if (rs.next()) {
                    if (rs.getString(2).equals(password)) {
                        if (remember) {
                            Cookie cookie = new Cookie(email, password);
                            cookie.setMaxAge(10 * 10 * 10);
                            resp.addCookie(cookie);
                        }
                        s.setAttribute("email", email);
                        resp.sendRedirect("/profile");
                    } else {
                        resp.sendRedirect("/login?error_msg=Password+invalid&password=" + email);
                    }
                } else {
                    resp.sendRedirect("/login?error_msg=Username+not+registered&username=" + email);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}