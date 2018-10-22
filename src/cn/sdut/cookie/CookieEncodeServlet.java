package cn.sdut.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieEncodeServlet
 */
@WebServlet("/CookieEncodeServlet")
public class CookieEncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieEncodeServlet() {
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
		//对于页面的编码格式的设置一定要放在第一句
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cooks = request.getCookies();
		if( cooks==null ) {
			/**
			 * cookie进行存储时要进行编码,不识别中文,
			 * 所以在存储中文时要进行编码,在读取时要进行解码
			 */
			Cookie cook = new Cookie("user",URLEncoder.encode("刘志超","utf-8"));
			out.print("1");
			cook.setMaxAge(60);
			response.addCookie(cook);
		} else {
			for( Cookie item: cooks ) {
				out.print(item.getName()+":"+URLDecoder.decode(item.getValue(),"utf-8"));
			}
		}
	}

}
