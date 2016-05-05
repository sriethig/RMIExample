package server;

import java.io.Serializable;
import java.util.Date;

public class CoffeeOrder implements Serializable {
	
	private Date date;
	private Coffee type;
	private Size size;
	private String buyer;
	
	public CoffeeOrder(Date date, Coffee type, Size size, String buyer) {
		super();
		this.date = date;
		this.type = type;
		this.size = size;
		this.buyer = buyer;
	}
	
	

	@Override
	public String toString() {
		return date + ": " + buyer + " has ordered a " + size + "-sized " + type + "!";
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Coffee getType() {
		return type;
	}

	public void setType(Coffee type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

}
