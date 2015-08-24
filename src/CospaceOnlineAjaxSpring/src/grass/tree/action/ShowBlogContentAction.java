package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.SubBlogForm;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ShowBlogContentAction extends CommonBaseAction {
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		SubBlogForm subBlogForm = (SubBlogForm) form;// TODO Auto-generated
		List returnLst = null;
		// method stub
		BlogmasterDAO blogDao = new BlogmasterDAO();
		blogDao.getSession().clear();
		blogDao.getSession().flush();
		if (null != request.getParameter("blogId")) {
			Long id = Long.parseLong(request.getParameter("blogId"));

			Blogmaster blogmaster = blogDao.findById(id);
			// blog content form
			subBlogForm.setId(blogmaster.getBlogid());
			subBlogForm.setBlogtitle(blogmaster.getTitle());
			subBlogForm.setBlogtitleen(blogmaster.getTitleen());
			subBlogForm.setBlogcontent(blogmaster.getContent());
			
			subBlogForm.setTopvalue(blogmaster.getTopvalue());
			//System.out.println("top:"+subBlogForm.getTopvalue());
			String categories = blogmaster.getCategories();
			if (null != categories) {
				BlogmasterDAO dao = new BlogmasterDAO();
				returnLst = dao.findByCategories(categories);
			} else {
				// returnLst = new ArrayList();
			}
			String reqAttr = "menuLst";
			// set the list into var reqAttr
			
			// change the returnLst into changeLst
			request.setAttribute(reqAttr, returnLst);

		}
		blogDao.getSession().close();
		request.setAttribute("subBlogForm", subBlogForm);
		return mapping.findForward("showBlog");
	}
}
