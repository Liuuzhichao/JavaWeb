package cn.sdut.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieEx01
 * 使用Cookie记录用户上一次访问时间，并显示用户访问本站的次数
 */
@WebServlet("/CookieEx01")
public class CookieEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieEx01() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if( cooks==null ){
			Cookie date = new Cookie("date",sdf.format(new Date()));
			Cookie cnt = new Cookie("cnt","1");
			out.print("第一次访问时间:"+date.getValue()+"</br>");
			out.print("您是第1次访问本站");
			date.setMaxAge(60*3);
			cnt.setMaxAge(60*3);
			response.addCookie(date);
			response.addCookie(cnt);
		} else {
			boolean flag = false;
			for( Cookie item: cooks ) {
				if ( "date".equals(item.getName()) ) {
					String date = sdf.format(new Date());
					if( !date.equals(item.getValue()) ) {
						out.print("上次访问时间:"+item.getValue()+"</br>");
						item.setValue(date);
						response.addCookie(item);
						flag = true;
					} 
				}
				if ( "cnt".equals(item.getName()) && flag ) {
					out.print("您是第"+item.getValue()+"次访问本站");
					int cnt = Integer.parseInt(item.getValue());
					cnt++;
					item.setValue(String.valueOf(cnt));
					response.addCookie(item);
				}
			}
		}
	}
}
