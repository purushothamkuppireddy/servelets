package com.capg.trainingEnroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/TrainingEnrollment")
public class TrainingEnrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TrainingEnrollment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "capg", "oracle123");
			PreparedStatement ps = con.prepareStatement("select * from training");
			ResultSet rs = ps.executeQuery();	
			out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>TrainingId</th><th>TrainingName</th><th>AvailableSeats</th><th>Action</th><tr>");
            while (rs.next()) {
               int id = rs.getInt(1);
                String name = rs.getString(2);
                int seat = rs.getInt(3); 
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + seat + "</td><td><a href='Updatingdatabase?enrollId="+id+"'>enroll</a></td></tr>"); 
            }
         
            out.println("</table>");
            out.println("</html></body>");
            con.close();	
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("in post");
	}

}
