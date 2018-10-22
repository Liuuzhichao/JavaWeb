package cn.sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet5() {
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
		
	this.validateDept(request, response);

	
	
	}
	public void  validateDept(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter  out=response.getWriter();
		String username=request.getParameter("user");
		String password=request.getParameter("password");
		String[] hobby=request.getParameterValues("hobby");
		if(username!=null &&  username!="")
		{
			out.println("Welcome  "+username);
		}else
		{
			out.println("Welcome guest");
		}
		if(password!=null &&  password!="")
		{
			out.println("your password is  "+password);
		}else
		{
			out.println("No  Password");
		}
		if(hobby==null)
		{
			out.println("No  Hobbys");
		}else
		{
			out.println("<b>your  hobby  is:</b><br/>");
		for(int i=0;i<hobby.length;i++)
		{
			out.println(hobby[i]+"<br/>");
		}
		}
		
		
		
	}

}
