package com.capg.servelet;

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


@WebServlet("/RegisterServelet")
public class RegisterServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RegisterServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
	    
		String Name = request.getParameter("Name");
		String Id = request.getParameter("Id");
		String Mobile = request.getParameter("Mobile");
		String Address= request.getParameter("Address");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "capg", "oracle123");
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,? )");
			ps.setString(1, Name);
			ps.setString(2, Id);
			ps.setString(3, Mobile);
			ps.setString(4, Address);
			int i= ps.executeUpdate(); 

			if (i==1) {
				out.println("Registered successfully! plz.. Login");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/index.html");
//				dispatcher.forward( request,response);
				dispatcher.include( request,response);
				System.out.println("SUCCESS");
			} else {
				System.out.println("Invalid credentials");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
