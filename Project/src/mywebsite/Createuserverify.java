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
import dao.UserDAO;

/**
 * Servlet implementation class Createuserverify
 */
@WebServlet("/Createuserverify")
public class Createuserverify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createuserverify() {
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
		String userName = request.getParameter("userName");
		String tempzip = request.getParameter("zipCode");
		int zipCode = Integer.parseInt(tempzip);
		String address = request.getParameter("address");
		String tempphone = request.getParameter("phone");
		int phone = Integer.parseInt(tempphone);

		//暗号化処理
		Encryption encryption = new Encryption();
		password = encryption.getEncryption(password);

		UserDAO userDAO = new UserDAO();
		userDAO.setUserdata(userIdName,mail,password,userName,zipCode,address,phone);
		//ついでにログイン処理を済ませる
		LoginInfo user = userDAO.findByLoginInfo(userIdName, password);
		// セッションにユーザの情報をセット
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);

		response.sendRedirect("Toppage");
	}

}
