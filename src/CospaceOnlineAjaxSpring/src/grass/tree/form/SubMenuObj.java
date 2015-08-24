package grass.tree.form;

import org.apache.struts.action.ActionForm;

public class SubMenuObj extends ActionForm {
	private Long menuid;
	private String menuDate;
	public String getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}

	private String menunameCn;
	private String menuremark;
	private String menunameEn;
	private String menulevel;
	private String menuurl;

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getMenunameCn() {
		return menunameCn;
	}

	public void setMenunameCn(String menunameCn) {
		this.menunameCn = menunameCn;
	}

	public String getMenuremark() {
		return menuremark;
	}

	public void setMenuremark(String menuremark) {
		this.menuremark = menuremark;
	}

	public String getMenunameEn() {
		return menunameEn;
	}

	public void setMenunameEn(String menunameEn) {
		this.menunameEn = menunameEn;
	}

	public String getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(String menulevel) {
		this.menulevel = menulevel;
	}

	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
}
