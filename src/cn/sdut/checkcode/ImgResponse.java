package cn.sdut.checkcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
//验证码
@WebServlet("/ImgResponse")
public class ImgResponse extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImgResponse() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置Content-Type响应头
		response.setContentType("image/jpeg");
		//下面三条语句用于设置页面不缓存		
		response.setHeader("Pragma", "No-cache");//http1.0
		response.setHeader("Cache-Control", "no-cache");//http1.1
		response.setDateHeader("Expires", 0);//http1.1

		OutputStream out = response.getOutputStream();
		int width = 80, height = 20;
		//建立指定宽、高BufferedImage对象
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		//生成随机类
		Random random = new Random();

		g.fillRect(0, 0, width, height);
		//设置字体
		g.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			//设置随机颜色
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			//绘制
			g.drawString(rand, 20 * i + 6, 16);
		}
		g.dispose();

		//输出图象到页面
		ImageIO.write(image, "JPEG", out);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
