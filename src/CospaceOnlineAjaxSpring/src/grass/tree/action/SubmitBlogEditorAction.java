/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
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

/**
 * MyEclipse Struts Creation date: 11-06-2010
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/submitBlogEditor" name="subBlogForm"
 *                attribute="grass.form.SubBlogForm"
 *                input="/ckeditor/subblog.jsp" scope="request" validate="true"
 */
public class SubmitBlogEditorAction extends CommonBaseAction {
	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SubBlogForm subBlogForm = (SubBlogForm) form;// TODO Auto-generated
		// method stub

		BlogmasterDAO blogDao = new BlogmasterDAO();
		blogDao.getSession().clear();
		blogDao.getSession().flush();
		// blogDao.findById(id)
		Blogmaster blogmaster = null;
		blogmaster = new Blogmaster();
		// blogmaster.setBlogid(10l);
		blogmaster.setCategories(subBlogForm.getCategories());
		blogmaster.setTitle(subBlogForm.getBlogtitle());
		blogmaster.setTitleen(subBlogForm.getBlogtitleen());
		blogmaster.setContent(subBlogForm.getBlogcontent());
//		System.out.println("sub:"+subBlogForm.getBlogcontent());
		blogmaster.setTopvalue(subBlogForm.getTopvalue());
		blogmaster.setDelflg(subBlogForm.getDelflg());
		Date utilTime=new Date();
		//java.sql.Timestamp sqlTime = new Timestamp(utilTime.getTime());
		blogmaster.setCreatedate(utilTime);
		//blogmaster.setCreatetime();
		// blogmaster.setUpdatedate(subBlogForm.getUpdatedate());
		// blogmaster.setUpdatetime(subBlogForm.getUpdatetime());
		// blogDao.getSession().beginTransaction().begin();
		blogDao.save(blogmaster);
		blogDao.getSession().beginTransaction().commit();
		blogDao.getSession().close();
		setReturnFormList(request,blogDao,blogmaster);

		return mapping.findForward("aftersub");
	}
}