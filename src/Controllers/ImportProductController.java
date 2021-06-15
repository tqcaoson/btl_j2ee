package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Import_Product;
import Models.dbConnects;

@WebServlet(urlPatterns= {
		"/update-import/*", 
		"/new-import",
		"/insert-import",
		"/edit-import",
		"/list-import",
		"/delete-import"})
public class ImportProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private dbConnects bd;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String  url = "jdbc:mysql://localhost:3306/quan_ly_kho";
		String userName="root";
		String pass = "";
		bd = new dbConnects(url,userName,pass);
	}
    

	public ImportProductController(){
		super();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
				case "/insert-import":	
					insertImportProduct(request,response);
					break;
				case "/new-import":
					newForm(request, response);
					break;
				case "/update-import":
					uppdateImportProduct(request,response);
					break;
				case "/edit-import":
					editForm(request,response);
					break;
				case "/delete-import":
					deleteImportProduct(request,response);
					break;
				default:
					listImportProduct(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/NewImportProduct.jsp");
		dispatcher.forward(request, response);
	}
	private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
		int id_product=Integer.parseInt(request.getParameter("ID"));
		Import_Product product = bd.getImportProduct(id_product);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Views/NewImportProduct.jsp");
		dispatcher.forward(request, response);		
	}
	private void uppdateImportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
		int id=Integer.parseInt(request.getParameter("ID"));
		String code=request.getParameter("code");
		String code_sp=request.getParameter("code_sp");
		int price=Integer.parseInt(request.getParameter("price_in"));
		Date date_in;
		try {
			date_in = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_in"));
			Import_Product product = new Import_Product(id, code, code_sp, price, date_in);
			bd.updateImportProduct(product);
			response.sendRedirect("list-import");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertImportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		//int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
		String code_sp=request.getParameter("code_sp");
		int price_in=Integer.parseInt(request.getParameter("price_in"));
		Date date_in;
		try {
			date_in = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_in"));
			Import_Product product=new Import_Product(code, code_sp, price_in, date_in);
			if(bd.insertImportProduct(product) == true) {
				response.sendRedirect("list-import");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteImportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("ID"));		
		Import_Product product = new Import_Product(id);
		bd.deleteImportProduct(product);
		response.sendRedirect("list-import");
	}
	private void listImportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		List<Import_Product> listproduct = bd.getAllImportProduct();
		request.setAttribute("listProduct",listproduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/ListImportProduct.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
