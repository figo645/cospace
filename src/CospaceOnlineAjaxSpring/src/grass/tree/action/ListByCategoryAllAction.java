package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.constant.ConstVar;
import grass.tree.form.BlogListForm;
import grass.tree.form.SubBlogForm;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ListByCategoryAllAction extends CommonBaseAction {
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// categories
		String menuId = request.getParameter("menuId");
		// search from BlogMaster and get the List into returnLst
		List returnLst = null;
		BlogListForm blogListForm = new BlogListForm();
		List returnLstForm = new ArrayList();
		if (null != menuId && !"".equals(menuId)) {
			BlogmasterDAO dao = new BlogmasterDAO();
			dao.getSession().clear();
			dao.getSession().flush();
			// if (menuId.startsWith("c002")) {
			// menuId = "c002";
			// System.out.println("ListByCategoryAllAction.doExcecute()");
			// returnLst = dao.findByCategoriesNews(menuId);
			// } else {
//			returnLst = dao.findByCategories(menuId);
			// }
			returnLst = dao.findByCategoriesAll(menuId);
			dao.getSession().close();
			// 重新排序定位，将TOP10放入
			// 1. get Blog List
			for (int i = 0; i < returnLst.size(); i++) {
				// 1.1 put blog Object to Form -> SubBlogForm.java
				Blogmaster blogObject = (Blogmaster) returnLst.get(i);
				SubBlogForm subBlogForm = new SubBlogForm();
				// 1.2 get elements from blogObject and put them into
				// SubBlogForm
				subBlogForm.setId(blogObject.getBlogid());
				subBlogForm.setBlogtitle(blogObject.getTitle());
				subBlogForm.setBlogtitleen(blogObject.getTitleen());
				subBlogForm.setTopvalue(blogObject.getTopvalue());
				subBlogForm.setDelflg(blogObject.getDelflg());
				if (null != blogObject.getCreatedate()) {
					java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
							"yyyy-MM-dd");
					String day = format.format(blogObject.getCreatedate());
					subBlogForm.setCreatedate(day);
				}
				returnLstForm.add(subBlogForm);
			}
			// System.out.println(returnLstForm.size());
			blogListForm.setSubBlogFormList(returnLstForm);
		}
		request.setAttribute("page_size", returnLst.size());
		request.setAttribute("page_record", ConstVar.RECORD_PER_PAGE);
		request.setAttribute("blogListForm", blogListForm);
		return mapping.findForward("listBlogs");
	}
}
