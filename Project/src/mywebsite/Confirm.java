package mywebsite;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
import beans.Delivery_method;
import beans.PaymentOption;
import beans.User;
import dao.Order_detailDAO;
import dao.Order_historyDAO;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/Confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirm() {
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		User user = (User) session.getAttribute("user_delivery");
		ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
		Delivery_method delivery = (Delivery_method) session.getAttribute("delivery_method");
		PaymentOption payment = (PaymentOption) session.getAttribute("payment_option");
		int total = Integer.parseInt(request.getParameter("total_price"));

		Order_historyDAO orderHistoryDAO = new Order_historyDAO();
		int order_id = orderHistoryDAO.setOrderHistory(delivery.getDelivery_method_id(),total,user.getUser_name(),user.getClassification_id(),payment.getPayment_option_id());

		Order_detailDAO orderDetailDAO = new Order_detailDAO();
		for(CartBeans CB : cart) {
			orderDetailDAO.setOderDetail(CB,order_id,payment.getPayment_option_id());
		}
		request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp").forward(request, response);
	}
}
