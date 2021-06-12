package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class dbConnects {
	    	private String url;
	    	private String user;
	    	private String pass;
	    	Connection con = null;

			public dbConnects(String _url, String _user, String _pass) {
	    		url = _url;
	    		user = _user;
	    		pass = _pass;
	    	}

	    	public void  openConnection() throws SQLException {
	    		if (con == null || con.isClosed()) {
	    		try {
	    		
	    			Class.forName("com.mysql.jdbc.Driver");
	    			con = DriverManager.getConnection(url, user, pass);
	    			
	    		} catch(ClassNotFoundException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	}

	    	public void closeConnec() throws SQLException {
	    		if (con != null || !con.isClosed()) {
	    			con.close();
	    		}
	    	}

	    	public boolean insertImportProduct(Import_Product im) throws SQLException {
	    		openConnection();
	    		String sql = "insert into import_product (code, code_sp, price_in, date_in) value (?, ?, ?, ?)";
	    		PreparedStatement prstatement = con.prepareStatement(sql);
	    		prstatement.setString(1, im.getCode());
	    		prstatement.setString(2, im.getCode_sp());
	    		prstatement.setInt(3, im.getPrice_in());
	    		boolean insertrow = false;
	    		try {
					prstatement.setDate(4, (java.sql.Date)im.getDate_in());
					insertrow = prstatement.executeUpdate() > 0;
		    		prstatement.close();
		    		con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	    		}
	    		return insertrow;
	    	}

	    	public List<Import_Product> getAllImportProduct() throws SQLException {
	    		String sql = "select * from import_product";
	    		
	    		List list = new ArrayList<>();
	    		openConnection();
	    		Statement statement = con.createStatement();
	    		ResultSet rs = statement.executeQuery(sql);
	    		while (rs.next()) {
	    			int id = rs.getInt("id");
	    			String code = rs.getString(2);
	    			String code_sp = rs.getString(3);
	    			int price_in = rs.getInt(4);
	    			Date date_in = rs.getDate(5);
	    			
	    			Import_Product product = new Import_Product(id, code, code_sp, price_in, date_in);
	    			list.add(product);
	    		}
	    		rs.close();
	    		statement.close();
	    		con.close();
	    		return list;
	    	}

	    	public boolean updateImportProduct( Import_Product product) throws SQLException {
	    		String sql = "update import_product set code=?, code_sp=?, price_in=?, date_in=? where book_id=?";
	    		openConnection();
	    		PreparedStatement pr = con.prepareStatement(sql);
	    		pr.setString(1, product.getCode());
	    		pr.setString(2, product.getCode_sp());
	    		pr.setInt(3, product.getPrice_in());
	    		pr.setDate(4, (java.sql.Date)product.getDate_in());
	    		pr.setInt(5, product.getID());
	    		boolean updateok = pr.executeUpdate() > 0;
	    		pr.close();
	    		con.close();
	    		return updateok;
	    	}

	    	public boolean deleteImportProduct( Import_Product product) throws SQLException {
	    		String sql = "delete from import_product where id=?";
	    		openConnection();
	    		PreparedStatement pr = con.prepareStatement(sql);
	    		pr.setInt(1, product.getID());
	    		boolean deleteok = pr.execute();
	    		pr.close();
	    		con.close();
	    		return deleteok;

	    	}
	    	public  Import_Product getImportProduct(int id) throws SQLException {
	    		openConnection();
	    		Import_Product product = null;
	    		String sql="select * from import_product where id=?";
	    		PreparedStatement pr =con.prepareStatement(sql);
	    		pr.setInt(1,id);
	    		ResultSet rs=pr.executeQuery();
	    		while(rs.next()) {
	    			String code = rs.getString(2);
	    			String code_sp = rs.getString(3);
	    			int price_in = rs.getInt(4);
	    			Date date_in = rs.getDate(5);
	    			product = new Import_Product(id, code, code_sp, price_in, date_in);
	    		}
	    		return product;
	    		
	    	}

	    	public static void main(String[] args) {
	    		// TODO Auto-generated method stub

	    	}
}
