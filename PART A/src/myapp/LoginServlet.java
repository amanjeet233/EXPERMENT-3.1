package myapp;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("Amanjeet".equals(user) && "123456789".equals(pass)) {
            out.println("<h2>Welcome, " + BYTXL + "!</h2>");
        } else {
            out.println("<h2 style='color:red;'>Invalid Username or Password</h2>");
        }

        out.close();
    }
}
