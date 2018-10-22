package cn.sdut.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
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
		
		/**
		 * 使用HttpServletRequest中的getSession()方法创建session实例
		 * HttpSession getSession();和getSeesion(true);
		 * 	如果有session对象,则使用原来的session;
		 * 	如果没有session对象,则创建一个
		 * HttpSession getSession(boolean create);
		 * 	getSeesion(false);
		 * 		如果有session对象,则使用原来的session;
		 * 		如果没有session对象,则返回null
		 */
		HttpSession session = request.getSession();
		
		/**
		 * 服务器端的session对象信息
		 * 	客户端第一次发送请求时,服务器会为该客户端在服务器端创建一个session对象(存储本次会话的信息),
		 * 在返回给客户端时,会为该session对象映射一个唯一的sessionId来标识该客户端
		 * (sessionId通过临时cookie进行传输,在禁用cookie时,通过重写URL方式传送)
		 * 本次会话结束,sessionId销毁,session对象不会立马销毁,而是会等待一段时间(决定于服务器)
		 */
		out.println("<center><h1>===Session Info===</h1></center>");
		//session是否是新的
		out.println("isNew:<b>"+session.isNew()+"</b><br/>");
		//获取session的id
		out.println("sessionId:<b>"+session.getId()+"</b><br/>");
		//session的创建时间(第一次访问时间)
		out.println("CreationTime:<b>"+new Date(session.getCreationTime())+"</b><br/>");
		//上次访问时间
		out.println("LastAccessedTime:<b>"+new Date(session.getLastAccessedTime())+"</b><br/>");
		
		/**
		 * 客户端的session对象信息
		 * 	服务器端给客户端一个唯一的sessionId来标识该客户端,
		 * 在本次会话中,客户端的请求都会携带该sessionId
		 */
		out.println("<center><h1>===Request SessionInfo===</h1></center>");
		//客户端sessionId,应与服务器端相同
		out.println("sessionId:<b>"+request.getRequestedSessionId()+"</b><br/>");
		//客户端的sessionId是否来自cookie
		out.println("FromCookie:<b>"+request.isRequestedSessionIdFromCookie()+"</b><br/>");
		//客户端的sessionId是否来自URL
		out.println("FromURL:<b>"+request.isRequestedSessionIdFromURL()+"</b><br/>");
		//客户端的sessionId是否有效
		out.println("isValid:<b>"+request.isRequestedSessionIdValid()+"</b><br/>");
		
		/**
		 * 在禁用cookie时,通过重写URL来进行携带sessionId
		 * 	URL重写方法根据请求信息中是否包含"Set-Cookie"请求头来决定是否进行URL重写,
		 * 若包含该请求头,表示通过cookie携带sessionId,则会将URL原样输出;
		 * 若不包含,表示通过URL携带sessionId,则会将会话标识重写到URL中
		 */
		//禁用cookie,不通过URL重写携带sessionId的测试
		out.println("<a href="+request.getRequestURI()+">test</a><br/>");
		/**
		 * 禁用cookie,通过URL重写携带sessionId的测试
		 * 	encodeURL()方法可以对任意请求的URL进行重写
		 * 	encodeRedirectURL()方法主要对使用sendRedirect()方法的URL进行重写
		 */
		//out.println("<a href="+response.encodeURL(request.getRequestURI())+">test</a><br/>");
		out.println("<a href="+response.encodeRedirectURL((request.getRequestURI()))+">test</a><br/>");
	}

}
