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
	    			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    			java.sql.Date date = java.sql.Date.valueOf(formatter.format(im.getDate_in()));
					prstatement.setDate(4, date);
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
	    		String sql = "update import_product set code=?, code_sp=?, price_in=?, date_in=? where id=?";
	    		openConnection();
	    		PreparedStatement pr = con.prepareStatement(sql);
	    		pr.setString(1, product.getCode());
	    		pr.setString(2, product.getCode_sp());
	    		pr.setInt(3, product.getPrice_in());
	    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    			java.sql.Date date = java.sql.Date.valueOf(formatter.format(product.getDate_in()));
	    		pr.setDate(4, date);
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
	    	
	    	public boolean insertExportProduct(Export_Product im) throws SQLException {
	    		openConnection();
	    		String sql = "insert into export_product (code, code_sp, price_out, date_out) value (?, ?, ?, ?)";
	    		PreparedStatement prstatement = con.prepareStatement(sql);
	    		prstatement.setString(1, im.getCode());
	    		prstatement.setString(2, im.getCode_sp());
	    		prstatement.setInt(3, im.getPrice_out());
	    		boolean insertrow = false;
	    		try {
	    			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    			java.sql.Date date = java.sql.Date.valueOf(formatter.format(im.getDate_out()));
					prstatement.setDate(4, date);
					insertrow = prstatement.executeUpdate() > 0;
		    		prstatement.close();
		    		con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	    		}
	    		return insertrow;
	    	}

	    	public List<Export_Product> getAllExportProduct() throws SQLException {
	    		String sql = "select * from export_product";
	    		
	    		List list = new ArrayList<>();
	    		openConnection();
	    		Statement statement = con.createStatement();
	    		ResultSet rs = statement.executeQuery(sql);
	    		while (rs.next()) {
	    			int id = rs.getInt("id");
	    			String code = rs.getString(2);
	    			String code_sp = rs.getString(3);
	    			int price_out = rs.getInt(4);
	    			Date date_out = rs.getDate(5);
	    			
	    			Export_Product product = new Export_Product(id, code, code_sp, price_out, date_out);
	    			list.add(product);
	    		}
	    		rs.close();
	    		statement.close();
	    		con.close();
	    		return list;
	    	}

	    	public boolean updateExportProduct( Export_Product product) throws SQLException {
	    		String sql = "update export_product set code=?, code_sp=?, price_out=?, date_out=? where id=?";
	    		openConnection();
	    		PreparedStatement pr = con.prepareStatement(sql);
	    		pr.setString(1, product.getCode());
	    		pr.setString(2, product.getCode_sp());
	    		pr.setInt(3, product.getPrice_out());
	    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    			java.sql.Date date = java.sql.Date.valueOf(formatter.format(product.getDate_out()));
	    		pr.setDate(4, date);
	    		pr.setInt(5, product.getID());
	    		boolean updateok = pr.executeUpdate() > 0;
	    		pr.close();
	    		con.close();
	    		return updateok;
	    	}

	    	public boolean deleteExportProduct( Export_Product product) throws SQLException {
	    		String sql = "delete from export_product where id=?";
	    		openConnection();
	    		PreparedStatement pr = con.prepareStatement(sql);
	    		pr.setInt(1, product.getID());
	    		boolean deleteok = pr.execute();
	    		pr.close();
	    		con.close();
	    		return deleteok;

	    	}
	    	public  Export_Product getExportProduct(int id) throws SQLException {
	    		openConnection();
	    		Export_Product product = null;
	    		String sql="select * from export_product where id=?";
	    		PreparedStatement pr =con.prepareStatement(sql);
	    		pr.setInt(1,id);
	    		ResultSet rs=pr.executeQuery();
	    		while(rs.next()) {
	    			String code = rs.getString(2);
	    			String code_sp = rs.getString(3);
	    			int price_out = rs.getInt(4);
	    			Date date_out = rs.getDate(5);
	    			product = new Export_Product(id, code, code_sp, price_out, date_out);
	    		}
	    		return product;
	    		
	    	
		}
		public boolean insertProduct(Product product) throws SQLException {
		openConnection();
		String sql = "insert into products (product_name, code, number, price_int, price_out) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement prstatement =  con.prepareStatement(sql);
		prstatement.setString(1, product.getProductName());
		prstatement.setString(2, product.getCode());
		prstatement.setInt(4, product.getNumber());
		prstatement.setInt(5, product.getPriceInt());
		prstatement.setInt(6, product.getPriceOut());
		boolean insertrow = prstatement.executeUpdate() > 0;
		prstatement.close();
		con.close();
		return insertrow;
	}

	public List<Product> getAllProduct() throws SQLException {
		String sql = "select * from products";
		List<Product> list = new ArrayList<>();
		openConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String nameProduct = rs.getString("product_name");
			String code = rs.getString("code");
			int number = rs.getInt("number");
			int priceInt = rs.getInt("price_int");
			int priceOut = rs.getInt("price_out");
			Product product = new Product(id, nameProduct, code, number, priceInt, priceOut);
			list.add(product);
		}
		rs.close();
		statement.close();
		con.close();
		return list;
	}

	public boolean updateProduct( Product product) throws SQLException {
		String sql = "update products set product_name=?, code=?, number=?, price_int=?, price_out=? where id=?";
		openConnection();
		PreparedStatement pr =  con.prepareStatement(sql);
		pr.setString(1, product.getProductName());
		pr.setString(2, product.getCode());
		pr.setInt(4, product.getNumber());
		pr.setInt(5, product.getPriceInt());
		pr.setInt(6, product.getPriceOut());
		pr.setInt(7, product.getId());
		boolean updateok = pr.executeUpdate() > 0;
		pr.close();
		con.close();
		return updateok;
	}

	public boolean deleteProduct( Product product) throws SQLException {
		String sql = "delete from products where id=?";
		openConnection();
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(1, product.getId());
		boolean deleteok = pr.execute();
		pr.close();
		con.close();
		return deleteok;

	}
	public  Product getProduct(int id) throws SQLException {
		openConnection();
		Product product=null;
		String sql="select * from products where id=?";
		PreparedStatement pr =con.prepareStatement(sql);
		pr.setInt(1,id);
		ResultSet rs=pr.executeQuery();
		while(rs.next()) {
			String nameProduct = rs.getString("product_name");
			String code = rs.getString("code");
			int number = rs.getInt("number");
			int priceInt = rs.getInt("price_int");
			int priceOut = rs.getInt("price_out");
			product=new Product(id, nameProduct, code, number, priceInt, priceOut);
		}
		return product;

	}
	public List<Product> getProductByName(String name) throws SQLException {
		List<Product> list = new ArrayList<>();
		openConnection();
		String sql = "select * from products where product_name like ?";
		PreparedStatement pr =con.prepareStatement(sql);
		pr.setString(1, "%"+name+"%");

		ResultSet rs=pr.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nameProduct = rs.getString("product_name");
			String code = rs.getString("code");
			int number = rs.getInt("number");
			int priceInt = rs.getInt("price_int");
			int priceOut = rs.getInt("price_out");
			Product product = new Product(id, nameProduct, code, number, priceInt, priceOut);
			list.add(product);
		}
		rs.close();
		pr.close();
		con.close();
		return list;
	}

	    	public static void main(String[] args) {
	    		// TODO Auto-generated method stub

	    	}
}
