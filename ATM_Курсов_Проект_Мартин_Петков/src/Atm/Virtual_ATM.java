package Atm;

class Virtual_ATM {
	
	private String pincode;
	
	public Virtual_ATM(String pincode) {
		this.pincode = pincode;
		}
	
	public String getPincode() {
    	return pincode;
    }
	
	public Boolean pinv(String enter,Boolean card) {
	if (enter.equals("7777") || enter.equals("6666") || enter.equals("7676")) {
		pincode = enter;
		card = true;
		return card;
	}
	else {
		System.out.println("!");
		card = false;
		return card;
	}
	
	}

}
