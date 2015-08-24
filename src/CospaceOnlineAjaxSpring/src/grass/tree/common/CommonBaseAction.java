package grass.tree.common;

import grass.tree.form.BlogListForm;
import grass.tree.form.SubBlogForm;
import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class CommonBaseAction extends Action {

	public CommonBaseAction() {
		super();

	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward returnForward = null;
		try {
			returnForward = doExcecute(mapping, form, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter printWriter = new PrintWriter(sw);
			//System.err.println("Error Catch");
			e.printStackTrace(printWriter);
			request.setAttribute("errorMessage", sw.toString());
			System.out.println(sw.toString());
			return mapping.findForward("error");
		}

		return returnForward;
	}

	protected abstract ActionForward doExcecute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	protected void setReturnFormList(HttpServletRequest request,
			BlogmasterDAO blogDao,Blogmaster blogObject) {
		// TODO Auto-generated method stub
		List returnLst  = blogDao.findByCategoriesAll(blogObject.getCategories());
		List returnLstForm = new ArrayList();
		//System.err.println(list.size());
		BlogListForm blogListForm = new BlogListForm();
		//blogListForm.setSubBlogFormList(list);
		
		for (int i = 0; i < returnLst.size(); i++) {
			// 1.1 put blog Object to Form -> SubBlogForm.java
			Blogmaster blogObjectTmp = (Blogmaster) returnLst.get(i);
			SubBlogForm subBlogForm = new SubBlogForm();
			// 1.2 get elements from blogObject and put them into
			// SubBlogForm
			subBlogForm.setId(blogObjectTmp.getBlogid());
			subBlogForm.setBlogtitle(blogObjectTmp.getTitle());
			subBlogForm.setBlogtitleen(blogObjectTmp.getTitleen());
			subBlogForm.setTopvalue(blogObjectTmp.getTopvalue());
			subBlogForm.setDelflg(blogObjectTmp.getDelflg());
			if (null != blogObjectTmp.getCreatedate()) {
				java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
						"yyyy-MM-dd");
				String day = format.format(blogObjectTmp.getCreatedate());
				subBlogForm.setCreatedate(day);
			}
			returnLstForm.add(subBlogForm);
		}
		blogListForm.setSubBlogFormList(returnLstForm);
		
//		request.removeAttribute("blogListForm");
		request.setAttribute("blogListFormTmp", blogListForm);
	}
}