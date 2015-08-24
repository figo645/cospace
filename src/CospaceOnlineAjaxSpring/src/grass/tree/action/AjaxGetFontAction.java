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

public class AjaxGetFontAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 System.out.println("ok,you'er here Font");
		try {
			// response.getOutputStream().write(b)
			//System.out.println("ok,you'er here");
			// response.
			// PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			//String blogId = request.getParameter("blogId");
			//String step = request.getParameter("step");
			//System.out.println(step);
//			BlogmasterDAO blogDao = new BlogmasterDAO();
//			blogDao.getSession().clear();
//			blogDao.getSession().flush();
//			Blogmaster blogmaster = blogDao.findById(new Long(blogId));
			//System.out.println(blogmaster.getTitle());
			//System.out.println("<link href=\"css/font.css\" rel=\"stylesheet\" type=\"text/css\" />");
			//out.print("<link href=\"../css/font.css\" rel=\"stylesheet\" type=\"text/css\" />");
			out.println("<style>");
			out.print("@font-face {");
			out.print("	font-family: ººÒÇ´óËÎ¼ò;");
			out.print("	src: url(../font/HYDSJ.eot);");
			out.print("}");

			out.print("@font-face {");
			out.print("	font-family: ººÒÇ´óËÎ¼ò;");
			out.print("	src: url(../font/dasongjian.ttf) format(\"opentype\");");
			out.print("}");



			out.print(".styleTitle {");
			out.print("	font-family: \"ººÒÇ´óËÎ¼ò\";");
			out.print("	font-size: 38px;");
			out.print("	color: #024999;");
			out.print("}");

			out.print(".styleTitleEN {");
			out.print("	font-family: \"Arial\";");
			out.print("	font-weight: normal;");
			out.print("	font-size: 30px;");
			out.print("	color: #01A0FC;");
			out.print("}");
			out.println("</style>");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
