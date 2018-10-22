package cn.sdut.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cooks = request.getCookies();
		if( cooks==null ) {
			//创建cookie的步骤123
			//1.创建cookie对象
			Cookie cook = new Cookie("user","liuzhichao");
			
			//2.设置cookie对象
			/**
			 * 设置cookie的生命周期,参数以秒为单位
			 * 正值:表示cookie的存活时间
			 * 负值或者不调用setMaxAge()方法:表示该cookie为临时cookie,只在本次会话中有效
			 * 0:表示删除该cookie
			 * 不调用setMaxAge()方法,则默认参数为-1;
			 */
			cook.setMaxAge(60);
			
			/**
			 * cookie默认只能由创建它的web应用中进行访问
			 * 如果调用setPath()方法,将参数设置为"/",
			 * 则表示可由同一应用服务器的所有web应用共享访问
			 */
			//cook.setPath("/");
			
			//3.将cookie对象响应给客户端浏览器,存储在客户端
			response.addCookie(cook);
		} else {
			/**
			 * Java后台获取的cookie是一个数组,虽然cookie是以键值对的形式存储的
			 * 但是想要从cookie数组中获取想要的元素,必须遍历数组
			 * 
			 * cookie和map都是以键值对的形式进行存储,但是一个是对象,一个是集合
			 * cookie的getValue()方法,没有参数,即不能通过key直接获取值
			 * map的getValue()方法,参数为key,可以通过key直接获取值
			 */
			for( Cookie item: cooks) {
				//获取cookie的键,获取cookie的值
				out.print(item.getName()+":"+item.getValue());
			}
		}
	}

}
