package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.SubBlogForm;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BlogModifyCloseAction extends CommonBaseAction {

	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String blogId = request.getParameter("blogId");

		SubBlogForm subBlogForm = (SubBlogForm) form;
		// TODO Auto-generated
		// System.out.println(subBlogForm.getId());
		// method stub
		BlogmasterDAO blogDao = new BlogmasterDAO();
		blogDao.getSession().clear();
		blogDao.getSession().flush();
		Blogmaster blogmaster = null;
		blogmaster = blogDao.findById(Long.valueOf(blogId));
		blogDao.getSession().beginTransaction().begin();
		// if (subBlogForm.getCategories().startsWith("c002")) {
		// String categoryFromForm = subBlogForm.getCategories() + "-"
		// + subBlogForm.getNewsdate();
		// blogmaster.setCategories(categoryFromForm);
		// } else {
		blogmaster.setCategories(subBlogForm.getCategories());
		// }
		blogmaster.setTitle(subBlogForm.getBlogtitle());
		blogmaster.setTitleen(subBlogForm.getBlogtitleen());
		blogmaster.setDelflg(subBlogForm.getDelflg());
		// //////////////////////////////////////////////////
		// System.out.println("modify01:"+subBlogForm.getBlogcontent());
		// try {
		// String str = new
		// String(subBlogForm.getBlogcontent().getBytes("UTF-8"));
		// System.out.println("modify02:"+str);
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//		
		blogmaster.setContent(subBlogForm.getBlogcontent());
		blogmaster.setTopvalue(subBlogForm.getTopvalue());
		Date utilTime = new Date();
		// java.sql.Timestamp sqlTime = new Timestamp(utilTime.getTime());
		blogmaster.setUpdatedate(utilTime);

		blogDao.getSession().beginTransaction().commit();
		blogDao.getSession().close();
		// blogmaster.setUpdatedate(updatedate)
		setReturnFormList(request, blogDao, blogmaster);
		return mapping.findForward("endOfModify");
	}
}
