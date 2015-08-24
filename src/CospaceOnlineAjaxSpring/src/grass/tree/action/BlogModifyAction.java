package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.SubBlogForm;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BlogModifyAction extends CommonBaseAction {

	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String blogId = request.getParameter("blogId");
		// System.out.println(blogId);
		SubBlogForm subBlogForm = (SubBlogForm) form;// TODO Auto-generated
		// method stub
		BlogmasterDAO blogDao = new BlogmasterDAO();
		blogDao.getSession().clear();
		blogDao.getSession().flush();
		Blogmaster blogmaster = null;
		blogmaster = blogDao.findById(Long.valueOf(blogId));

		blogDao.getSession().close();
		subBlogForm.setBlogtitle(blogmaster.getTitle());
		subBlogForm.setBlogtitleen(blogmaster.getTitleen());
		subBlogForm.setBlogcontent(blogmaster.getContent());
		subBlogForm.setDelflg(blogmaster.getDelflg());
		// System.out.println("show:"+blogmaster.getContent());
		subBlogForm.setTopvalue(blogmaster.getTopvalue());
		String dbCategory = blogmaster.getCategories();
		// System.out.println(dbCategory);
		// if (dbCategory.equals("c002")) {
		// subBlogForm.setCategories(blogmaster.getCategories());
		// } else if (dbCategory.startsWith("c002")) {
		// String[] formSplit = dbCategory.split("-");
		// if (formSplit.length != 1) {
		// subBlogForm.setCategories(formSplit[0]);
		// subBlogForm.setNewsdate(formSplit[1]);
		// }
		// } else {
		subBlogForm.setCategories(blogmaster.getCategories());
		// }
		request.setAttribute("subBlogForm", subBlogForm);
		request.setAttribute("blogId", blogId);
		return mapping.findForward("linkToModify");
	}
}
