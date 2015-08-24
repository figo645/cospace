package grass.tree.util;

import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BackupToObject {

	public String backToObject() {
		String outStr = "";
		StringBuffer s = new StringBuffer("");
		try {
			StringBuffer sb = new StringBuffer("");
			BlogmasterDAO dao = new BlogmasterDAO();

			List list = dao.findAll();
			Iterator it = list.iterator();
			s.append("INSERT INTO `blogmaster` VALUES ");
			int size = list.size();
			int counter = 0;
			while (it.hasNext()) {
				counter++;
				Blogmaster master = (Blogmaster) it.next();
				// System.out.println(master.toString());
				// (5,'c004',1,'居住建筑??','','','2010-12-01',NULL,NULL,NULL,0)
				// String insertOne = "(";
				// insertOne+= master.getBlogid()+",";
				// insertOne+= "'"+master.getCategories()+"'"+",";
				// insertOne+= master.getTopvalue()+",";
				// insertOne+= "'"+master.getTitle()+"'"+",";
				// insertOne+= "'"+master.getTitleen()+"'"+",";
				// insertOne+= "'"+master.getContent()+"'"+",";
				// insertOne+= "'"+master.getCreatedate()+"'"+",";
				// insertOne+= "'"+master.getCreatetime()+"'"+",";
				// insertOne+= "'"+master.getUpdatetime()+"'"+",";
				// insertOne+= "'"+master.getUpdatedate()+"'"+",";
				// insertOne+= master.getDelflg();
				// insertOne += "),";
				s.append("(");
				s.append(master.getBlogid() + ",");
				s.append("'" + master.getCategories() + "'" + ",");
				s.append(master.getTopvalue() + ",");
				s.append("'" + master.getTitle() + "'" + ",");
				s.append("'" + master.getTitleen() + "'" + ",");
				s.append("'" + master.getContent() + "'" + ",");
				s.append(dateFormat(master.getCreatedate()) + ",");
				s.append("NULL" + ",");
				s.append("NULL" + ",");
				s.append(dateFormat(master.getUpdatedate()) + ",");
				s.append(master.getDelflg());
				s.append(")");

				if (counter < size) {
					s.append(",");
				} else {
					s.append(";");
				}
				// s.append(insertOne);
			}
			// 组合控制台输出信息字符串
			// BufferedReader br = new BufferedReader(xx);
			// while ((inStr = br.readLine()) != null) {
			// sb.append(inStr + "\r\n");
			// }
			// outStr = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		outStr = s.toString();
		return outStr;
	}

	public void restoreFromObject(InputStream fis) {
		BlogmasterDAO dao = new BlogmasterDAO();
		Connection con = dao.getSession().connection();
		try {
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(fis,
					"utf8"));
			String inStr = "";
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr);
			}
			outStr = sb.toString();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			st.execute(outStr);
			con.commit();
			
			
			con.close();
			//System.out.println(outStr);
			// OutputStreamWriter writer = new OutputStreamWriter(null, "utf8");
			// writer.write(outStr);
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
			// writer.flush();
			// out.close();
			br.close();
			// writer.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String dateFormat(Date date) {
		if (null != date) {
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
					"yyyy-MM-dd");
			String day = format.format(date);
			day = "'" + day + "'";
			return day;
		} else {
			return "NULL";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
