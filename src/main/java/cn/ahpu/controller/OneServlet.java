package cn.ahpu.controller; /**
 * @author:liwang
 * @date: 2022/3/17 22:04
 * @Description:TODO
 * @Algorithm Design：TODO
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OneServlet", value = "/oneServlet")
public class OneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OneServlet类方法doGet执行……");
//		1.调用当前请求参数中对象
		String userName = request.getParameter("userName");
		String money = request.getParameter("money");
//		2.开卡
		Cookie card1 = new Cookie("userName", userName);
		Cookie card2 = new Cookie("money", money);
//		3.发卡
		response.addCookie(card1);
		response.addCookie(card2);
//		4.点餐页面写入响应体中
//			以路径名称开头的相对路径，其参照路径都是当前访问路径的资源路径
		request.getRequestDispatcher("/index_2.html").forward(request,response);//这里加不加/ 作用都一样
		System.out.println("OneServlet类方法doGet执行结束");


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
