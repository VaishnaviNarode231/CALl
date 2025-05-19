package com.pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/contact")
public class contact extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public contact() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response type
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        
        // Determine the operation: 1=insert, 2=update, 3=delete, 4=display
        int op = Integer.parseInt(request.getParameter("op"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb", "root", "");
            
            if (con != null) {
                if (op == 1) { // Insert Operation
                    int contactid = Integer.parseInt(request.getParameter("contactid"));
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String number = request.getParameter("number");
                    String email = request.getParameter("email");
                    String address = request.getParameter("address");
                    String category = request.getParameter("category");
                    
                    String sql = "INSERT INTO contact (contactid, firstname, lastname, number, email, address, category) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, contactid);
                    ps.setString(2, firstname);
                    ps.setString(3, lastname);
                    ps.setString(4, number);
                    ps.setString(5, email);
                    ps.setString(6, address);
                    ps.setString(7, category);
                    
                    int rows = ps.executeUpdate();
                    out.println("Inserted " + rows + " row(s).");
                    
                } else if (op == 2) { // Update Operation
                    // Update all fields for a given contact id
                    int contactid = Integer.parseInt(request.getParameter("contactid"));
                    String firstname = request.getParameter("firstname");
                    String lastname = request.getParameter("lastname");
                    String number = request.getParameter("number");
                    String email = request.getParameter("email");
                    String address = request.getParameter("address");
                    String category = request.getParameter("category");
                    
                    String sql = "UPDATE contact SET firstname = ?, lastname = ?, number = ?, email = ?, address = ?, category = ? WHERE contactid = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, firstname);
                    ps.setString(2, lastname);
                    ps.setString(3, number);
                    ps.setString(4, email);
                    ps.setString(5, address);
                    ps.setString(6, category);
                    ps.setInt(7, contactid);
                    
                    int rows = ps.executeUpdate();
                    out.println("Updated " + rows + " row(s).");
                    
                } else if (op == 3) { // Delete Operation
                    int contactid = Integer.parseInt(request.getParameter("contactid"));
                    
                    String sql = "DELETE FROM contact WHERE contactid = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, contactid);
                    
                    int rows = ps.executeUpdate();
                    out.println("Deleted " + rows + " row(s).");
                    
                } else if (op == 4) { // Display Operation
                    String sql = "SELECT * FROM contact";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        out.println("Contact ID: " + rs.getInt("contactid"));
                        out.println("First Name: " + rs.getString("firstname"));
                        out.println("Last Name: " + rs.getString("lastname"));
                        out.println("Number: " + rs.getString("number"));
                        out.println("Email: " + rs.getString("email"));
                        out.println("Address: " + rs.getString("address"));
                        out.println("Category: " + rs.getString("category"));
                        out.println("-------------------------");
                    }
                } else {
                    out.println("Invalid operation.");
                }
            } else {
                out.println("Failed to establish database connection.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
