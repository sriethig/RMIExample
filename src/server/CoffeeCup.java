package server;

import java.io.Serializable;

public class CoffeeCup implements Serializable {

	private Coffee type;
	private Size size;
	private String name;
	
	public CoffeeCup(Coffee type, Size size, String name) {
		this.type = type;
		this.size = size;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "A delicious cup of " + type + " " + size + "-sized for " + name + "!";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
