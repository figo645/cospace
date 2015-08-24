package grass.tree.hibernate;

import java.sql.Time;
import java.util.Date;

/**
 * Blogmaster entity. @author MyEclipse Persistence Tools
 */

public class Blogmaster implements java.io.Serializable, Comparable {

	// Fields

	private Long blogid;
	private String categories;
	private Integer topvalue;
	private Integer delflg;

	public Integer getDelflg() {
		return delflg;
	}

	public void setDelflg(Integer delflg) {
		this.delflg = delflg;
	}

	public Integer getTopvalue() {
		return topvalue;
	}

	public void setTopvalue(Integer topvalue) {
		this.topvalue = topvalue;
	}

	private String categoriesCN;

	public String getCategoriesCN() {
		if (categories.equals("c001")) {
			categoriesCN = "关于合作";
		} else if (categories.equals("c002")) {
			categoriesCN = "合城新闻";
		} else if (categories.equals("c003")) {
			categoriesCN = "规划及城市设计";
		} else if (categories.startsWith("c004")) {
			categoriesCN = "公共建筑设计";
		} else if (categories.equals("c005")) {
			categoriesCN = "居住建筑设计";
		} else if (categories.equals("c006")) {
			categoriesCN = "景观设计";
		} else if (categories.equals("c007")) {
			categoriesCN = "室内设计";
		}

		return categoriesCN;
	}

	private String title;
	private String titleen;
	private String content;
	private Date createdate;
	private Time createtime;
	private Time updatetime;
	private Date updatedate;
	private String formatCreatedate;

	// Constructors

	public String getFormatCreatedate() {
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"MM.dd");
		String day = format.format(this.createdate);
		return day;
	}

	/** default constructor */
	public Blogmaster() {
	}

	/** minimal constructor */
	public Blogmaster(Long blogid, String title, Date createdate,
			Time createtime) {
		this.blogid = blogid;
		this.title = title;
		this.createdate = createdate;
		this.createtime = createtime;
	}

	/** full constructor */
	public Blogmaster(Long blogid, String categories, String title,
			String titleen, String content, Date createdate, Time createtime,
			Time updatetime, Date updatedate) {
		this.blogid = blogid;
		this.categories = categories;
		this.title = title;
		this.titleen = titleen;
		this.content = content;
		this.createdate = createdate;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.updatedate = updatedate;
	}

	// Property accessors

	public Long getBlogid() {
		return this.blogid;
	}

	public void setBlogid(Long blogid) {
		this.blogid = blogid;
	}

	public String getCategories() {
		return this.categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleen() {
		return this.titleen;
	}

	public void setTitleen(String titleen) {
		this.titleen = titleen;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Time getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Time createtime) {
		this.createtime = createtime;
	}

	public Time getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Time updatetime) {
		this.updatetime = updatetime;
	}

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Blogmaster name = (Blogmaster) o;
		int k = topvalue.compareTo(name.topvalue);

		if (topvalue == 0) {
			return -1;
		}
		return k;

		// return (k == 0 ? k : createdate.compareTo(name.createdate));

	}

}