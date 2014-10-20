package oneLevShop;

import java.math.BigDecimal;

public abstract class ElectonicsProduct extends Product {
	private int guaranteePeriodInMonts;
	
	public ElectonicsProduct(String name, BigDecimal price, int quantity,
			AgeRestriction ageRestriction, int guaranteePeriodInMonts) {
		
		super(name, price, quantity, ageRestriction);
		this.setGuaranteePeriodInMonts(guaranteePeriodInMonts);
	}

	public int getGuaranteePeriodInMonts() {
		return guaranteePeriodInMonts;
	}

	public void setGuaranteePeriodInMonts(int guaranteePeriodInMonts) {
		this.guaranteePeriodInMonts = guaranteePeriodInMonts;
	}
	
	protected BigDecimal CorrectThePrice(BigDecimal coefficientOfDiscount) {
		BigDecimal newPrice = super.getPrice();
		return newPrice.multiply(coefficientOfDiscount);
	}
	
	@Override
	public String toString() {
		return super.toString() 
				+ String.format(", has guarantee: %d monts", this.guaranteePeriodInMonts);
	}
}
