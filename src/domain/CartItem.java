package domain;

//购物车的属性
public class CartItem {
	private Book book;//书
	private int quantity;//书的数量
	private double price;//输的总价钱
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return this.book.getPrice()*this.quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
