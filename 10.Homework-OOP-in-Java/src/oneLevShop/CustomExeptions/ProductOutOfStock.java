package oneLevShop.CustomExeptions;

public class ProductOutOfStock extends CustomException {

	private static final long serialVersionUID = 5L;

	public ProductOutOfStock(String message) {
		super(message);
	}
}
