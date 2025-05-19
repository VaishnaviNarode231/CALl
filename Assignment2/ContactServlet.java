package com.mypack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private String dbURL = "jdbc:mysql://localhost:3306/contactdb";
    private String dbUser = "root";
    private String dbPass = "";
    
    public ContactServlet() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("op"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            
            if(con != null) {
                if(op == 1) { // Insert
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
                    request.setAttribute("message", "Inserted " + rows + " row(s).");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                    
                } else if(op == 2) { // Update
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
                    request.setAttribute("message", "Updated " + rows + " row(s).");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                    
                } else if(op == 3) { // Delete
                    int contactid = Integer.parseInt(request.getParameter("contactid"));
                    String sql = "DELETE FROM contact WHERE contactid = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, contactid);
                    
                    int rows = ps.executeUpdate();
                    request.setAttribute("message", "Deleted " + rows + " row(s).");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                    
                } else if(op == 4) { // Display
                    String sql = "SELECT * FROM contact";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    
                    List<Contact> contactList = new ArrayList<>();
                    while(rs.next()){
                        Contact c = new Contact();
                        c.setContactid(rs.getInt("contactid"));
                        c.setFirstname(rs.getString("firstname"));
                        c.setLastname(rs.getString("lastname"));
                        c.setNumber(rs.getString("number"));
                        c.setEmail(rs.getString("email"));
                        c.setAddress(rs.getString("address"));
                        c.setCategory(rs.getString("category"));
                        contactList.add(c);
                    }
                    request.setAttribute("contactList", contactList);
                    request.getRequestDispatcher("display_contacts.jsp").forward(request, response);
                }        
                else if(op == 5) { // Search Operation
                    String query = request.getParameter("query");
                    String sql = "SELECT * FROM contact WHERE firstname LIKE ? OR lastname LIKE ? OR email LIKE ?";
                    
                    try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        String searchTerm = "%" + query + "%";
                        ps.setString(1, searchTerm);
                        ps.setString(2, searchTerm);
                        ps.setString(3, searchTerm);
                        
                        ResultSet rs = ps.executeQuery();
                        List<Contact> contactList = new ArrayList<>();
                        
                        while(rs.next()){
                            Contact c = new Contact();
                            c.setContactid(rs.getInt("contactid"));
                            c.setFirstname(rs.getString("firstname"));
                            c.setLastname(rs.getString("lastname"));
                            c.setNumber(rs.getString("number"));
                            c.setEmail(rs.getString("email"));
                            c.setAddress(rs.getString("address"));
                            c.setCategory(rs.getString("category"));
                            contactList.add(c);
                        }
                        
                        request.setAttribute("contactList", contactList);
                        request.setAttribute("searchQuery", query); 
                        
                        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                        dispatcher.forward(request, response);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                else {
                    request.setAttribute("message", "Invalid operation.");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "Database connection failed.");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
        } catch(Exception e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}
