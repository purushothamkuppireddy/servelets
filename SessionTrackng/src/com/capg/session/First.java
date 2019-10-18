package com.capg.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out= response.getWriter();
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
		Cookie ck1 = new Cookie("cookieName",uname);
		Cookie ck2 = new Cookie("cookieName",upassword);
		response.addCookie(ck1);
//		response.addCookie(ck2);
		
		out.print("<form action ='Second'>");
	
		out.print("<input type = 'submit' value = 'submit'>");
		out.print("</form>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
