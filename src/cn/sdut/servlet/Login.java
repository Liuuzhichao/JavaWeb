package cn.sdut.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sdut.dao.User;
import cn.sdut.dao.UserDao;
import cn.sdut.dao.UserDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		 * 获取前端单个参数以及参数值getParameter()方法
		 * 以及获取复选框的值
		 */
		/*String username = request.getParameter("user");
		String pwd = request.getParameter("password");
		System.out.println("username:"+username+",password:"+pwd);
		String[] hobby = request.getParameterValues("hobby");
		for(String item: hobby) {
			System.out.println(item);
		}*/
		/**
		 * map集合获取前端所有的参数以及参数值
		 */
		/*Map<String,String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> item: map.entrySet()) {
			System.out.print(item.getKey()+":");
			for(String items: item.getValue()){
				System.out.print(items+"\t");
			}
			System.out.println();
		}*/
		/**
		 * 获取前端的所有的参数名字,不能获取参数值
		 */
		/*Enumeration<String> em=request.getParameterNames();
		while(em.hasMoreElements())
		{
			String  name=em.nextElement();
			System.out.println("name:"+name);
		}*/
		
		/**
		 * 插入一个用户
		 */
		String name = request.getParameter("user");
		String pwd = request.getParameter("password");
		User user = new User(name,pwd);
		UserDao userDao = new UserDaoImpl();
		userDao.addUser(user);
	}

}
