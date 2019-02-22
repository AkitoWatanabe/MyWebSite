package mywebsite;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Item;
import beans.LoginInfo;
import dao.ItemDAO;

/**
 * Servlet implementation class Seller
 */
@WebServlet("/Sellerpage")
public class Sellerpage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sellerpage() {
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
			ItemDAO itemDAO = new ItemDAO();
			List<Item> itemList = itemDAO.findItemListBySellerId(checkSession.getId());
			//割引期間か判定をしてフラグを配列に詰める(未実装)
			/*for(Item num : itemList) {
				String sale_start =num.getSale_start();
				String sale_end =num.getSale_end();
				if(sale_start != null) {
					Calendar cal_start = Calendar.getInstance();

					Calendar cal_end = Calendar.getInstance();
				}
			}*/
			// リクエストスコープに登録商品情報をセット
			request.setAttribute("itemList", itemList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sellerpage.jsp");
	        dispatcher.forward(request, response);
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
