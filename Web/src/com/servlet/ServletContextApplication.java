package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextApplication
 */
public class ServletContextApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContextApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String city = request.getParameter("city");
		String sradio = request.getParameter("sradio");
		String [] pet = request.getParameterValues("pet"); //null

		ServletContext application = getServletConfig().getServletContext();

		application.setAttribute("name", name);
		application.setAttribute("content",content);
		application.setAttribute("city", city);
		application.setAttribute("sradio", sradio);
		application.setAttribute("pet", pet);
		
		PrintWriter out = response.getWriter();

		
		out.write("<html>");
		out.write("	<body>");
		out.write("		<p> name : "+name);
		out.write("		<p> content : "+content);
		out.write("		<p> city : "+ city);
		out.write("		<p> sradio : "+ sradio);
		if( pet != null) {
			for(int i = 0; i<pet.length;i++) {
				out.write("<p>pet["+i+"] : "+pet[i]);
			}
		}else{
			out.write("<p>pet : null");
		}
		out.write("	</body>");
		out.write("</html>");
		
	}

}
