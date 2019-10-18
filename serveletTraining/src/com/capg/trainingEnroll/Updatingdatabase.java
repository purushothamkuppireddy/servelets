package com.capg.trainingEnroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Updatingdatabase")
public class Updatingdatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Updatingdatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt((request.getParameter("enrollId")));
		int seats=0;
		String course=null;
		out.println(id);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "capg", "oracle123");
			PreparedStatement ps = con.prepareStatement("select * from training where trainingId=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				seats=rs.getInt(3);
				course=rs.getString(2);
			}
			PreparedStatement ps2 = con.prepareStatement("update training set AvailableSeats=? where trainingId=?");
			 seats=seats-1;
			ps2.setInt(1,(seats));
			ps2.setLong(2, id);	
			int i=ps2.executeUpdate();
			if(i==1) {
				out.println("<h1>Hi you have successfully enrolled for "+course+" Training<h1><br> ");	
				out.println("<h3>Remianing seats"+seats+"</h3>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
