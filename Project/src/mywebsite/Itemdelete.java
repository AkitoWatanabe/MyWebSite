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
import dao.ItemDAO;

/**
 * Servlet implementation class Itemdelete
 */
@WebServlet("/Itemdelete")
public class Itemdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Itemdelete() {
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
		int id = Integer.parseInt(request.getParameter("item_id"));
		int number = Integer.parseInt(request.getParameter("number"));
		//カートを取得
		ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
		CartBeans cartbeans = new CartBeans();
		int index = -1;

		//セッションにカートがない場合topへフォワード
		if (cart == null) {
			request.getRequestDispatcher("Toppage").forward(request, response);
			return;
		}
		//同じ商品がカートに存在するか検索
		System.out.println(cart.size());
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getItem().getItem_id() == id) {
				index = i;
			}
		}
		cart.remove(index);
		//カートから在庫に戻す
		ItemDAO.setItemSurfaceStock(number,id);
		request.getRequestDispatcher("Cart").forward(request, response);

	}

}
