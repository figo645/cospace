package grass.tree.form;

import java.sql.Time;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SubBlogForm extends ActionForm {
	private long Id;
	private String blogtitle;
	private String blogtitleen;
	private String blogcontent;
	private String categories;
	private String newsdate;
	public String getNewsdate() {
		return newsdate;
	}

	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}

	private int topvalue;
	private int delflg;

	public int getDelflg() {
		return delflg;
	}

	public void setDelflg(int delflg) {
		this.delflg = delflg;
	}

	public int getTopvalue() {
		return topvalue;
	}

	public void setTopvalue(int topvalue) {
		this.topvalue = topvalue;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
		this.setCategories(categories);
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	private String createdate;
	private String createtime;
	private String updatetime;
	private String updatedate;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("Id");
		buffer.append(Id);
		buffer.append("\n");
		buffer.append("blogtitle");
		buffer.append(blogtitle);
		buffer.append("\n");
		buffer.append("blogtitleen");
		buffer.append(blogtitleen);
		buffer.append("\n");
		buffer.append("blogcontent");
		buffer.append(blogcontent);
		buffer.append("\n");
		buffer.append("createdate");
		buffer.append(createdate);
		buffer.append("\n");
		buffer.append("createtime");
		buffer.append(createtime);
		buffer.append("\n");
		buffer.append("updatetime");
		buffer.append(updatetime);
		buffer.append("\n");
		buffer.append("updatedate");
		buffer.append(updatedate);
		buffer.append("\n");
		return buffer.toString();
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getBlogtitleen() {
		return blogtitleen;
	}

	public void setBlogtitleen(String blogtitleen) {
		this.blogtitleen = blogtitleen;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getBlogcontent() {
		return blogcontent;
	}

	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
}
