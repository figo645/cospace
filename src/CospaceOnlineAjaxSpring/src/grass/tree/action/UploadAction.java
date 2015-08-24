package grass.tree.action;

import grass.tree.common.CommonBaseAction;
import grass.tree.form.UploadForm;
import grass.tree.util.FTPUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UploadAction extends CommonBaseAction {

	public ActionForward doExcecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UploadForm uploadForm = (UploadForm) form;
		// get file
		FormFile formFile = uploadForm.getUploadFile();
		// String uploadFile = request.getParameter("uploadFile");
		// connect to ftp
		// put into ftp
		// create name
		try {
			InputStream input = formFile.getInputStream();
			String ip = "web337788.host89.chinajsp.net";
			String user = "web337788";
			String password = "q0p6d6b2";
			String ftpDir = "/ROOT/images";
			FTPUtil ftpUtil = new FTPUtil(ip, user, password, ftpDir);
			// FTPUtil ftpUtil = new FTPUtil();
			// System.out.println(uploadFile);
			String returnFile = ftpUtil.upload(input, formFile.getFileName());
			String WebURL = request.getRemoteAddr();

			String formFileURL = "http://web337788.host89.chinajsp.net/images/"
					+ returnFile;
			uploadForm.setFtpFileName(formFileURL);
			//System.out.println(formFileURL);
			request.getSession().setAttribute("pagePath", formFileURL);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapping.findForward("endOfUpload");
	}
}
