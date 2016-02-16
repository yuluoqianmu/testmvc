package struts.form;

public class testForm extends ActionForm{
	public testForm(){}
	
	private String name="";
	private String password="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
