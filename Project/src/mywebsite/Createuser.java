package mywebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class Createuser
 */
@WebServlet("/Createuser")
public class Createuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createuser.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String userIdName = request.getParameter("userIdName");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String spellCheck = request.getParameter("spellCheck");
		String familyName = request.getParameter("familyName");
		String firstName = request.getParameter("firstName");
		StringBuffer buf = new StringBuffer();
		buf.append(familyName);
		buf.append(firstName);
		String userName = buf.toString();
		String zip31 = request.getParameter("zip31");
		String zip32 = request.getParameter("zip32");
		buf.setLength(0);
		buf.append(zip31);
		buf.append(zip32);
		int zipCode = Integer.parseInt(buf.toString());
		String pref31 = request.getParameter("pref31");
		String addr31 = request.getParameter("addr31");
		String addr32 = request.getParameter("addr32");
		String addr33 = request.getParameter("addr33");
		buf.setLength(0);
		buf.append(pref31);
		buf.append(addr31);
		buf.append(addr32);
		buf.append(addr33);
		String phoneTemp = request.getParameter("phone");
		int phone = Integer.parseInt(phoneTemp);

		//パスワード確認
		if(!(password.equals(spellCheck))) {
			request.setAttribute("errMsg", "パスワードをもう一度入力して下さい");
			//入力内容をリクエストスコープにセット
			request.setAttribute("userIdName", userIdName);
			request.setAttribute("mail", mail);
			request.setAttribute("familyName", familyName);
			request.setAttribute("firstName", firstName);
			request.setAttribute("zip31", zip31);
			request.setAttribute("zip32", zip32);
			request.setAttribute("pref31", pref31);
			request.setAttribute("addr31", addr31);
			request.setAttribute("addr32", addr32);
			request.setAttribute("addr33", addr33);
			request.setAttribute("phone", phone);


			// createuser.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createuser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//ログインID被りチェック
		UserDAO userDAO = new UserDAO();
		String user = userDAO.findByLoginId(userIdName);

		if (user != null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力されたログインIDは既に存在します");
			//入力内容をリクエストスコープにセット
			request.setAttribute("userIdName", userIdName);
			request.setAttribute("mail", mail);
			request.setAttribute("familyName", familyName);
			request.setAttribute("firstName", firstName);
			request.setAttribute("zip31", zip31);
			request.setAttribute("zip32", zip32);
			request.setAttribute("pref31", pref31);
			request.setAttribute("addr31", addr31);
			request.setAttribute("addr32", addr32);
			request.setAttribute("addr33", addr33);
			request.setAttribute("phone", phone);

			// signupjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}

}
