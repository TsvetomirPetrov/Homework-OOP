package oneLevShop.CustomExeptions;

public class NotEnoughMoneyInBalance extends CustomException{

	private static final long serialVersionUID = 3L;

	public NotEnoughMoneyInBalance(String message) {
		super(message);
	}
}
