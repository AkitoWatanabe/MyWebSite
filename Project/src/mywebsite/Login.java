package mywebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 request.setCharacterEncoding("UTF-8");

	        String loginId = request.getParameter("user_id_name");
			String password = request.getParameter("password");
			//入力されたパスワードの暗号化
			//Encryption encryption = new Encryption();
			//password = encryption.getEncryption(password);

			UserDAO userDAO = new UserDAO();
			User user = userDAO.findByLoginInfo(loginId, password);

				if (user == null) {
					// リクエストスコープにエラーメッセージをセット
					request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

					// ログインjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
					return;
				}

			/** テーブルに該当のデータが見つかった場合 **/
			// セッションにユーザの情報をセット
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			//ログイン画面を開いたページのアドレスを取得
			String url = request.getParameter("url");
			//取得したアドレスを実際のサーブレットに加工
			System.out.println(url);
			//ログイン画面を開いたページにリダイレクト
			response.sendRedirect("Toppage");
	}

}
