package grass.tree.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class SystemBackForm extends ActionForm {
	private FormFile uploadFile;
	private String ftpFileName;

	public String getFtpFileName() {
		return ftpFileName;
	}

	public void setFtpFileName(String ftpFileName) {
		this.ftpFileName = ftpFileName;
	}

	public FormFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
