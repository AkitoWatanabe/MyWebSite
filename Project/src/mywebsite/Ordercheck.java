package mywebsite;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
import beans.LoginInfo;
import beans.User;

/**
 * Servlet implementation class Oredercheck
 */
@WebServlet("/Ordercheck")
public class Ordercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordercheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//カートが空ならばtopへ飛ばす
		HttpSession session = request.getSession();

		ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
		CartBeans cartbeans = new CartBeans();
		User user = (User) session.getAttribute("user_delivery");
		String delivery_method_tmp = (String) session.getAttribute("delivery_method");
		int delivery_method = Integer.parseInt(delivery_method_tmp);

		//セッションにカートがない場合カートを作成
		if (cart == null) {
			cart = new ArrayList<CartBeans>();
		}
		//カートが空の場合
		if(cart.size() == 0 || user == null || delivery_method == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
			dispatcher.forward(request, response);
		}
		String radio = request.getParameter("customRadio");
		int paymentoption = 0;
		if(radio.equals("cash")) {
			//4代金引換
			paymentoption = 4;
		}else if(radio.equals("tmpcard")) {
			//2クレジットカード(非登録)
			paymentoption = 2;
			String card = (String) request.getAttribute("card");
			request.setAttribute("card", card);
		}else if(radio.equals("transfer")) {
			//3銀行振込
			paymentoption = 3;
		}else {
			LoginInfo userinfo = (LoginInfo) session.getAttribute("userInfo");
			int tmp = userinfo.getUser_card();
			if(tmp == 0) {
				request.setAttribute("errMsg", "クレジットカードが登録されていない為、選択できません");
				request.setAttribute("user_delivery", user);
				request.setAttribute("delivery_method", delivery_method);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp");
				dispatcher.forward(request, response);
				return;
			}else {
				//1登録されたクレジットカード
				paymentoption = 1;
			}
		}
		request.setAttribute("parment_option", paymentoption);
		request.setAttribute("user_delivery", user);
		request.setAttribute("delivery_method", delivery_method);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ordercheck.jsp");
		dispatcher.forward(request, response);
	}

}
