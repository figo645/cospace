package grass.tree.dao;

import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.Iterator;
import java.util.List;

public class ReplaceBlogImgSrc {
	/**
	 * 
	 * @param oldImgSrc
	 * @param newImgSrc
	 * @return
	 */
	public int replaceImgWithString(String oldImgSrc, String newImgSrc) {
		BlogmasterDAO dao = new BlogmasterDAO();
		List listAll = dao.findAll();
		Iterator iterator = listAll.iterator();
		try {
			dao.getSession().beginTransaction().begin();
			while (iterator.hasNext()) {
				Blogmaster blogMaster = (Blogmaster) iterator.next();
				String blogContent = blogMaster.getContent();

				// http://web337788.host89.chinajsp.net
				blogContent = blogContent.replaceAll(
						oldImgSrc,
						newImgSrc);
				// System.out.println(blogContent);
				blogMaster.setContent(blogContent);
				dao.save(blogMaster);

			}
			dao.getSession().beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param oldTitle
	 * @param newTitle
	 * @return
	 */
	public int replaceENTitleWithString(String oldTitle, String newTitle) {
		BlogmasterDAO dao = new BlogmasterDAO();
		List listAll = dao.findAll();
		Iterator iterator = listAll.iterator();
		try {
			dao.getSession().beginTransaction().begin();
			while (iterator.hasNext()) {
				Blogmaster blogMaster = (Blogmaster) iterator.next();
				blogMaster.setTitleen("");
				//dao.save(blogMaster);
				System.out.println(blogMaster.getBlogid());
			}
			dao.getSession().beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// private int
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceBlogImgSrc replaceBlog = new ReplaceBlogImgSrc();
		replaceBlog.replaceImgWithString("http://web337788.host89.chinajsp.nethttp://web337788.host89.chinajsp.net", "images/");
		//replaceBlog.replaceENTitleWithString("", "");
	}

}
