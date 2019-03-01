package mywebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBeans;
import beans.Delivery_method;
import beans.LoginInfo;
import beans.User;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
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
		request.setCharacterEncoding("UTF-8");
		//カートが空ならばtopへ飛ばす
		HttpSession session = request.getSession();

		ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
		CartBeans cartbeans = new CartBeans();
		String delivery_method_num = request.getParameter("delivery_method");
		DeliveryMethodDAO deliveryMethodDAO = new DeliveryMethodDAO();

		//セッションにカートがない場合カートを作成
		if (cart == null) {
			cart = new ArrayList<CartBeans>();
		}
		//カートが空の場合
		if(cart.size() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
			dispatcher.forward(request, response);
		}
		//tmpaddressは登録ユーザが登録された住所以外に配送する場合
		//nullは非登録ユーザ
		//その他は登録ユーザの住所
        String radio = request.getParameter("customRadio");
        System.out.println(radio);
        User user = new User();
        if(radio == null){
        	user.setUser_mail(request.getParameter("mail"));
        	user.setClassification_id(2);
        }if(Objects.equals(radio ,"tmpaddress")){
        	user.setClassification_id(1);
        }if(radio == null || Objects.equals(radio ,"tmpaddress")){
        	user.setUser_name(request.getParameter("familyname") + request.getParameter("firstname"));
        	user.setUser_post_code(Integer.parseInt(request.getParameter("zip31") + request.getParameter("zip32")));
        	String tmp1 = request.getParameter("pref31");
        	String tmp2 = request.getParameter("addr31");
        	String tmp3 = request.getParameter("addr32");
        	String tmp4 = request.getParameter("addr33");
        	user.setUser_address(tmp1 + tmp2 + tmp3 + tmp4);
        	user.setUser_phone_number(Integer.parseInt(request.getParameter("phone")));
        }else {
        	LoginInfo userinfo = (LoginInfo) session.getAttribute("userInfo");
        	user.setUser_name(userinfo.getUser_name());
        	user.setUser_post_code(userinfo.getUser_post_code());
        	user.setUser_address(userinfo.getUser_address());
        	user.setUser_phone_number(userinfo.getUser_phone_number());
        	user.setUser_mail(userinfo.getUser_mail());
        	user.setClassification_id(1);
        }
        Delivery_method delivery_method = deliveryMethodDAO.findByMethod(Integer.parseInt(delivery_method_num));
        session.setAttribute("delivery_method", delivery_method);
        session.setAttribute("user_delivery", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp");
		dispatcher.forward(request, response);
	}

}
