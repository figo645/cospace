package grass.tree.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class MenuForm extends ActionForm {
	private List SubMenuObj;

	public List getSubMenuObj() {
		return SubMenuObj;
	}

	public void setSubMenuObj(List subMenuObj) {
		SubMenuObj = subMenuObj;
	}
}
