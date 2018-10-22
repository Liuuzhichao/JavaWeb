package cn.sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderServlet
 */
@WebServlet("/ResponseHeaderServlet")
public class ResponseHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseHeaderServlet() {
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
		PrintWriter  out=response.getWriter();
		out.println(new Date());
		//刷新界面并设置刷新表头的时间
		//response.setIntHeader("Refresh", 2);
		//刷新界面,并定向到其他网址
		//response.setHeader("Refresh", "2;url=http://www.baidu.com");
	     //response.setHeader("Refresh", "2;url=HelloServlet");
		//下载,弹窗,设置下载文件的名字
		response.setHeader("Content-disposition","attachment;filename=abc.txt");
	}

}
