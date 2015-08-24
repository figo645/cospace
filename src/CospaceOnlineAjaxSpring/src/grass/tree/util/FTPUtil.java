package grass.tree.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import sun.net.ftp.FtpClient;

/**
 * 
 * @author xcf
 * @version 1.0
 * 
 *          2008-02-19
 * 
 */
public class FTPUtil {

	private String ip = "web337788.host89.chinajsp.net";

	private String username = "web337788";

	private String password = "q0p6d6b2";

	private String ftpDir = "/ROOT/images";

	private String localFileFullName = "";// ���ϴ����ļ�ȫ��

	private String ftpFileName = ""; // �ļ��ϴ���FTP�������

	FtpClient ftpClient = null;

	OutputStream os = null;

	FileInputStream is = null;

	public static void main(String[] args) {
		String ip = "web337788.host89.chinajsp.net";
		String user = "web337788";
		String password = "q0p6d6b2";
		String ftpDir = "/ROOT/images";
		
		
		FTPUtil ftp = new FTPUtil(ip, user, password, ftpDir);
		
		for (int i=0;;i++){
			try {
				Thread.sleep(70000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
			String returnStr = ftp.upload("d://6.jpg");
			System.out.println(returnStr);
			}catch(Exception e){
				break;
			}
		}
	}
	
	public FTPUtil(){
		ip = this.ip;
		username = this.username;
		password = this.password;
		ftpDir = this.ftpDir;
		localFileFullName = this.localFileFullName;
		ftpFileName = this.ftpFileName;
	}
	
	
	public FTPUtil(String serverIP, String username, String password,
			String ftpDir) {

		this.ip = serverIP;
		this.username = username;
		this.password = password;

		if (ftpDir == null) {
			this.ftpDir = "/ftpfileload";
		} else {
			try {
				this.ftpDir = "/"
						+ new String(ftpDir.getBytes("ISO-8859-1"), "GBK")
								.toString();
			} catch (UnsupportedEncodingException e) {
				// TODO �Զ����� catch ��
				e.printStackTrace();
			}
		}

	}

	private void createDir(String dir, FtpClient ftpClient) {
		System.out.println(this.ftpDir);
		ftpClient.sendServer("MKD " + dir + "\r\n");

		try {
			ftpClient.readServerResponse();
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}

	}

	private Boolean isDirExist(String dir, FtpClient ftpClient) {
		try {
			ftpClient.cd(dir);
		} catch (Exception e) {
			// TODO �Զ����� catch ��
			return false;
		}
		return true;
	}
	
	/**
	 * New Upload
	 * @param input
	 * @param localFileFullName
	 * @return
	 */
	public String upload(InputStream input,String localFileFullName){
		// ��ȡ�ļ���׺��
		String ext = localFileFullName.substring(localFileFullName
				.lastIndexOf("."));
		// System.out.println(ext);

		// �������ļ�������ϵͳ��ǰʱ��+�ļ�ԭ�к�׺��
		long newFileName = System.currentTimeMillis();
		String newFileFullName = newFileName + ext;
		// System.out.println("new file name:"+newFileFullName);
		this.ftpFileName = newFileFullName;

		try {
			String savefilename = new String(localFileFullName
					.getBytes("ISO-8859-1"), "GBK");
			// �½�һ��FTP�ͻ�������
			ftpClient = new FtpClient();
			ftpClient.openServer(this.ip);
			ftpClient.login(this.username, this.password);

			// �жϲ�����Ŀ¼
			if (!isDirExist(this.ftpDir, ftpClient)) {
				createDir(this.ftpDir, ftpClient);
			}

			ftpClient.cd(this.ftpDir);// �л���FTPĿ¼
			ftpClient.binary();

			os = ftpClient.put(this.ftpFileName);
			// �򿪱��ش��������ļ�
//			File file_in = new File(savefilename);
			//is = new FileInputStream(input);
			//is = (FileInputStream) input;
			byte[] bytes = new byte[1024];
			

			// ��ʼ����
			int c;
			// ��δ������;��ֹ�����
			while ((c = input.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception e in Ftp upload(): " + e.toString());
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (os != null) {
					os.close();
				}
				if (ftpClient != null) {
					ftpClient.closeServer();
				}
			} catch (Exception e) {
				System.err.println("Exception e in Ftp upload() finally"
						+ e.toString());
			}
		}
		return this.ftpFileName;
	}
    
	public String upload(String localFileFullName) {

		// this.ftpFileName = "aaa.test";

		// ��ȡ�ļ���׺��
		String ext = localFileFullName.substring(localFileFullName
				.lastIndexOf("."));
		// System.out.println(ext);

		// �������ļ�������ϵͳ��ǰʱ��+�ļ�ԭ�к�׺��
		long newFileName = System.currentTimeMillis();
		String newFileFullName = newFileName + ext;
		// System.out.println("new file name:"+newFileFullName);
		this.ftpFileName = newFileFullName;

		try {
			String savefilename = new String(localFileFullName
					.getBytes("ISO-8859-1"), "GBK");
			// �½�һ��FTP�ͻ�������
			ftpClient = new FtpClient();
			ftpClient.openServer(this.ip);
			ftpClient.login(this.username, this.password);

			// �жϲ�����Ŀ¼
			if (!isDirExist(this.ftpDir, ftpClient)) {
				createDir(this.ftpDir, ftpClient);
			}

			ftpClient.cd(this.ftpDir);// �л���FTPĿ¼
			ftpClient.binary();

			os = ftpClient.put(this.ftpFileName);
			// �򿪱��ش��������ļ�
			File file_in = new File(savefilename);
			is = new FileInputStream(file_in);
			byte[] bytes = new byte[1024];

			// ��ʼ����
			int c;
			// ��δ������;��ֹ�����
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception e in Ftp upload(): " + e.toString());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
				if (ftpClient != null) {
					ftpClient.closeServer();
				}
			} catch (Exception e) {
				System.err.println("Exception e in Ftp upload() finally"
						+ e.toString());
			}
		}
		return this.ftpFileName;
	}

	public void delFile(String dir, String filename) {
		ftpClient = new FtpClient();
		try {
			ftpClient.openServer(this.ip);
			ftpClient.login(this.username, this.password);
			if (dir.length() > 0) {
				ftpClient.cd(dir);
			}
			ftpClient.sendServer("DELE " + filename + "\r\n");
			ftpClient.readServerResponse();

		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
	}

}
