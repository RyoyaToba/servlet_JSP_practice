package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		
//		Integer count = 0;
//		ServletContext application = config.getServletContext();
//		application.setAttribute("count", count);
//		
//		System.out.println("init()がじっこうされました");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>訪問回数を表示</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p>訪問回数:" + count + "</p>");
		out.print("<a href=\"/example3/CounterServlet\">更新</a>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destory()が呼ばれました");
	}

}
