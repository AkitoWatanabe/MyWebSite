package mywebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Item;
import dao.ItemDAO;

/**
 * Servlet implementation class Itemdetail
 */
@WebServlet("/Itemdetail")
public class Itemdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Itemdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("item_id"));
			//戻るページ表示用
			//int pageNum = Integer.parseInt(request.getParameter("page_num")==null?"1":request.getParameter("page_num"));
			//対象のアイテム情報を取得
			Item item = ItemDAO.getItemByItemID(id);
			//リクエストパラメーターにセット
			request.setAttribute("item", item);
			//request.setAttribute("pageNum", pageNum);

			//request.getRequestDispatcher("/WEB-INF/jsp/itemdetail.jsp").forward(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemdetail.jsp");
	        dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Toppage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
