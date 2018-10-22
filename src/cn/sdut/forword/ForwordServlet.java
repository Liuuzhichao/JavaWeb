package cn.sdut.forword;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwordServlet
 */
@WebServlet("/ForwordServlet")
public class ForwordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwordServlet() {
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
		//1.
		/**
		 * The pathname specified may be relative, 
		 * although it cannot extend outside the current servlet context.
		 * If the path begins with a "/" it is interpreted as relative to the current context root.
		 * This method returns null if the servlet container cannot return a RequestDispatcher
		 * 
		 * 指定的路径名可能是相对的，尽管它不能扩展到当前servlet上下文之外。
		 * 如果路径以“/”开头，则解释为相对于当前上下文根。
		 * 如果servlet容器不能返回RequestDispatcher，则此方法返回null
		 */
		//RequestDispatcher rd= request.getRequestDispatcher("Hello");ָ
		//rd.forward(request, response);
		
		//2.
		/**
		 * The pathname must begin with a "/" and is interpreted as relative to the current context root.
		 * Use getContext to obtain a RequestDispatcher for resources in foreign contexts.
		 * This method returns null if the ServletContext cannot return a RequestDispatcher. 
		 * 
		 * 路径名必须以“/”开头，并被解释为相对于当前上下文根。
		 * 使用getContext为外部上下文中的资源获取RequestDispatcher。
		 * 如果servlet上下文不能返回RequestDispatcher，则此方法返回null。
		 */
		request.getServletContext().getRequestDispatcher("/Hello").forward(request, response);
	}

}
