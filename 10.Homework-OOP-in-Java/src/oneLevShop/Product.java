package oneLevShop;

import java.math.BigDecimal;

public abstract class Product implements Buyable {
	private String name;
	private BigDecimal price;
	private int quantity;
	private AgeRestriction ageRestriction;

	public Product(String name, BigDecimal price, int quantity,
			AgeRestriction ageRestriction) {
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setAgeRestriction(ageRestriction);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			throw new IllegalArgumentException(getClass().getSimpleName()
					+ "'s should have a name!");
		}
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		int compareResult = price.compareTo(new BigDecimal(0));
		if (compareResult >= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException(getClass().getSimpleName()
					+ "'s price is invalid value!");
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		} else {
			throw new IllegalArgumentException(getClass().getSimpleName()
					+ "'s quantity should not be negative!");
		}

	}

	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	@Override
	public String toString() {
		return String.format(
				"A %s %s: price: %.2f, quantity: %d, age restriction: %s", this
						.getClass().getSimpleName().toLowerCase(), this.name,
				this.getPrice(), this.quantity, this.ageRestriction.toString()
						.toLowerCase());
	}
}
