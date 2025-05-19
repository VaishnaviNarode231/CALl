package com.pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class PracS
 */
@WebServlet("/PracS")
public class PracS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PracS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ch=Integer.parseInt(request.getParameter("ch"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy","root","");
			if(con!=null) {
				if(ch==1) {
					int cid=Integer.parseInt(request.getParameter("cid"));
					String name=request.getParameter("name");
					int phone=Integer.parseInt(request.getParameter("phone"));
					PreparedStatement ps=con.prepareStatement("insert into dum(cid,name,phone) values(?,?,?)");
					ps.setInt(1,cid);
					ps.setString(2, name);
					ps.setInt(3, phone);
					int row=ps.executeUpdate();
					System.out.println("number of rows affected :"+row);
				}
				else if(ch==2) {
					int cid=Integer.parseInt(request.getParameter("cid"));
					String name=request.getParameter("name");
					int phone=Integer.parseInt(request.getParameter("phone"));
					PreparedStatement ps=con.prepareStatement("update dum set name=? , phone=? where cid=?");
					ps.setString(1, name);
					ps.setInt(2, phone);
					ps.setInt(3, cid);
                    int row=ps.executeUpdate();
					System.out.println("number of rows affected :"+row); 
				}
				else if(ch==3) {
					int cid=Integer.parseInt(request.getParameter("cid"));
					PreparedStatement ps=con.prepareStatement("delete from dum where cid=?");
					ps.setInt(1, cid);
					int row=ps.executeUpdate();
					System.out.println("number of rows affected :"+row); 
				}
				else if(ch==4) {
					PreparedStatement ps=con.prepareStatement("SELECT * from dum");
					   ResultSet rs = ps.executeQuery();
					   while(rs.next()) {
						   System.out.println("Contact Id :"+rs.getInt("cid"));
						   System.out.println("Name :"+rs.getString("name"));
						   System.out.println("Phone :"+rs.getInt("phone"));
					   }
				}
				else {
                    System.out.println("Invalid operation.");
                }
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
