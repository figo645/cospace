package grass.tree.action;

import grass.tree.form.SystemBackForm;
import grass.tree.util.BackupToObject;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class RestoreAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SystemBackForm systemBackForm = (SystemBackForm) form;
		FormFile formFile = systemBackForm.getUploadFile();
		InputStream input = formFile.getInputStream();

		// TODO Auto-generated method stub
		// response.reset();
		// response.setHeader("Content-Disposition",
		// "attachment;filename=Co-spaceDB_Backup.sql");
		// response.setContentType("application/x-download; charset=utf-8");
		// PrintWriter out = response.getWriter();
		// String sql = "";
		try {
			// grass.tree.util.BakMysql bm = new grass.tree.util.BakMysql();
			// bm.restoreMysqlFromFileInputStream(input);
			BackupToObject bto = new BackupToObject();
			bto.restoreFromObject(input);
			// bm.restoreMysqlFromFile(f)
			// sql = bm.backupMySqlToFile();
			// out.println(sql);
			// out.flush();
			//			
		} catch (Exception e) {
			System.out.println(e);
		}
		input.close();
		// out.close();
		return mapping.findForward("goback");
	}

}
