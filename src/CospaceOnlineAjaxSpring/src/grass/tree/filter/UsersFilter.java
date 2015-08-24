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
 * �û�����Ȩ�޵Ĺ�����
 * 
 * @author viano
 */
public class UsersFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ����������ַ�����
//		request.setCharacterEncoding("gb2312");
		// ���÷���������ַ�����
//		response.setCharacterEncoding("gb2312");
		// ת��ServletRequestΪ HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// ת��ServletResponseΪHttpServletRequest
		HttpServletResponse res = (HttpServletResponse) response;
		// ��ȡSession
		HttpSession session = req.getSession();
		// ��ȡSession�д洢�Ķ���
		Object o = session.getAttribute("user");
		// ��ȡ��ǰ�����URI
		String url = req.getRequestURI();
		// �ж�Session�еĶ����Ƿ�Ϊ�գ��ж������URI�Ƿ�Ϊ��������˵�URI
		if (o == null
				&& !url.endsWith("login.jsp") // ��URL��ַΪ�˽�β���ļ�������
				&& url.indexOf(".do") < 0 // ��URL��ַ�а������ַ������ļ�������
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