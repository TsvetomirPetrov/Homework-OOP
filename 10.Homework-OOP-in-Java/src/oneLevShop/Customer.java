package oneLevShop;

import java.math.BigDecimal;

public class Customer {
	private String name;
	private int age;
	private BigDecimal balance;
	
	public Customer(String name, int age, BigDecimal balance) {
		this.setName(name);
		this.setAge(age);
		this.setBalance(balance);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name != "") {
			this.name = name;
		}else {
			throw new IllegalArgumentException("Customer should have name!");
		}
		
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("Customer's age are invalid!");
		}
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		
		if (!balance.equals(null)) {
			this.balance = balance;
		} else {
			throw new IllegalArgumentException("Customer must have balance!");
		}		
	}
	
	@Override
	public String toString() {
		return String.format(
				"A %s %s: %d yars old, blance: %.2f", 
				this.getClass().getSimpleName().toLowerCase(),
				this.name,				 
				this.age,
				this.balance);
	}
}
