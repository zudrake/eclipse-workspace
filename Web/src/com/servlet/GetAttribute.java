package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAttribute
 */
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAttribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc_kr");
		PrintWriter out = response.getWriter();

//		out.write("접속 성공");
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String city = request.getParameter("city");
		String sradio = request.getParameter("sradio");
		String [] pet = request.getParameterValues("pet");

		
		request.setAttribute("name", name);
		request.setAttribute("content", content);
		request.setAttribute("city", city);
		request.setAttribute("sradio	", sradio);
		request.setAttribute("pet", pet);
		
		String url = "/GetAtrributeView";
//		RequestDispatcher dis = getServletContext().getRequestDispatcher(url);//서버에서 서버로 경로이동시키는것
//		dis.forward(request, response);// 포워드 되는 순간 밑에 명령들은 무시된다.
		
		//2번째 다른 방법으로 이동시키기
		response.sendRedirect(url); //이건 서버에서 브라우져로
		
		
		//포워드 된 이후 밑에는 실행이 않됨
		
		out.write("<html>");
		out.write("	<body>");
		out.write("<p>"+(String)request.getAttribute("name"));
		out.write("<p>"+(String)request.getAttribute("content"));
		out.write("<p>"+(String)request.getAttribute("city"));
		out.write("<p>"+(String)request.getAttribute("sradio"));
		
		if(pet != null) {
			String[] attributePet = (String[])request.getAttribute("pet");
			for(int i = 0 ; i<pet.length;i++) {
				out.write(" pet : "+attributePet[i]);
			}
		}
		out.write("	</body>");
		out.write("</html>");
		
				
	
	}

}