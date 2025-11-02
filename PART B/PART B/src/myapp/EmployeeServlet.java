package myapp;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/companydb";
    private static final String JDBC_USER = "root"; // change if needed
    private static final String JDBC_PASS = "Amanjeet@4321.";     // change if needed

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String empid = req.getParameter("empid");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

            if (empid != null && !empid.isEmpty()) {
                ps = con.prepareStatement("SELECT * FROM Employee WHERE EmpID=?");
                ps.setInt(1, Integer.parseInt(empid));
            } else {
                ps = con.prepareStatement("SELECT * FROM Employee");
            }

            rs = ps.executeQuery();

            out.println("<h2>Employee Records</h2>");
            out.println("<table border='1' cellpadding='6'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            boolean found = false;

            while (rs.next()) {
                found = true;
                out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>"
                        + rs.getString("Name") + "</td><td>"
                        + rs.getDouble("Salary") + "</td></tr>");
            }

            if (!found) out.println("<tr><td colspan='3'>No employee found</td></tr>");
            out.println("</table>");
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (rs != null) rs.close(); if (ps != null) ps.close(); if (con != null) con.close(); } catch (Exception ignored) {}
        }
    }
}
