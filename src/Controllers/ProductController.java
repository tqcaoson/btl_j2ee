package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Models.Product;
import Models.dbConnects;

@WebServlet(urlPatterns= {
		"/update-product/*", 
		"/new-product",
		"/insert-product",
		"/edit-product",
		"/list-product",
		"/find-product",
		"/delete-product"})
public class ProductController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private dbConnects productDAO;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String  url = "jdbc:mysql://localhost:3306/quan_ly_kho";
		String userName="root";
		String pass="";
		productDAO=new dbConnects(url,userName,pass);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert-product":	
				insertProduct(request,response);
				break;
			case "/new-product":
				newForm(request, response);
				break;
			case "/update-product":
				uppdateProduct(request,response);
				break;
			case "/edit-product":
				editForm(request,response);
				break;
			case "/delete-product":
				deleteProduct(request,response);
				break;
			case "/find-product":
				findName(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/ProductForm.jsp");
		dispatcher.forward(request, response);
	}
	private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
		int id_product = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.getProduct(id_product);
		request.setAttribute("product",product);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Views/ProductForm.jsp");
		dispatcher.forward(request, response);

	}
	private void uppdateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{


			int id=Integer.parseInt(request.getParameter("id"));
			String nameProduct=request.getParameter("product_name");
			String code=request.getParameter("code");
			int number = Integer.parseInt(request.getParameter("number"));
			int priceInt = Integer.parseInt(request.getParameter("price_int"));
			int priceout = Integer.parseInt(request.getParameter("price_out"));
			
			Product product=new Product(id, nameProduct, code, number, priceInt, priceout);
			productDAO.updateProduct(product);
			response.sendRedirect("list-product");
	
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			String nameProduct=request.getParameter("product_name");
			String code=request.getParameter("code");
			int number = Integer.parseInt(request.getParameter("number"));
			int priceInt = Integer.parseInt(request.getParameter("price_int"));
			int priceout = Integer.parseInt(request.getParameter("price_out"));
			Product product=new Product(nameProduct, code, number, priceInt, priceout);
			productDAO.insertProduct(product);
			response.sendRedirect("list-product");
		
	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));		
		Product product=new Product(id);
		productDAO.deleteProduct(product);
		response.sendRedirect("list-product");
	}
	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		List<Product> listproduct=productDAO.getAllProduct();
		request.setAttribute("listProduct",listproduct);
		RequestDispatcher dispatcher= request.getRequestDispatcher("Views/ListProduct.jsp");
		dispatcher.forward(request, response);
	}
	private void findName(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		String nameProduct = request.getParameter("nameproduct");
		try {
			List<Product> list = productDAO.getProductByName(nameProduct);
			request.setAttribute("listProduct",list);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("Views/ListProduct.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

