package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Export_Product;
import Models.dbConnects;

@WebServlet(urlPatterns= {
		"/update-export/*", 
		"/new-export",
		"/insert-export",
		"/edit-export",
		"/list-export",
		"/delete-export"})
public class ExportProductController extends HttpServlet {
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
    

	public ExportProductController(){
		super();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
				case "/insert-export":	
					insertExportProduct(request,response);
					break;
				case "/new-export":
					newForm(request, response);
					break;
				case "/update-export":
					uppdateExportProduct(request,response);
					break;
				case "/edit-export":
					editForm(request,response);
					break;
				case "/delete-export":
					deleteExportProduct(request,response);
					break;
				default:
					listExportProduct(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/NewExportProduct.jsp");
		dispatcher.forward(request, response);
	}
	private void editForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException, SQLException{
		int id_product=Integer.parseInt(request.getParameter("ID"));
		Export_Product product = bd.getExportProduct(id_product);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Views/NewExportProduct.jsp");
		dispatcher.forward(request, response);		
	}
	private void uppdateExportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
		int id=Integer.parseInt(request.getParameter("ID"));
		String code=request.getParameter("code");
		String code_sp=request.getParameter("code_sp");
		int price=Integer.parseInt(request.getParameter("price_out"));
		Date date_out;
		try {
			date_out = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_out"));
			Export_Product product = new Export_Product(id, code, code_sp, price, date_out);
			bd.updateExportProduct(product);
			response.sendRedirect("list-export");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertExportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		//int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
		String code_sp=request.getParameter("code_sp");
		int price_out=Integer.parseInt(request.getParameter("price_out"));
		Date date_out;
		String date = request.getParameter("date_out");
		try {
			date_out = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Export_Product product=new Export_Product(code, code_sp, price_out, date_out);
			if(bd.insertExportProduct(product) == true) {
				response.sendRedirect("list-export");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deleteExportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("ID"));		
		Export_Product product = new Export_Product(id);
		bd.deleteExportProduct(product);
		response.sendRedirect("list-export");
	}
	private void listExportProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		List<Export_Product> listproduct = bd.getAllExportProduct();
		request.setAttribute("listProduct",listproduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/ListExportProduct.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
