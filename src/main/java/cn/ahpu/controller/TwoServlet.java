package cn.ahpu.controller; /**
 * @author:liwang
 * @date: 2022/3/17 22:21
 * @Description:TODO
 * @Algorithm Design：TODO
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TwoServlet", value = "/twoServlet")
public class TwoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TwoServlet类doGet方法执行……");
		int jiaozi_money = 30;
		int gaifan_money = 15;
		int miantiao_money = 20;
		int money = 0,xiaofei=0,balance=0;
		String food = null, userName = null;
		Cookie[] cookieArray = request.getCookies();
		System.out.println("1");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//		1.读取请求头参数信息
		System.out.println("2");
		food = request.getParameter("food");
		System.out.println("3");
		Cookie newCard = null;

		if (cookieArray!=null){
			for (Cookie card : cookieArray) {
				String key = card.getName();
				String value = card.getValue();
				if ("userName".equals(key)) {
					userName = key;
				} else if ("money".equals(key)) {
					money = Integer.parseInt(value);
					if ("饺子".equals(food)) {
						if (jiaozi_money > money) {
							out.print("用户 " + userName + "请充值吧你");
						} else {
							xiaofei=jiaozi_money;
							balance=money-jiaozi_money;
							newCard = new Cookie("money", balance+ "");
						}
					} else if ("面条".equals(food)) {
						if (miantiao_money > money) {
							out.print("用户 " + userName + " 余额不足，请充值");
						}else {
							xiaofei=miantiao_money;
							balance=money-miantiao_money;
							newCard = new Cookie("money", balance + "");
						}
					} else if ("盖饭".equals(food)) {
						if (gaifan_money > money) {
							out.print("用户 " + userName + "余额不足 请充值");
						}else {
							xiaofei=gaifan_money;
							balance=money-gaifan_money;
							newCard = new Cookie("money", balance + "");
						}
					}
				}
			}
		}else {
			System.out.println("cookieArray为null");
		}

//		4.用户会员卡发回给用户
		response.addCookie(newCard);
//		5.消费记录写到响应体中
		out.print("用户 "+userName+" 本次消费(大洋：)："+xiaofei+" 余额:"+balance);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
