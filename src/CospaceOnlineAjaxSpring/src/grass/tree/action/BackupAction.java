package grass.tree.action;

import grass.tree.util.BackupToObject;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BackupAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		response.reset();
		
		response.setHeader("Content-Disposition",
				"attachment;filename=Co-spaceDB_Backup.sql");
		response.setContentType("application/x-download; charset=utf-8");
		PrintWriter out = response.getWriter();
		String sql = "";
		try {
			//grass.tree.util.BakMysql bm = new grass.tree.util.BakMysql();
			//sql = bm.backupMySqlToFile();
			BackupToObject bto = new BackupToObject();
			sql = bto.backToObject();
			out.println(sql);
			out.flush();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		out.close();
		return mapping.findForward("goback");
	}

}
