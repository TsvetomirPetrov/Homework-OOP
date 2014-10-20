package oneLevShop.CustomExeptions;

public class ProductHasExpired extends CustomException {

	private static final long serialVersionUID = 4L;

	public ProductHasExpired(String message) {
		super(message);
	}
}
