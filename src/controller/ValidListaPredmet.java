package controller;

public class ValidListaPredmet {

	private static ValidListaPredmet instance = null;

	public static ValidListaPredmet getInstance() {
		if (instance == null) {
			instance = new ValidListaPredmet();
		}
		return instance;
		
	}
	private Boolean[] listValid = new Boolean[3];
	public ValidListaPredmet() {
		this.listValid[0] = false;
		this.listValid[1] = false;
		this.listValid[2] = false;
	}
	public Boolean[] getListValid() {
		return listValid;
	}

	public void setListValid(Boolean[] listValid) {
		this.listValid = listValid;
	}
	
	public void validateList(int i) {
		this.listValid[i] = true;
	}
	
	public void deValidateList(int i) {
		this.listValid[i] = false;
	}
	public Boolean listValid() {
		if (this.listValid[0] == true && this.listValid[1] == true && 
			this.listValid[2] == true) return true;
		else return false;
	}
	
}
