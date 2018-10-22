package cn.sdut.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
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
		//设置以图片的形式打开下面的文件,并且设置浏览器以utf-8的格式进行响应
		response.setContentType("image/jpeg;charset=utf-8");
		//图片音频视频都用字节流进行处理
		ServletOutputStream out = response.getOutputStream();
		//流的传输 1.搭建管道
		FileInputStream fin = new FileInputStream("D:\\02_照片\\女朋友没错了\\IMG_0156.JPG");
		//2.读写操作
		byte[] bys = new byte[1024];
		int cnt = fin.read(bys);
		while( cnt!=-1 ) {
			//不能用println(),因为println并不是流的操作
			//String s = new String(bys);
			//out.println(s);
			out.write(bys);
			cnt = fin.read(bys);
		}
		out.flush();
		//3.关闭流
		fin.close();
	}

}
