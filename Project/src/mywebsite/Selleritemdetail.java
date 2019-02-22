package mywebsite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
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

import beans.Item;
import beans.LoginInfo;
import dao.ItemDAO;

/**
 * Servlet implementation class Selleritemdetail
 */
@WebServlet("/Selleritemdetail")
@MultipartConfig(
	    location="C:/Users/LIKEIT_STUDENT/Documents/GitHub/MyWebSite/Project/WebContent/WEB-INF/uploaded", // ディレクトリパスを指定することも出来る (しなくても良い)
	    fileSizeThreshold=32768,
	    maxFileSize=5242880,
	    maxRequestSize=27262976
	)
public class Selleritemdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selleritemdetail() {
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
			try {
				//選択された商品のIDを型変換し利用
				int id = Integer.parseInt(request.getParameter("item_id"));
				//戻るページ表示用
				//int pageNum = Integer.parseInt(request.getParameter("page_num")==null?"1":request.getParameter("page_num"));
				//対象のアイテム情報を取得
				Item item = ItemDAO.getItemByItemID(id);
				//割引は任意
				if(item.getSale_price() != 0) {
					//割引項目の日時を日付と時間で分割
					String datetime = item.getSale_start();

					String[] split = datetime.split(" ");
					String sale_start_date = split[0];
					String sale_start_time = split[1].trim();

					datetime = item.getSale_end();
					split = datetime.split(" ");
					String sale_end_date = split[0];
					String sale_end_time = split[1];

					request.setAttribute("sale_start_date", sale_start_date);
					request.setAttribute("sale_start_time", sale_start_time);
					request.setAttribute("sale_end_date", sale_end_date);
					request.setAttribute("sale_end_time", sale_end_time);
				}
				//リクエストパラメーターにセット
				request.setAttribute("item", item);

				//request.setAttribute("pageNum", pageNum);

				//request.getRequestDispatcher("/WEB-INF/jsp/itemdetail.jsp").forward(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selleritemdetail.jsp");
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("Toppage");
			}
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
		int price = -1;
		int sale_price = 0;
		String sale_start_date = null;
		String sale_start_time = null;
		String sale_start = null;
		String sale_end_date = null;
		String sale_end_time = null;
		String sale_end = null;
		int surface_stock = -1;
		int real_stock = -1;
		int add_stock = 0;
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
                    //バッファは一度呼び出されると次へ行く
                    //System.out.println("パラメータ"+bufReader.lines().collect(Collectors.joining()));
                    map.put(part.getName(), bufReader.lines().collect(Collectors.joining()));
                    System.out.println("check");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
            	map.put(part.getName(),this.getFileName(part));
            	if(!(map.get("img").isEmpty())) {
	                try {
						part.write("C:/pleiades/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MyWebSite/img" + "/" + this.getFileName(part));
					} catch (IOException e) {
						e.printStackTrace();
					}
            	}
            }
        });

        filename = map.get("img");
        itemname = map.get("itemname");
		itemdetail = map.get("itemdetail");
		price = Integer.parseInt(map.get("price"));
		String tmp = map.get("sale_price");
		//未入力は空文字なので0を代入
		if(tmp.isEmpty()) {
			tmp = "0";
		}
		sale_price = Integer.parseInt(tmp);
		sale_start_date = map.get("sale_start_date");
		sale_start_time = map.get("sale_start_time");
		sale_end_date = map.get("sale_end_date");
		sale_end_time = map.get("sale_end_time");
		surface_stock = Integer.parseInt(map.get("surface_stock"));
		real_stock = Integer.parseInt(map.get("real_stock"));
		add_stock = Integer.parseInt(map.get("add_stock"));
		unit = map.get("unit");
		stock_arart = Integer.parseInt(map.get("stock_arart"));
		//割引項目に漏れがある場合（全て空の場合は除く）
		if(!((sale_price != 0 && sale_start_date.isEmpty() == false && sale_start_time.isEmpty() == false && sale_end_date.isEmpty() == false && sale_end_time.isEmpty() == false)||(sale_price == 0 && sale_start_date.isEmpty() && sale_start_time.isEmpty() && sale_end_date.isEmpty() && sale_end_time.isEmpty()))) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "割引を設定する場合は全て入力して下さい");

			Item item = new Item();
			item.setFile_name(filename);
			item.setItem_name(itemname);
			item.setItem_detail(itemdetail);
			item.setItem_price(price);
			item.setSale_price(sale_price);
			request.setAttribute("sale_start_date",sale_start_date);
			request.setAttribute("sale_start_time",sale_start_time);
			request.setAttribute("sale_end_date",sale_end_date);
			request.setAttribute("sale_end_time",sale_end_time);
			request.setAttribute("add_stock",add_stock);
			item.setSurface_stock(surface_stock);
			item.setReal_stock(real_stock);;
			item.setUnit(unit);
			item.setStock_arart(stock_arart);

			request.setAttribute("item",item);
			// 商品情報更新ページにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/selleritemdetail.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//割引は任意項目
		if(sale_price != -1) {
			//sale_start_time += ":00";
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			sale_start = sale_start_date +" "+ sale_start_time;
			System.out.println(tmp);
				//sale_start = Date.valueOf(tmp);//sdf.parse(tmp);
			//sale_end_time += ":00";
			sale_end = sale_end_date +" "+ sale_end_time;
				//sale_end = Date.valueOf(tmp);//sdf.parse(tmp);
		}

		HttpSession session = request.getSession();
		LoginInfo sessionTmp = (LoginInfo) session.getAttribute("userInfo");
		int sellerId = sessionTmp.getId();
		System.out.println(sellerId);
		ItemDAO itemDAO = new ItemDAO();
		int id = Integer.parseInt(request.getParameter("item_id"));
		itemDAO.updateItem(filename,itemname,itemdetail,price,sale_price,sale_start,sale_end,add_stock,unit,stock_arart,id);
		response.sendRedirect("Toppage");

			//ファイルアップロードを同時に行う(multi-part)とgetparameterで取れなくなる
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
