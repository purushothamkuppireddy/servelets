package com.capg.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servelet1")
public class Servelet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servelet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname1 = request.getParameter("uname");
		String upassword1 = request.getParameter("upassword");
		
		
		out.println("<form action='Servelet2'>");
		out.println("<input type='hidden' name=uname value="+uname1+">");
		out.println("<input type='hidden' name=upassword value="+upassword1+">");
		out.println("<input type='submit' value='SUBMIT2'></form>");
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
