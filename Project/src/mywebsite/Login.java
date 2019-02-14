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
import beans.User;
import dao.SellerDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//ログイン画面を開いたページのアドレスを取得
		//String url = request.getParameter("url");
		//HttpSession session = request.getSession();
		//System.out.println(url);
		//session.setAttribute("url", url);
		// ログインセッションがある場合、トップ画面にリダイレクトさせる
		HttpSession session = request.getSession();
		User checkSession = (User)session.getAttribute("userInfo");
		if(checkSession == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toppage.jsp");
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

	        String userIdName = request.getParameter("user_id_name");
			String password = request.getParameter("password");
			//ログイン画面を開いたページのアドレスを取得
			//String url = request.getParameter("url");//getServletPath();
			//入力されたパスワードの暗号化(新規登録実装後に解除)
			Encryption encryption = new Encryption();
			password = encryption.getEncryption(password);

			UserDAO userDAO = new UserDAO();
			User user = userDAO.findByLoginInfo(userIdName, password);
			SellerDAO sellerDAO = new SellerDAO();
			Seller seller = sellerDAO.findByLoginInfo(userIdName, password);
			System.out.println(user);
			System.out.println(seller);

				if (user == null && seller == null) {
					// リクエストスコープにエラーメッセージをセット
					request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

					// ログインjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
					return;
				}
				/** テーブルに該当のデータが見つかった場合 **/
				if(user != null) {
					// セッションにユーザの情報をセット
					HttpSession session = request.getSession();
					session.setAttribute("userInfo", user);
					System.out.println(user.getUser_id_name());
					System.out.println(user.getClassification_id());
					//ログイン画面を開いたページにリダイレクト(未実装)
					response.sendRedirect("Toppage");
				}else if(seller != null) {
					// セッションにユーザの情報をセット
					HttpSession session = request.getSession();
					session.setAttribute("userInfo", seller);
					System.out.println(seller.getSeller_id_name());
					System.out.println(seller.getClassification_id());
					//ログイン画面を開いたページにリダイレクト(未実装)
					response.sendRedirect("Toppage");
				}
	}
}
