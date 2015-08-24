package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.MenuForm;
import grass.tree.form.SubBlogForm;
import grass.tree.form.SubMenuObj;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ListMenuNewsAction extends CommonBaseAction {

	/**
	 * 
	 */
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		MenuForm subBlogForm = (MenuForm) form;// TODO Auto-generated
		// SysmenuDAO dao = new SysmenuDAO();
		Set subMenuObjLst;
		SubMenuObj subMenuObj;
		List returnLst = null;

		List dynamicstate = null;
		List cultureactive = null;

		// method stub
		String categories = request.getParameter("menuId");

		dynamicstate = setReturnc002(categories + "1", dynamicstate);
		cultureactive = setReturnc002(categories + "2", cultureactive);


		if (dynamicstate != null && dynamicstate.size() != 0) {
			Blogmaster master = (Blogmaster) dynamicstate.get(0);
			showBlog(request, master);
		} else if (cultureactive != null && cultureactive.size() != 0) {
			Blogmaster master = (Blogmaster) cultureactive.get(0);
			showBlog(request, master);
		} 

		// 重新排序定位，将TOP10放入
		// returnLst = SortTopTenUtil.createTopList(returnLst);
		// change the returnLst into changeLst
		request.setAttribute("dynamicstate", dynamicstate);
		request.setAttribute("cultureactive", cultureactive);

		return mapping.findForward("listById");
	}

	private List setReturnc002(String categories, List paraReturnList) {
		if (null != categories) {
			BlogmasterDAO dao = new BlogmasterDAO();
			dao.getSession().clear();
			dao.getSession().flush();
			// returnLst = dao.findByCategories(categories);
			// if (categories.startsWith("c002")) {
			// categories = "c002";
//			System.out.println("ListMenuNewsAction.doExcecute()"+categories);
			paraReturnList = dao.findByCategoriesNewsNonDel(categories);
//			System.err.println(paraReturnList.size());
			// }
			dao.getSession().close();
		} else {
			// returnLst = new ArrayList();
		}
		// String reqAttr = "menuLst";
		return paraReturnList;
	}

	private void showBlog(HttpServletRequest request, Blogmaster blogmaster) {
		SubBlogForm subBlogForm = new SubBlogForm();
		Long id = 1l;
		BlogmasterDAO blogDao = new BlogmasterDAO();
		blogDao.getSession().clear();
		blogDao.getSession().flush();
		// Blogmaster blogmaster = blogDao.findById(id);

		if (null != blogmaster) {
			subBlogForm.setId(blogmaster.getBlogid());
			subBlogForm.setBlogtitle(blogmaster.getTitle());
			subBlogForm.setBlogtitleen(blogmaster.getTitleen());
			subBlogForm.setBlogcontent(blogmaster.getContent());

			request.setAttribute("subBlogForm", subBlogForm);
		}
		blogDao.getSession().close();
	}

}
