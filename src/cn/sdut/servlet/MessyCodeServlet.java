package cn.sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessyCodeServlet
 */
@WebServlet("/MessyCodeServlet")
public class MessyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessyCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 对于中文的乱码问题,在响应时作出的处理是相同的,有两种处理方式
		 * 而对于请求时的乱码问题,处理方式不同,原因是因为两种请求携带信息的方式不同
		 * get通过地址栏携带信息,post通过报头协议来携带信息
		 * 
		 * 请求时的乱码问题是能否从浏览器拿到正确的中文
		 * 响应时乱码问题是能否将正确的中文反馈给浏览器 
		 */
		
		/**
		 * 解决响应时出现的乱码问题的两种方式,编码方式的设置应在流的读取之前
		 */
		//1.不会改变浏览器的编码方式
		//response.setCharacterEncoding("UTF-8");
		//2.会把浏览器的编码方式改为utf-8
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		/**
		 * 解决get方式提交请求时的乱码问题,采用下面的方法 
		 * 或者修改tomcat的server.xml文件
		 * 在文件的以下代码段中添加  URIEcoding="utf-8"
		 * Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" URIEcoding="utf-8" />
		 */
		/*String name = request.getParameter("user");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");*/
		
		/**
		 * 解决post方式提交请求时的乱码问题,设置编码格式应在流的读取之前
		 */
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user");
		System.out.println("姓名:"+name);
		out.println("欢迎"+name);
	}

}
