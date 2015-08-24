package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.MenuForm;
import grass.tree.form.SubBlogForm;
import grass.tree.form.SubMenuObj;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ListMenuArchAction extends CommonBaseAction {

	/**
	 * 
	 */
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		MenuForm subBlogForm = (MenuForm) form;// TODO Auto-generated
		// SysmenuDAO dao = new SysmenuDAO();
		Set subMenuObjLst;
		SubMenuObj subMenuObj;
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
		dao.getSession().clear();
		dao.getSession().flush();
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
		
		// 重新排序定位，将TOP10放入
//		returnLst01 = SortTopTenUtil.createTopList(returnLst01);
//		returnLst02 = SortTopTenUtil.createTopList(returnLst02);
//		returnLst03 = SortTopTenUtil.createTopList(returnLst03);
//		returnLst04 = SortTopTenUtil.createTopList(returnLst04);
//		returnLst05 = SortTopTenUtil.createTopList(returnLst05);
		if (returnLst01 != null && returnLst01.size() != 0) {
			Blogmaster master = (Blogmaster) returnLst01.get(0);
			showBlog(request, master);
		}else if (returnLst02 != null && returnLst02.size() != 0) {
			Blogmaster master = (Blogmaster) returnLst01.get(0);
			showBlog(request, master);
		}
		else if (returnLst03 != null && returnLst03.size() != 0) {
			Blogmaster master = (Blogmaster) returnLst01.get(0);
			showBlog(request, master);
		}
		else if (returnLst04 != null && returnLst04.size() != 0) {
			Blogmaster master = (Blogmaster) returnLst01.get(0);
			showBlog(request, master);
		}
		else if (returnLst05!= null && returnLst05.size() != 0) {
			Blogmaster master = (Blogmaster) returnLst01.get(0);
			showBlog(request, master);
		}
		// change the returnLst into changeLst
		request.setAttribute(reqAttr01, returnLst01);
		request.setAttribute(reqAttr02, returnLst02);
		request.setAttribute(reqAttr03, returnLst03);
		request.setAttribute(reqAttr04, returnLst04);
		request.setAttribute(reqAttr05, returnLst05);

		return mapping.findForward("listById");
	}

	private void showBlog(HttpServletRequest request, Blogmaster blogmaster) {
		SubBlogForm subBlogForm = new SubBlogForm();
		Long id = 1l;
		BlogmasterDAO blogDao = new BlogmasterDAO();
		// Blogmaster blogmaster = blogDao.findById(id);

		if (null != blogmaster) {
			subBlogForm.setId(blogmaster.getBlogid());
			subBlogForm.setBlogtitle(blogmaster.getTitle());
			subBlogForm.setBlogtitleen(blogmaster.getTitleen());
			subBlogForm.setBlogcontent(blogmaster.getContent());

			request.setAttribute("subBlogForm", subBlogForm);
			blogDao.getSession().close();
		}
	}

}
