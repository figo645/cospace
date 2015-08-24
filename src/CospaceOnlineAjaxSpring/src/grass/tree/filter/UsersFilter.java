package grass.tree.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户访问权限的过滤器
 * 
 * @author viano
 */
public class UsersFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 设置请求的字符编码
//		request.setCharacterEncoding("gb2312");
		// 设置返回请求的字符编码
//		response.setCharacterEncoding("gb2312");
		// 转换ServletRequest为 HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// 转换ServletResponse为HttpServletRequest
		HttpServletResponse res = (HttpServletResponse) response;
		// 获取Session
		HttpSession session = req.getSession();
		// 获取Session中存储的对象
		Object o = session.getAttribute("user");
		// 获取当前请求的URI
		String url = req.getRequestURI();
		// 判断Session中的对象是否为空；判断请求的URI是否为不允许过滤的URI
		if (o == null
				&& !url.endsWith("login.jsp") // 对URL地址为此结尾的文件不过滤
				&& url.indexOf(".do") < 0 // 对URL地址中包含此字符串的文件不过滤
				&& url.indexOf("/images/") < 0 
				&& !url.endsWith("news.jsp")
				&& !url.endsWith("design.jsp") 
				&& !url.endsWith("Error.jsp") 
				&& !url.endsWith("about.jsp")
				&& !url.endsWith("research.jsp")
				&& !url.endsWith("welcomespace.jsp")
				&& !url.endsWith("leagues.jsp")
				&& !url.endsWith("interior.jsp")
				&& !url.endsWith("tablehandler.jsp")
				&& !url.endsWith("ajaxheader.jsp")
				&& !url.endsWith(".js")
				&& !url.endsWith(".css")
				&& !url.endsWith(".jpg")
				&& !url.endsWith(".gif")
				&& !url.endsWith(".eot")
				&& !url.endsWith(".ttf")
				&& !url.endsWith(".swf")
				&& !url.endsWith(".svg")
				&& !url.endsWith("/") ) {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(request, response);
			res.setHeader("Cache-Control", "no-store");
			res.setDateHeader("Expires", 0);
			res.setHeader("Pragma", "no-cache");
			res.flushBuffer();
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}