package mywebsite;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;
import dao.ItemDAO;

/**
 * Servlet implementation class itemsearchresult
 */
@WebServlet("/Itemsearchresult")
public class Itemsearchresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//1ページに表示する商品数
		final static int PAGE_MAX_ITEM_COUNT = 4;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Itemsearchresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		try {
			String searchWord = request.getParameter("search_word");
			//表示ページ番号 未指定の場合 1ページ目を表示
			int pageNum = Integer.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
			// 新たに検索されたキーワードをセッションに格納する
			session.setAttribute("search_word", searchWord);

			// 商品リストを取得 ページ表示分のみ
			ArrayList<Item> searchResultItemList = ItemDAO.getItemsByItemName(searchWord, pageNum, PAGE_MAX_ITEM_COUNT);

			// 検索ワードに対しての総ページ数を取得
			double itemCount = ItemDAO.getItemCount(searchWord);
			int pageMax = (int) Math.ceil(itemCount / PAGE_MAX_ITEM_COUNT);

			//総アイテム数
			request.setAttribute("itemCount", (int) itemCount);
			// 総ページ数
			request.setAttribute("pageMax", pageMax);
			// 表示ページ
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("itemList", searchResultItemList);

			request.getRequestDispatcher("/WEB-INF/jsp/itemsearchresult.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
