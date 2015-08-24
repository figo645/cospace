package grass.tree.dao;

import grass.tree.hibernate.Blogmaster;
import grass.tree.hibernate.BlogmasterDAO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DelRedundantImg {

	public Collection<ImgSrc> analyzeDBBlog() {
		BlogmasterDAO dao = new BlogmasterDAO();
		List listAll = dao.findAll();
		Iterator iterator = listAll.iterator();
		try {
			dao.getSession().beginTransaction().begin();
			while (iterator.hasNext()) {
				Blogmaster blogMaster = (Blogmaster) iterator.next();
				String blogContent = blogMaster.getContent();
				int index = blogContent.indexOf("http://web337788.host89.chinajsp.net");
				System.out.println(index);
				int nextIndex ;
				//while( (nextIndex = blogContent.indexOf("http://web337788.host89.chinajsp.net", index)) != -1){
				//	System.out.println(nextIndex);
				//}
			}
			dao.getSession().beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DelRedundantImg dri = new DelRedundantImg();
		dri.analyzeDBBlog();
	}

	class ImgSrc {
		public long blogid;
		public String imgSrc;

		ImgSrc(long blogid, String imgSrc) {
			this.blogid = blogid;
			this.imgSrc = imgSrc;
		}
	}

}
