package Models;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Export_Product {
	
	private int ID;
	private String code;
	private String code_sp;
	private int price_out;
	private Date date_out;
	
	public Export_Product(int iD, String code, String code_sp, int price_out, Date date_out) {
		super();
		ID = iD;
		this.code = code;
		this.code_sp = code_sp;
		this.price_out = price_out;
		this.date_out = date_out;
	}
	
	public Export_Product(String code, String code_sp, int price_out, Date date_out) {
		super();
		this.code = code;
		this.code_sp = code_sp;
		this.price_out = price_out;
		this.date_out = date_out;
	}

	public Export_Product(int iD) {
		super();
		ID = iD;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode_sp() {
		return code_sp;
	}
	
	public void setCode_sp(String code_sp) {
		this.code_sp = code_sp;
	}
	
	public int getPrice_out() {
		return price_out;
	}
	
	public void setPrice_out(int price_out) {
		this.price_out = price_out;
	}
	
	public Date getDate_out() {
		return date_out;
	}
	
	public void setDate_in(Date date_out) {
		this.date_out = date_out;
	}
	
	public void print() {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("ID: "+ ID);
		System.out.println("Code: "+ code);
		System.out.println("Code_sp: "+ code_sp);
		System.out.println("Price: "+ price_out);
		System.out.println("Date: "+ fomat.format(date_out));
	}
}

