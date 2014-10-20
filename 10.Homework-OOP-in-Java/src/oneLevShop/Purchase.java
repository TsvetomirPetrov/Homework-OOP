package oneLevShop;

import java.util.Date;

import oneLevShop.CustomExeptions.DontHavePermissionToBuy;
import oneLevShop.CustomExeptions.NotEnoughMoneyInBalance;
import oneLevShop.CustomExeptions.ProductHasExpired;
import oneLevShop.CustomExeptions.ProductOutOfStock;

public class Purchase {
	public static class PurchaseManager {
		public static void processPurchase(Customer customer, Product product) {
			boolean isEnoughMoney = customer.getBalance().compareTo(
					product.getPrice()) >= 0;

			boolean hasPermission = permisionChecker(customer, product);

			boolean isExpired = false;
			if (product instanceof Expirable) {
				isExpired = expirationChecker((Expirable) product);
			}

			boolean isAnyProducts = product.getQuantity() > 0;

			if (isEnoughMoney) {
				if (hasPermission) {
					if (!isExpired) {
						if (isAnyProducts) {
							customer.setBalance(customer.getBalance().subtract(
									product.getPrice()));
							product.setQuantity(product.getQuantity() - 1);
						} else {
							try {
								throw new ProductOutOfStock(customer.getName()
										+ " can not buy: "
										+ product.getName().toString()
										+ ".\nProduct is out of stock!");
							} catch (ProductOutOfStock e) {
								System.out.println(e.getMessage());
							}
						}
					} else {
						try {
							throw new ProductHasExpired(customer.getName()
									+ " can not buy: "
									+ product.getName().toString()
									+ ".\nProduct has expired!");
						} catch (ProductHasExpired e) {
							System.out.println(e.getMessage());
						}
					}
				} else {
					try {
						throw new DontHavePermissionToBuy(customer.getName()
								+ " can not buy: "
								+ product.getName().toString() + ".\n"
								+ customer.getName() + " dont have permission!");
					} catch (DontHavePermissionToBuy e) {
						System.out.println(e.getMessage());
					}
				}
			} else {
				try {
					throw new NotEnoughMoneyInBalance(customer.getName()
							+ " can not buy: " + product.getName().toString()
							+ ".\n" + customer.getName()
							+ " dont have enough money!");
				} catch (NotEnoughMoneyInBalance e) {
					System.out.println(e.getMessage());
				}
			}
		}

		public static boolean permisionChecker(Customer customer,
				Product product) {
			boolean hasPermission = true;

			switch (product.getAgeRestriction().toString()) {
			case "NONE":
				hasPermission = true;
				break;

			case "TEENAGER":
				if (customer.getAge() < 10) {
					hasPermission = false;
				}
				break;

			case "ADULT":
				if (customer.getAge() < 18) {
					hasPermission = false;
				}
				break;

			default:
				throw new UnsupportedOperationException();
			}

			return hasPermission;
		}

		private static boolean expirationChecker(Expirable product) {
			boolean isExpired = false;
			Date today = new Date();
			int copareResult = product.getExpireDate().compareTo(today);

			if (copareResult < 0) {
				isExpired = true;
			}

			return isExpired;
		}

	}
}
