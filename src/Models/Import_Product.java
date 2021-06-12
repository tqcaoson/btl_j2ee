package Models;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Import_Product {
	
	private int ID;
	private String code;
	private String code_sp;
	private int price_in;
	private Date date_in;
	
	public Import_Product(int iD, String code, String code_sp, int price_in, Date date_in) {
		super();
		ID = iD;
		this.code = code;
		this.code_sp = code_sp;
		this.price_in = price_in;
		this.date_in = date_in;
	}
	
	public Import_Product(String code, String code_sp, int price_in, Date date_in) {
		super();
		this.code = code;
		this.code_sp = code_sp;
		this.price_in = price_in;
		this.date_in = date_in;
	}

	public Import_Product(int iD) {
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
	
	public int getPrice_in() {
		return price_in;
	}
	
	public void setPrice_in(int price_in) {
		this.price_in = price_in;
	}
	
	public Date getDate_in() {
		return date_in;
	}
	
	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}
	
	public void print() {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("ID: "+ ID);
		System.out.println("Code: "+ code);
		System.out.println("Code_sp: "+ code_sp);
		System.out.println("Price: "+ price_in);
		System.out.println("Date: "+ fomat.format(date_in));
	}
}

