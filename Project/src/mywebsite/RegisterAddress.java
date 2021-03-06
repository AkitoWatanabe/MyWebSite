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

/**
 * Servlet implementation class RegisterAddress
 */
@WebServlet("/RegisterAddress")
public class RegisterAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
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

		//セッションにカートがない場合カートを作成
		if (cart == null) {
			cart = new ArrayList<CartBeans>();
		}
		//カートが空の場合
		if(cart.size() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
			dispatcher.forward(request, response);
		}

		// ログインセッションがない場合は表示が変わる
		LoginInfo checkSession = (LoginInfo)session.getAttribute("userInfo");
		if(checkSession == null) {
			request.setAttribute("loginCheck", "ログインされていません");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registeraddress.jsp");
		dispatcher.forward(request, response);
	}

}
