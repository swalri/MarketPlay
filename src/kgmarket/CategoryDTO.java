package kgmarket;

import java.io.Serializable;

public class CategoryDTO implements Serializable{
	//카테고리
	//상품
	//가격
	int money;
	String category=null, product=null;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
}
