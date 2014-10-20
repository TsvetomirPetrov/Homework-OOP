package oneLevShop;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import oneLevShop.Purchase.PurchaseManager;

public class TestOneLevShop {

	public static void main(String[] args) throws ParseException{
		try {			
			System.out.println("Our Products:");
			ArrayList<Product> shopProducts = new ArrayList<>();
			Product mandja = new FoodProduct("Beans with sausage", new BigDecimal("12.05"), 10, AgeRestriction.NONE, "16.10.2014");
			shopProducts.add(mandja);
			Product bioCucumber = new FoodProduct("Bio Cucumber", new BigDecimal("2.05"), 0, AgeRestriction.NONE, "16.10.2018");
			shopProducts.add(bioCucumber);		
			Product hp = new Computer("HP Chromebook WWAN 4G", new BigDecimal("700.05"), 1001, AgeRestriction.TEENAGER);
			shopProducts.add(hp);		
			Product pornVideoDownloader = new Appliance("Porn videos download helper", new BigDecimal("170.05"), 50, AgeRestriction.ADULT, 32);
			shopProducts.add(pornVideoDownloader);			
			Product cigars = new FoodProduct("420 Blaze it fgt", new BigDecimal("6.90"), 1400, AgeRestriction.ADULT, "01.01.2040");
			shopProducts.add(cigars);
			
			for (Product product : shopProducts) {
				System.out.println(product);
			}
			
			System.out.println();
			System.out.println("First product with the soonest date of expiration is:");
			
			ArrayList<Product> expirableProducts = 
					(ArrayList<Product>) shopProducts.stream()
					.filter(p1 -> p1 instanceof Expirable)
					.collect(Collectors.toList());
			
			Comparator<Product> byExpireDate = (p1, p2) -> (((Expirable)p1).getExpireDate()).compareTo(((Expirable)p2).getExpireDate());
			Product expiresSoonest = expirableProducts.stream().sorted(byExpireDate).findFirst().get();
			System.out.println(expiresSoonest);
	
			System.out.println();
			System.out.println("Our products for Adults:");
			ArrayList<Product> adultProducts = (ArrayList<Product>) shopProducts.stream()
					.filter(p1 -> p1.getAgeRestriction() == AgeRestriction.ADULT)
					.collect(Collectors.toList());
			
			Comparator<Product> byPrice = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
			adultProducts.sort(byPrice);
			
			for (Product product : adultProducts) {
				System.out.println(product);
			}
			
			System.out.println();			
			System.out.println("Our Customers:");
			Customer pecata = new Customer("Pecata", 17, new BigDecimal("30.00"));
			System.out.println(pecata);			
			Customer gopeto = new Customer("Gopeto", 18, new BigDecimal("0.44"));
			System.out.println(gopeto);
			Customer pena = new Customer("Pena", 18, new BigDecimal("440.56"));
			System.out.println(pena);
			System.out.println();
			
			PurchaseManager.processPurchase(pecata, cigars);
			PurchaseManager.processPurchase(gopeto, hp);			
			PurchaseManager.processPurchase(pena, mandja);
			PurchaseManager.processPurchase(pena, bioCucumber);	
			PurchaseManager.processPurchase(pena, pornVideoDownloader);			
			System.out.println();
			
			System.out.println("After Pena bought a Porn videos download helper:");
			System.out.println(pena);
			System.out.println(pornVideoDownloader);			
		} catch (NumberFormatException wrongBigDecimalFormat) {
			System.err.println(wrongBigDecimalFormat.getClass() + "\nCaused: Invalid argumets for BigDecimal");
		} catch (IllegalArgumentException invalidArgumetsException) {
			System.err.println(invalidArgumetsException.getMessage());
		} 
	}
}
