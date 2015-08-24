package grass.tree.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Blogmaster entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see grass.tree.hibernate.Blogmaster
 * @author MyEclipse Persistence Tools
 */

public class BlogmasterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BlogmasterDAO.class);
	// property constants
	public static final String CATEGORIES = "categories";
	public static final String TITLE = "title";
	public static final String TITLEEN = "titleen";
	public static final String CONTENT = "content";

	public void save(Blogmaster transientInstance) {
		log.debug("saving Blogmaster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Blogmaster persistentInstance) {
		log.debug("deleting Blogmaster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Blogmaster findById(java.lang.Long id) {
		log.debug("getting Blogmaster instance with id: " + id);
		try {
			Blogmaster instance = (Blogmaster) getSession().get(
					"grass.tree.hibernate.Blogmaster", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Blogmaster instance) {
		log.debug("finding Blogmaster instance by example");
		try {
			List results = getSession().createCriteria(
					"grass.tree.hibernate.Blogmaster").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Blogmaster instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Blogmaster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findByCategoriesAll(String categories) {
		List returnLst = null;
		try {
			Blogmaster bm = new Blogmaster();
			bm.setCategories(categories);
			Criteria critTop = getSession().createCriteria(bm.getClass());
			critTop.add(Restrictions.and(
					Restrictions.eq("categories",categories),
					Restrictions.ne("topvalue", new Integer(0)))
					).addOrder(Order.asc("topvalue")).addOrder(Order.desc("createdate"));
			
			Criteria critNonTop = getSession().createCriteria(bm.getClass());
			critNonTop.add(
					Restrictions.and(Restrictions.eq("categories",categories),
					Restrictions.eq("topvalue", new Integer(0)))
					).addOrder(Order.desc("createdate"));
			List topLst = critTop.list();
			List nonTopLst = critNonTop.list();
//			select * from (
//					select a.* from blogmaster AS a where
//					a.topvalue <> 0 
//
//					union all
//
//					select b.* from blogmaster AS b where
//					b.topvalue = 0) as c
//
//					where c.categories = 'c002'
//					order by c.topvalue desc, c.createdate desc
			topLst.addAll(nonTopLst);
			returnLst = topLst;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return returnLst;
	}

	public List findByCategories(String categories) {
		List returnLst = null;
		try {
			Blogmaster bm = new Blogmaster();
			bm.setCategories(categories);
			Criteria critTop = getSession().createCriteria(bm.getClass());
			critTop.add(Restrictions.and(Restrictions.and(
					Restrictions.eq("categories",categories),
					Restrictions.ne("topvalue", new Integer(0))),Restrictions.eq("delflg",new Integer(0)))
					).addOrder(Order.asc("topvalue")).addOrder(Order.desc("createdate"));
			
			Criteria critNonTop = getSession().createCriteria(bm.getClass());
			critNonTop.add(Restrictions.and(
					Restrictions.and(Restrictions.eq("categories",categories),
					Restrictions.eq("topvalue", new Integer(0))),Restrictions.eq("delflg",new Integer(0)))
					).addOrder(Order.desc("createdate"));
			List topLst = critTop.list();
			List nonTopLst = critNonTop.list();
//			select * from (
//					select a.* from blogmaster AS a where
//					a.topvalue <> 0 
//
//					union all
//
//					select b.* from blogmaster AS b where
//					b.topvalue = 0) as c
//
//					where c.categories = 'c002'
//					order by c.topvalue desc, c.createdate desc
			topLst.addAll(nonTopLst);
			returnLst = topLst;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return returnLst;
	}
	
	public List findByCategoriesNewsNonDel(String categories) {
		List returnLst = null;
		try {
			Blogmaster bm = new Blogmaster();
			bm.setCategories(categories);
			Criteria critTop = getSession().createCriteria(bm.getClass());
			critTop.add(Restrictions.and(Restrictions.and(
					Restrictions.like("categories",categories,MatchMode.ANYWHERE),
					Restrictions.ne("topvalue", new Integer(0))),Restrictions.eq("delflg",new Integer(0)))
					).addOrder(Order.asc("topvalue")).addOrder(Order.desc("createdate"));
			
			Criteria critNonTop = getSession().createCriteria(bm.getClass());
			critNonTop.add(Restrictions.and(
					Restrictions.and(Restrictions.like("categories",categories,MatchMode.ANYWHERE),
					Restrictions.eq("topvalue", new Integer(0))),Restrictions.eq("delflg",new Integer(0)))
					).addOrder(Order.desc("createdate"));
			List topLst = critTop.list();
			List nonTopLst = critNonTop.list();
//			select * from (
//					select a.* from blogmaster AS a where
//					a.topvalue <> 0 
//
//					union all
//
//					select b.* from blogmaster AS b where
//					b.topvalue = 0) as c
//
//					where c.categories = 'c002'
//					order by c.topvalue desc, c.createdate desc
			topLst.addAll(nonTopLst);
			returnLst = topLst;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return returnLst;
	}
	
	/**
	 * findByCategoriesNews
	 * @param categories
	 * @return
	 */
	public List findByCategoriesNews(String categories) {
		List returnLst = null;
		try {
			System.out.println("BlogmasterDAO.findByCategoriesNews()");
			Blogmaster bm = new Blogmaster();
			bm.setCategories(categories);
			Criteria critTop = getSession().createCriteria(bm.getClass());
			critTop.add(Restrictions.and(
					Restrictions.like("categories",categories,MatchMode.ANYWHERE),
					Restrictions.ne("topvalue", new Integer(0)))
					).addOrder(Order.asc("topvalue")).addOrder(Order.desc("createdate"));
			
			Criteria critNonTop = getSession().createCriteria(bm.getClass());
			critNonTop.add(
					Restrictions.and(Restrictions.like("categories",categories,MatchMode.ANYWHERE),
					Restrictions.eq("topvalue", new Integer(0)))
					).addOrder(Order.desc("createdate"));
			List topLst = critTop.list();
			List nonTopLst = critNonTop.list();
//			select * from (
//					select a.* from blogmaster AS a where
//					a.topvalue <> 0 
//
//					union all
//
//					select b.* from blogmaster AS b where
//					b.topvalue = 0) as c
//
//					where c.categories = 'c002'
//					order by c.topvalue desc, c.createdate desc
			topLst.addAll(nonTopLst);
			returnLst = topLst;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return returnLst;
	}

	public static void main(String[] args) {
		BlogmasterDAO dao = new BlogmasterDAO();
		
		Blogmaster master = dao.findById(5l);
		System.out.println(master);
//		master.setCategories("c001");
//		master.setContent("test");
//		master.setCreatedate(new Date());
//		dao.getSession().beginTransaction().begin();
//		dao.save(master);
//		dao.getSession().beginTransaction().commit();
//		dao.findById(1l);
//		List list1 = dao.findAll();
//		System.out.println(list1.size());
//		List list2 = dao.findByCategories("c002");
//		System.out.println(list2.size());
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByTitleen(Object titleen) {
		return findByProperty(TITLEEN, titleen);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Blogmaster instances");
		try {
			String queryString = "from Blogmaster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Blogmaster merge(Blogmaster detachedInstance) {
		log.debug("merging Blogmaster instance");
		try {
			Blogmaster result = (Blogmaster) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Blogmaster instance) {
		log.debug("attaching dirty Blogmaster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Blogmaster instance) {
		log.debug("attaching clean Blogmaster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}