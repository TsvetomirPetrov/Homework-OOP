package oneLevShop;

import java.math.BigDecimal;

public class Computer extends ElectonicsProduct {
	
	private static final int COMPUTER_GUARANTEE_PERIOD = 24;
	private static final int DISCOUNT_QUANTITY = 1000;
	private BigDecimal coefficientOfDiscount = new BigDecimal("0.95");

	public Computer(String name, BigDecimal price, int quantity,
			AgeRestriction ageRestriction, int guaranteePeriodInMonts) {
		super(name, price, quantity, ageRestriction, guaranteePeriodInMonts);		
	}
	
	public Computer(String name, BigDecimal price, int quantity, AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction, COMPUTER_GUARANTEE_PERIOD);
	} 
	@Override
	public BigDecimal getPrice() {
		if (this.getQuantity() > DISCOUNT_QUANTITY) {
			return this.CorrectThePrice(coefficientOfDiscount);
		} else {
			return super.getPrice();
		}		
	}
}
