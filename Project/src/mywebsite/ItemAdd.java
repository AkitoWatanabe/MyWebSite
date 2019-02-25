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
			int number = Integer.parseInt(request.getParameter("number"));
			//在庫に戻す処理
			int newNumber = 0;
			String nullCheck = request.getParameter("newNumber");
			if(nullCheck != null) {
				newNumber = Integer.parseInt(nullCheck);
				number = newNumber - number;
			}
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("item_id"));
			//対象のアイテム情報を取得
			Item Item = ItemDAO.getItemByItemID(id);
			//カートに入れた時点で表示在庫を減らす
			ItemDAO.setItemSurfaceStock((-1*number),id);

			//追加した商品を表示するためリクエストパラメーターにセット
			request.setAttribute("item", Item);

			//カートを取得
			ArrayList<CartBeans> cart = (ArrayList<CartBeans>) session.getAttribute("cart");
			CartBeans cartbeans = new CartBeans();
			int index = -1;

			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<CartBeans>();
			}
			//同じ商品がカートに存在しないか検索
			System.out.println(cart.size());
			for(int i = 0; i < cart.size(); i++) {
				if(cart.get(i).getItem().getItem_id() == id) {
					index = i;
				}
				System.out.println(i);
			}
			if(index != -1) {
				//個数のみ追加
				number += cart.get(index).getNumber();
				cartbeans.setItem(Item);
				cartbeans.setNumber(number);
				cart.set(index, cartbeans);
			}else {
				//カートに商品を追加。
				cartbeans.setItem(Item);
				cartbeans.setNumber(number);
				cart.add(cartbeans);
			}
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
