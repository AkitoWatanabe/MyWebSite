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
import beans.Item;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAdd() {
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

		try {
			//購入個数を取得
			int number = -1*(Integer.parseInt(request.getParameter("number")));
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("item_id"));
			//対象のアイテム情報を取得
			Item item = ItemDAO.getItemByItemID(id);
			//カートに入れた時点で表示在庫を減らす
			ItemDAO.setItemSurfaceStock(number,id);

			//追加した商品を表示するためリクエストパラメーターにセット
			request.setAttribute("item", item);

			//カートを取得
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
			CartBeans cartbeans = new CartBeans();

			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<CartBeans>();
			}
			//同じ商品がカートに存在しないか検索
			if(cart.indexOf(item) != 0) {
				//個数のみ追加
				int tmp = cartbeans.getNumber() + number;
				cartbeans.setNumber(tmp);
			}else {
				//カートに商品を追加。
				cartbeans.setItem(item);
			}

			cart.add();
			//カート情報更新
			session.setAttribute("cart", cart);
			request.setAttribute("cartActionMessage", "商品を追加しました");
			request.getRequestDispatcher("Itemdetail?item_id="+ id).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
