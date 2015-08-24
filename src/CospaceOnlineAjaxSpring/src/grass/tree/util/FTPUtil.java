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

	private String localFileFullName = "";// 待上传的文件全名

	private String ftpFileName = ""; // 文件上传到FTP后的名称

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
				// TODO 自动生成 catch 块
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
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

	}

	private Boolean isDirExist(String dir, FtpClient ftpClient) {
		try {
			ftpClient.cd(dir);
		} catch (Exception e) {
			// TODO 自动生成 catch 块
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
		// 获取文件后缀名
		String ext = localFileFullName.substring(localFileFullName
				.lastIndexOf("."));
		// System.out.println(ext);

		// 产生新文件名，用系统当前时间+文件原有后缀名
		long newFileName = System.currentTimeMillis();
		String newFileFullName = newFileName + ext;
		// System.out.println("new file name:"+newFileFullName);
		this.ftpFileName = newFileFullName;

		try {
			String savefilename = new String(localFileFullName
					.getBytes("ISO-8859-1"), "GBK");
			// 新建一个FTP客户端连接
			ftpClient = new FtpClient();
			ftpClient.openServer(this.ip);
			ftpClient.login(this.username, this.password);

			// 判断并创建目录
			if (!isDirExist(this.ftpDir, ftpClient)) {
				createDir(this.ftpDir, ftpClient);
			}

			ftpClient.cd(this.ftpDir);// 切换到FTP目录
			ftpClient.binary();

			os = ftpClient.put(this.ftpFileName);
			// 打开本地待长传的文件
//			File file_in = new File(savefilename);
			//is = new FileInputStream(input);
			//is = (FileInputStream) input;
			byte[] bytes = new byte[1024];
			

			// 开始复制
			int c;
			// 暂未考虑中途终止的情况
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

		// 获取文件后缀名
		String ext = localFileFullName.substring(localFileFullName
				.lastIndexOf("."));
		// System.out.println(ext);

		// 产生新文件名，用系统当前时间+文件原有后缀名
		long newFileName = System.currentTimeMillis();
		String newFileFullName = newFileName + ext;
		// System.out.println("new file name:"+newFileFullName);
		this.ftpFileName = newFileFullName;

		try {
			String savefilename = new String(localFileFullName
					.getBytes("ISO-8859-1"), "GBK");
			// 新建一个FTP客户端连接
			ftpClient = new FtpClient();
			ftpClient.openServer(this.ip);
			ftpClient.login(this.username, this.password);

			// 判断并创建目录
			if (!isDirExist(this.ftpDir, ftpClient)) {
				createDir(this.ftpDir, ftpClient);
			}

			ftpClient.cd(this.ftpDir);// 切换到FTP目录
			ftpClient.binary();

			os = ftpClient.put(this.ftpFileName);
			// 打开本地待长传的文件
			File file_in = new File(savefilename);
			is = new FileInputStream(file_in);
			byte[] bytes = new byte[1024];

			// 开始复制
			int c;
			// 暂未考虑中途终止的情况
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
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}

}
