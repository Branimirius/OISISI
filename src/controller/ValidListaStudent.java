package controller;

public class ValidListaStudent {
	private static ValidListaStudent instance = null;

	public static ValidListaStudent getInstance() {
		if (instance == null) {
			instance = new ValidListaStudent();
		}
		return instance;
	}
	
	private Boolean[] listValid = new Boolean[8];
	
	public ValidListaStudent() {
		this.listValid[0] = false;
		this.listValid[1] = false;
		this.listValid[2] = false;
		this.listValid[3] = false;
		this.listValid[4] = false;
		this.listValid[5] = false;
		this.listValid[6] = false;
		this.listValid[7] = false;
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
	
	public Boolean listValid() {
		if (this.listValid[0] == true && this.listValid[1] == true && 
			this.listValid[2] == true && this.listValid[3] == true &&
			this.listValid[4] == true && this.listValid[5] == true &&
			this.listValid[6] == true && this.listValid[7] == true) return true;
		else return false;
	}

}
