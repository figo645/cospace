package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BlogDelAction extends CommonBaseAction {
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String blogId = request.getParameter("blogId");

		BlogmasterDAO blogDao = new BlogmasterDAO();
		blogDao.getSession().clear();
		blogDao.getSession().flush();
		blogDao.getSession().beginTransaction().begin();
		Blogmaster blogObjectInput=null;
		if (null != blogId) {
			Blogmaster blogObject = blogDao.findById(Long.valueOf(blogId));
			blogObject.setDelflg(new Integer(1));
			// System.out.println(blogId);
			blogDao.save(blogObject);
			blogObjectInput = blogObject;
			// blogDao.delete(blogObject);
		} else {

			String[] delflg = request.getParameterValues("delflg");
			// if (null != delflg) {
			for (int i = 0; i < delflg.length; i++) {
				Blogmaster blogObject = blogDao.findById(Long
						.valueOf(delflg[i]));
				blogObject.setDelflg(new Integer(1));
				// System.out.println(delflg[i]);
				if (request.getParameter("del").equals("ÔÝ²»ÏÔÊ¾")) {
					blogDao.save(blogObject);
				}else if (request.getParameter("del").equals("³¹µ×É¾³ý")) {
					blogDao.delete(blogObject);
				}
				blogObjectInput = blogObject;
			}
			// }
		}
		setReturnFormList(request, blogDao, blogObjectInput);
		blogDao.getSession().beginTransaction().commit();
		blogDao.getSession().close();
		return mapping.findForward("linkToDel");
	}
}
