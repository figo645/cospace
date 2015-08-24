package grass.tree.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class BlogListForm extends ActionForm {
	private List subBlogFormList;

	public List getSubBlogFormList() {
		return subBlogFormList;
	}

	public void setSubBlogFormList(List subBlogFormList) {
		this.subBlogFormList = subBlogFormList;
	}
}
