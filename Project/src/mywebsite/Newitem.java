package mywebsite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.LoginInfo;

/**
 * Servlet implementation class Newitem
 */
@WebServlet("/Newitem")
@MultipartConfig(
	    location="C:/Users/LIKEIT_STUDENT/Documents/GitHub/MyWebSite/Project/WebContent/WEB-INF/uploaded", // ディレクトリパスを指定することも出来る (しなくても良い)
	    fileSizeThreshold=32768,
	    maxFileSize=5242880,
	    maxRequestSize=27262976
	)
public class Newitem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newitem() {
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
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newitem.jsp");

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

		String filename = null;
		String itemname = null;
		String itemdetail = null;
		String tmp_price = null;
		int price = -1;
		int sale_price = -1;
		String sale_start_date = null;
		String sale_start_time = null;
		Date sale_start = null;
		String sale_end_date = null;
		String sale_end_time = null;
		Date sale_end = null;
		int stock = -1;
		String unit = null;
		int stock_arart = -1;

        Collection<Part> parts = request.getParts();
        Map<String,String> map = new HashMap<String,String>();

        parts.stream().forEach(part -> {
            System.out.println("name:" + part.getName());

            String contentType = part.getContentType();
            System.out.println("contentType:" + contentType);
            if ( contentType == null) {
                try(InputStream inputStream = part.getInputStream()) {
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
                    //System.out.println("パラメータ"+bufReader.lines().collect(Collectors.joining()));
                    map.put(part.getName(), bufReader.lines().collect(Collectors.joining()));
                    System.out.println("check");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
            	map.put(part.getName(),this.getFileName(part));
                try {
					part.write("C:/Users/LIKEIT_STUDENT/Documents/GitHub/MyWebSite/Project/WebContent/WEB-INF/uploaded" + "/" + this.getFileName(part));
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        filename = map.get("img");
        itemname = map.get("itemname");
		itemdetail = map.get("itemdetail");
		//price = Integer.parseInt(map.get("price"));
		//sale_price = Integer.parseInt(map.get("sale_price"));
		sale_start_date = map.get("sale_start_date");
		sale_start_time = map.get("sale_start_time");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		try {
			sale_start = sdf.parse(sale_start_date + sale_start_time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sale_end_date = map.get("sale_end_date");
		sale_end_time = map.get("sale_end_time");
		try {
			sale_end = sdf.parse(sale_end_date + sale_end_time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//stock = Integer.parseInt(map.get("stock"));
		unit = map.get("unit");
		//stock_arart = Integer.parseInt(map.get("stock_arart"));

		//System.out.println(filename+itemname+itemdetail+price+sale_price+sale_start+sale_end+stock+unit+stock_arart);
        response.sendRedirect("Toppage");

			//ファイルアップロードを同時に行うとgetparameterで取れなくなる
			/*
			String img = request.getParameter("img");
			String itemName = request.getParameter("itemname");
			String itemDetail = request.getParameter("itemdetail");
			String price = request.getParameter("price");
			String salePrice = request.getParameter("sale_price");
			String saleStartDate = request.getParameter("sale_start_date");
			String saleStartTime = request.getParameter("sale_start_time");
			String saleEndDate = request.getParameter("sale_end_date");
			String saleEndTime = request.getParameter("sale_end_time");
			String stock = request.getParameter("stock");
			String unit = request.getParameter("unit");
			String stockArart = request.getParameter("stock_arart");
			*/


	}
	//multi-partでpostされた画像名を取得するメソッド
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}
