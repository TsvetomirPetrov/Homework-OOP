package oneLevShop.CustomExeptions;

public class DontHavePermissionToBuy extends CustomException {

	private static final long serialVersionUID = 2L;

	public DontHavePermissionToBuy(String message) {
		super(message);
	}
}
