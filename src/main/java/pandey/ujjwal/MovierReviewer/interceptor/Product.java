package pandey.ujjwal.MovierReviewer.interceptor;

public class Product {
	int id;
	String name;
	Double price;

	public Product(int id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}