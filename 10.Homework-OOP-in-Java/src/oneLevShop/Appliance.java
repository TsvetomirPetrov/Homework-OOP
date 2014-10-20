package oneLevShop;

import java.math.BigDecimal;

public class Appliance extends ElectonicsProduct {
	
	private static final int APPLIANCE_GUARANTEE_PERIOD = 6;
	private static final int PRICE_GROW_QUANTITY = 50;
	private BigDecimal coefficientOfDiscount = new BigDecimal("1.05");
		
	public Appliance(String name, BigDecimal price, int quantity,
			AgeRestriction ageRestriction, int guaranteePeriodInMonts) {
		super(name, price, quantity, ageRestriction, guaranteePeriodInMonts);		
	}
	
	public Appliance(String name, BigDecimal price, int quantity, AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction, APPLIANCE_GUARANTEE_PERIOD);
	} 

	@Override
	public BigDecimal getPrice() {
		if (this.getQuantity() < PRICE_GROW_QUANTITY) {
			return this.CorrectThePrice(coefficientOfDiscount);
		} else {
			return super.getPrice();
		}		
	}
}
