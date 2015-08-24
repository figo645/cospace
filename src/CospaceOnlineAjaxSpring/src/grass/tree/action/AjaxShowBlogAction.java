package grass.tree.action;

import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AjaxShowBlogAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// System.out.println("ok,you'er here");
		try {
			// response.getOutputStream().write(b)
			//System.out.println("ok,you'er here");
			// response.
			// PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String blogId = request.getParameter("blogId");
			//String step = request.getParameter("step");
			//System.out.println(step);
			BlogmasterDAO blogDao = new BlogmasterDAO();
			blogDao.getSession().clear();
			blogDao.getSession().flush();
			Blogmaster blogmaster = blogDao.findById(new Long(blogId));
			//System.out.println(blogmaster.getTitle());
			//System.out.println("<link href=\"css/font.css\" rel=\"stylesheet\" type=\"text/css\" />");
			//out.print("<link href=\"../css/font.css\" rel=\"stylesheet\" type=\"text/css\" />");

			out.print("<table border=\"0\" width=\"102%\" cellpadding=\"0\" cellspacing=\"0\">");
			out.print("<tr>");
			out.print("<td align=\"right\" valign=\"bottom\" class=\"styleTitle\">");
			out.print(blogmaster.getTitle()+"&nbsp;</td>");
			out.print("<td width=\"50\">&nbsp;</td>");
			out.print("</tr>");
			
			//if(null!=blogmaster.getTitleen() && "".equals(blogmaster.getTitleen())){
				out.print("<tr>");
				out.print("<td align=\"right\" valign=\"top\" class=\"styleTitleEN\">");
				out.print(blogmaster.getTitleen()+"&nbsp;&nbsp;&nbsp;</td>");
				out.print("<td>&nbsp;</td>");
				out.print("</tr>");
//			}else{
//				out.print("<tr height=\"1\">");
//				out.print("<td></td>");
//				out.print("<td></td>");
//				out.print("</tr>");
//			}
			out.print("<tr>");
			out.print("<td>&nbsp;</td>");
			out.print("<td>&nbsp;</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td align=\"center\" valign=\"top\">");
			out.print(blogmaster.getContent());
			out.print("</td>");
			out.print("<td>&nbsp;</td>");
			out.print("</tr>");
			out.print("</table>");
				
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
