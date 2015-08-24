package grass.tree.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	private String username;
	private String passwords;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
}
