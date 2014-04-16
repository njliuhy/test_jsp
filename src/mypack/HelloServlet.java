
/**
 * This document gives an example of HttpServlet.
 * Override && doGet
 * including:
 * && request.getParameter
 * && How to pack an PrintWriter
 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//http://localhost:8088/test/hello?clientName=AVA
		
		String clientname = request.getParameter("clientName");
		if(clientname!=null)
			clientname = new String(clientname.getBytes("ISO-8859-1"), "GB2312");
		else
			clientname = "My Friend";
		
		PrintWriter out;
		String title = "HelloServlet";
		String heading1 = "This is output from HelloServlet by doget:";
		
		response.setContentType("text/html; charset = GB2312"); 
		
		out = response.getWriter();
		out.print("<Html><HEAD><TITLE>"+title+"</TITLE>");
		out.print("</HEAD><body>");
		out.print(heading1);
		out.println("<h1><p>"+clientname+"  hi</h1>");
		out.print("</body></HTML>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
