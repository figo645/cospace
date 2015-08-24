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

public class ShowBlogArchContentAction extends CommonBaseAction {
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		SubBlogForm subBlogForm = (SubBlogForm) form;// TODO Auto-generated
		List returnLst = null;
		// method stub
		loadList(request);
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
	
	private void loadList(HttpServletRequest request){
		List returnLst01 = null;
		List returnLst02 = null;
		List returnLst03 = null;
		List returnLst04 = null;
		List returnLst05 = null;
		// method stub
		String categories01 = "c0041";
		String categories02 = "c0042";
		String categories03 = "c0043";
		String categories04 = "c0044";
		String categories05 = "c0045";
		
		BlogmasterDAO dao = new BlogmasterDAO();
		returnLst01 = dao.findByCategories(categories01);
		returnLst02 = dao.findByCategories(categories02);
		returnLst03 = dao.findByCategories(categories03);
		returnLst04 = dao.findByCategories(categories04);
		returnLst05 = dao.findByCategories(categories05);
		
		String reqAttr01 = "menuLst01";
		String reqAttr02 = "menuLst02";
		String reqAttr03 = "menuLst03";
		String reqAttr04 = "menuLst04";
		String reqAttr05 = "menuLst05";
		
		dao.getSession().close();
		// change the returnLst into changeLst
		request.setAttribute(reqAttr01, returnLst01);
		request.setAttribute(reqAttr02, returnLst02);
		request.setAttribute(reqAttr03, returnLst03);
		request.setAttribute(reqAttr04, returnLst04);
		request.setAttribute(reqAttr05, returnLst05);
	}
}
