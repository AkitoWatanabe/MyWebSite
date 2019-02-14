package mywebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Seller;
import dao.SellerDAO;

/**
 * Servlet implementation class Createsellerverify
 */
@WebServlet("/Createsellerverify")
public class Createsellerverify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createsellerverify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createseller.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String sellerIdName = request.getParameter("sellerIdName");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String sellerName = request.getParameter("sellerName");
		String tempzip = request.getParameter("zipCode");
		int zipCode = Integer.parseInt(tempzip);
		String address = request.getParameter("address");
		String tempphone = request.getParameter("phone");
		int phone = Integer.parseInt(tempphone);

		//暗号化処理
		Encryption encryption = new Encryption();
		password = encryption.getEncryption(password);

		SellerDAO sellerDAO = new SellerDAO();
		sellerDAO.setSellerdata(sellerIdName,mail,password,sellerName,zipCode,address,phone);
		//ついでにログイン処理を済ませる
        int classificationId = 3;
        Seller seller = new Seller(sellerIdName, classificationId);
		request.setAttribute("seller_id_name", sellerIdName);
		request.setAttribute("password", password);
		// セッションにユーザの情報をセット
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", seller);

		response.sendRedirect("Toppage");
	}

}
