package grass.tree.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BakMysql {

	// main�ķ�������Ҫ�������ڲ��Եģ�������ȡ��CLASS��·����Ȼ�󱸷ݵ��ļ�д�ڷ���������·����
	public static void main(String[] args) {
		BakMysql bk = new BakMysql();
		bk.restoreMysqlFromFile(new File("c:\\Co-spaceDB_Backup.sql"));
		/*
		 * System.out.println(Thread.currentThread().getContextClassLoader().getResource
		 * (""));
		 * System.out.println(BakMysql.class.getClassLoader().getResource(""));
		 * System.out.println(ClassLoader.getSystemResource(""));
		 * System.out.println(BakMysql.class.getResource(""));
		 * System.out.println(BakMysql.class.getResource("/")); //Class�ļ�����·��
		 * System.out.println(new File("/").getAbsolutePath());
		 * System.out.println(System.getProperty("user.dir"));
		 */
		// bk.backup();
		// bk.load();
		// bk.backupMySql();
	}

	// backup�����Ǳ������ݿ⵽��������ַ
	public void backup() {
		try {
			String filePath = System.getProperty("user.dir") + "\\cospace.sql";// BakMysql.class.getResource("").toString();
			System.out.println();
			Runtime rt = Runtime.getRuntime();
			// ���� mysql �� cmd:
			Process child = rt.exec("mysqldump  -root -123456 cospace");// ���õ�������Ϊutf8�����������utf8
			// ע����һ�䣬��ָ����mysqldump�����������ǵ�¼���͵�¼�����룬���ź������ָ���ݵ����ݿ�����֣����˽������Դ�����һ��ִ�еĽ��̣�ȡ�ô˽��̵������������Ҫ���ݵ��ļ�
			// �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
			InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������

			InputStreamReader xx = new InputStreamReader(in, "utf8");// �������������Ϊutf8�����������utf8����������ж����������

			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			// ��Ͽ���̨�����Ϣ�ַ���
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();// ���ݳ�����������һ��������

			// Ҫ�����������õ�sqlĿ���ļ���
			FileOutputStream fout = new FileOutputStream(filePath);
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
			writer.write(outStr);// д�ļ�
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();

			// �����ǹر����������
			in.close();
			xx.close();
			br.close();
			writer.close();
			fout.close();

			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * ��Ҫʹ�õı��ݹ���
	 * @return
	 */
	public String backupMySqlToFile() {
		String outStr = "";
		try {
			Runtime rt = Runtime.getRuntime();
			
			Process child = rt.exec("/usr/local/mysql/bin/mysqldump -hweb337788.host89.chinajsp.net -uweb337788 -pq0p6d6b2 web337788");// ���õ�������Ϊutf8�����������utf8�ڴ�Ҫע�⣬��ʱ�ᷢ��һ��mysqldump:
																		// Got
																		// error:
																		// 1045�Ĵ��󣬴�ʱmysqldump���������Ҫ���ݵ����ݿ��IP��ַ����mysqldump
																		// -h192.168.0.1
																		// -uroot
																		// -pmysql
																		// dbname�������Ҿ����������������⣬�Ǻ�
																		// //
																		// �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
			InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
			InputStreamReader xx = new InputStreamReader(in, "utf8");// �������������Ϊutf8�����������utf8����������ж����������
			String inStr;
			StringBuffer sb = new StringBuffer("");
			// ��Ͽ���̨�����Ϣ�ַ���
			BufferedReader br = new BufferedReader(xx);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			in.close();
			xx.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStr;
	}

	/**
	 * ������
	 */
	public void load() {
		try {
			String fPath = "c:\\test.sql";
			Runtime rt = Runtime.getRuntime();
			Process child = rt.exec("mysql -root -123456 cospace");
			OutputStream out = child.getOutputStream();// ����̨��������Ϣ��Ϊ�����
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(fPath), "utf8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			out.close();
			br.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��Ҫʹ�õĻ�ԭ����
	 * ���û��ָ����ݵ�ʱ��ֱ�Ӵ�һ���ϴ����ļ�������������Ϳ��Զ����ݿ���лָ���
	 */
	public void restoreMysqlFromFile(File f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			Runtime rt = Runtime.getRuntime();
			Process child = rt.exec("mysql -hweb337788.host89.chinajsp.net -uweb337788 -pq0p6d6b2 web337788");
			// ����ִ�е���mysql����û����������Լ�Ҫ�ָ������ݿ⣬����ִ������������ϴ����ļ������ȡҪִ�е�����
			OutputStream out = child.getOutputStream();// ����̨��������Ϣ��Ϊ�����
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,
					"utf8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			out.close();
			br.close();
			writer.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * ��Ҫʹ�õĻ�ԭ����
	 * ���û��ָ����ݵ�ʱ��ֱ�Ӵ�һ���ϴ����ļ�������������Ϳ��Զ����ݿ���лָ���
	 */
	public void restoreMysqlFromFileInputStream(InputStream fis) {
		try {
			//FileInputStream fis = new FileInputStream(f);
			Runtime rt = Runtime.getRuntime();
			Process child = rt.exec("/usr/local/mysql/bin/mysql -hweb337788.host89.chinajsp.net -uweb337788 -pq0p6d6b2 web337788");
			// ����ִ�е���mysql����û����������Լ�Ҫ�ָ������ݿ⣬����ִ������������ϴ����ļ������ȡҪִ�е�����
			OutputStream out = child.getOutputStream();// ����̨��������Ϣ��Ϊ�����
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,
					"utf8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			out.close();
			br.close();
			writer.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
