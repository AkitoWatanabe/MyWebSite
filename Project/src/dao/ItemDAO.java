package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import base.DBManager;
import beans.Item;

public class ItemDAO {
	//新規商品登録
	public void setNewItem(String filename, String itemname, String itemdetail, int price, int sale_price,
	String sale_start, String sale_end, int stock, String unit, int stock_arart, int seller_id) {
	Connection conn = null;
		try {
	    // データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			StringJoiner joiner1 = new StringJoiner(",","insert into item (item_name,item_price",",surface_stock,real_stock,stock_arart,unit,seller_id,item_detail,file_name)");
			StringJoiner joiner2 = new StringJoiner(",","values(?,?",",?,?,?,?,?,?,?);");
			joiner1.setEmptyValue("insert into item (item_name,item_price,surface_stock,real_stock,stock_arart,unit,seller_id,item_detail,file_name)");
	        joiner2.setEmptyValue("values(?,?,?,?,?,?,?,?,?);");
	        if(sale_price != -1) {
	        	joiner1.add(",sale_price,sale_start,sale_end");
	        	joiner2.add(",?,cast(? as datetime),cast(? as datetime)");
	        }
	        String sql = joiner1.toString() + joiner2.toString();

	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, itemname);
	        pstmt.setInt(2,price);
	        if(sale_price != -1) {
	        	pstmt.setInt(3, sale_price);
	        	pstmt.setString(4, sale_start);
	        	pstmt.setString(5, sale_end);
	        	pstmt.setInt(6, stock);
	        	pstmt.setInt(7, stock);
	        	pstmt.setInt(8,stock_arart);
	        	pstmt.setString(9, unit);
	        	pstmt.setInt(10, seller_id);
	        	pstmt.setString(11, itemdetail);
	        	pstmt.setString(12, filename);
	        }else {
	        	pstmt.setInt(3, stock);
	        	pstmt.setInt(4, stock);
	        	pstmt.setInt(5,stock_arart);
	        	pstmt.setString(6, unit);
	        	pstmt.setInt(7, seller_id);
	        	pstmt.setString(8, itemdetail);
	        	pstmt.setString(9, filename);
	        }
	        System.out.println(sql);
	        System.out.println(pstmt);
	        pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	//アイテムIDによるアイテム検索
	public static Item getItemByItemID(int id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM item inner join seller on item.seller_id = seller.id WHERE item_id = ?;");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			Item item = new Item();
			if (rs.next()) {
				item.setItem_id(rs.getInt("item_id"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_price(rs.getInt("item_price"));
				item.setSale_price(rs.getInt("sale_price"));
				item.setSale_start(rs.getString("sale_start"));
				item.setSale_end(rs.getString("sale_end"));
				item.setSurface_stock(rs.getInt("surface_stock"));
				item.setReal_stock(rs.getInt("real_stock"));
				item.setStock_arart(rs.getInt("stock_arart"));
				item.setUnit(rs.getString("unit"));
				item.setSeller_id(rs.getInt("seller_id"));
				item.setItem_detail(rs.getString("item_detail"));
				item.setFile_name(rs.getString("file_name"));
				item.setId_name(rs.getString("id_name"));
			}

			return item;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	//sellerのidによる登録商品一覧表示
	public List<Item> findItemListBySellerId(int id) {
		Connection con = null;
		PreparedStatement st = null;
        List<Item> itemList = new ArrayList<Item>();

        try {
            // データベースへ接続
            con = DBManager.getConnection();

            // SELECT文を準備
            st = con.prepareStatement("SELECT * FROM item inner join seller on item.seller_id = seller.id WHERE id = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();


            // 結果表に格納されたレコードの内容を
            // itemインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
            	int item_id = rs.getInt("item_id");
                String file_name = rs.getString("file_name");
                String item_name = rs.getString("item_name");
                int surface_stock = rs.getInt("surface_stock");
                int real_stock = rs.getInt("real_stock");
                int item_price = rs.getInt("item_price");
                int sale_price = rs.getInt("sale_price");
                String sale_start = rs.getString("sale_start");
                String sale_end = rs.getString("sale_end");
                String unit = rs.getString("unit");
                String item_detail =rs.getString("item_detail");
                String id_name = rs.getString("id_name");
                int stock_arart = rs.getInt("stock_arart");
                int seller_id = rs.getInt("seller_id");
                Item item = new Item(item_id, file_name, item_name, surface_stock, real_stock, item_price, sale_price, sale_start, sale_end, unit, item_detail, id_name, stock_arart, seller_id);

                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return itemList;
    }
	//アイテムidによる商品情報の書き換え
	public void updateItem(String file_name, String item_name, String item_detail, int item_price, int sale_price,
			String sale_start, String sale_end, int add_stock, String unit, int stock_arart, int item_id) {
		Connection conn = null;
		try {
	    // データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			StringJoiner joiner1 = new StringJoiner(",","update item set ","where item_id = ? ;");
			joiner1.setEmptyValue("");
			int i = 1;
			if(item_price !=0) {
				joiner1.add("item_price = ?");
				//i+=3;
			}
	        if(sale_price != 0) {
	        	joiner1.add("sale_price = ?,sale_start = ?,sale_end = ?");
	        	//i+=3;
	        }
	        if(item_name != null) {
	        	joiner1.add("item_name = ?");
	        	//i+=1;
	        }
	        if(add_stock != 0) {
	        	joiner1.add("surface_stock = surface_stock + ? ,real_stock = real_stock + ?");
	        	//i+=2;
	        }
	        if(unit != null) {
	        	joiner1.add("unit = ?");
	        	//i+=1;
	        }
	        if(item_detail != null) {
	        	joiner1.add("item_detail = ?");
	        	//i+=1;
	        }
	        if(!(file_name.isEmpty())) {
	        	joiner1.add("file_name = ?");
	        	//i+=1;
	        }

	        String sql = joiner1.toString();

	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        if(item_price !=0) {
	        	pstmt.setInt(i,item_price);
	        	i++;
	        }
	        if(sale_price !=0) {
	        	pstmt.setInt(i, sale_price);
	        	pstmt.setString(++i, sale_start);
	        	pstmt.setString(++i, sale_end);
	        	i++;
	        }
	        if(item_name != null) {
	        	pstmt.setString(i,item_name);
	        	i++;
	        }
	        if(add_stock !=0) {
	        	pstmt.setInt(i, add_stock);
	        	pstmt.setInt(++i, add_stock);
	        	i++;
	        }
	        if(unit != null) {
	        	pstmt.setString(i, unit);
	        	i++;
	        }
	        if(item_detail != null) {
	        	pstmt.setString(i, item_detail);
	        	i++;
	        }
	        if(!(file_name.isEmpty())) {
	        	pstmt.setString(i, file_name);
	        	i++;
	        }
	        pstmt.setInt(i, item_id);

	        System.out.println(sql);
	        System.out.println(pstmt);
	        pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//商品検索
	public static ArrayList<Item> getItemsByItemName(String searchWord, int pageNum, int pageMaxItemCount) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			int startiItemNum = (pageNum - 1) * pageMaxItemCount;
			con = DBManager.getConnection();

			if (searchWord.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM item inner join seller on item.seller_id = seller.id ORDER BY id ASC LIMIT ?,? ");
				st.setInt(1, startiItemNum);
				st.setInt(2, pageMaxItemCount);
			} else {
				// 商品名検索
				st = con.prepareStatement("SELECT * FROM item inner join seller on item.seller_id = seller.id WHERE item_name LIKE ?  ORDER BY item_id ASC LIMIT ?,? ");
				st.setString(1,"%" + searchWord +"%");
				st.setInt(2, startiItemNum);
				st.setInt(3, pageMaxItemCount);
			}

			ResultSet rs = st.executeQuery();
			ArrayList<Item> itemList = new ArrayList<Item>();

			while (rs.next()) {
				Item item = new Item();
				item.setItem_id(rs.getInt("item_id"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_detail(rs.getString("item_detail"));
				item.setItem_price(rs.getInt("item_price"));
				item.setFile_name(rs.getString("file_name"));
				item.setId_name(rs.getString("id_name"));
				item.setSale_price(rs.getInt("sale_price"));
				item.setSale_start(rs.getString("sale_start"));
				item.setSale_end(rs.getString("sale_end"));
				itemList.add(item);
			}
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	public static double getItemCount(String searchWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("select count(*) as cnt from item where item_name like ?");
			st.setString(1, "%" + searchWord + "%");
			ResultSet rs = st.executeQuery();
			double coung = 0.0;
			while (rs.next()) {
				coung = Double.parseDouble(rs.getString("cnt"));
			}
			return coung;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	//表示在庫の増減
	public static void setItemSurfaceStock(int number, int id) {
		Connection conn = null;
		try {
	    // データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
				        String sql = "update item set surface_stock = surface_stock + ? where item_id = ?";

	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        	pstmt.setInt(1,number);
	        	pstmt.setInt(2,id);

	        System.out.println(sql);
	        System.out.println(pstmt);
	        pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
