package mywebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfo;

/**
 * Servlet implementation class Newitem
 */
@WebServlet("/Newitem")
public class Newitem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newitem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// ログインセッションがない場合、トップ画面にリダイレクトさせる
				HttpSession session = request.getSession();
				LoginInfo checkSession = (LoginInfo)session.getAttribute("userInfo");
				if(checkSession == null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
					dispatcher.forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newitem.jsp");

			        dispatcher.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
			//ファイルアップロードを同時に行うとgetparameterで取れなくなる
			/*
			String img = request.getParameter("img");
			String itemName = request.getParameter("itemname");
			String itemDetail = request.getParameter("itemdetail");
			String price = request.getParameter("price");
			String salePrice = request.getParameter("sale_price");
			String saleStartDate = request.getParameter("sale_start_date");
			String saleStartTime = request.getParameter("sale_start_time");
			String saleEndDate = request.getParameter("sale_end_date");
			String saleEndTime = request.getParameter("sale_end_time");
			String stock = request.getParameter("stock");
			String unit = request.getParameter("unit");
			String stockArart = request.getParameter("stock_arart");
			*/


	}

}
