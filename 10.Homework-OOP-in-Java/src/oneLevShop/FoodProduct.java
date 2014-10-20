package oneLevShop;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FoodProduct extends Product implements Expirable {
	private final int DISCOUNT_DAYS_BEFOR_EXPIRE = 15;
	private BigDecimal coefficientOfDiscount = new BigDecimal("0.7");
	private static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat(
			"dd.MM.yyyy");
	private Date expireDate;

	public FoodProduct(String name, BigDecimal price, int quantity,
			AgeRestriction ageRestriction, String expireDate) {

		super(name, price, quantity, ageRestriction);
		this.setExpireDate(expireDate);

	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {

		try {
			this.expireDate = DATE_FORMATER.parse(expireDate);
		} catch (ParseException cantParseThis) {
			System.out.println("Expire date must be in format: "
					+ DATE_FORMATER.toPattern());
			System.out
					.println("Please, enter date in correct format or close application!");
			Scanner input = new Scanner(System.in);
			String newUserString = input.nextLine();
			setExpireDate(newUserString);
			input.close();
		}
	}

	@Override
	public BigDecimal getPrice() {
		Date today = new Date();
		Date discountDate = new Date(this.expireDate.getTime()
				- (1000 * 60 * 60 * 24 * DISCOUNT_DAYS_BEFOR_EXPIRE));

		int resultOfComparing = today.compareTo(discountDate);
		if (resultOfComparing >= 0) {
			BigDecimal newPrice = super.getPrice();
			return newPrice.multiply(coefficientOfDiscount);
		} else {
			return super.getPrice();
		}
	};

	@Override
	public String toString() {
		return super.toString()
				+ String.format(", expire date: %s",
						DATE_FORMATER.format(expireDate));
	}

}
