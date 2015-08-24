package grass.tree.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharacterEncodingFilter implements Filter {
	protected String encoding = null;

	public void destroy() {
		this.encoding = null;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + "UTF-8");
//		Map map  = request.getParameterMap();
//		Set set = map.entrySet();
//		
//		Iterator it = set.iterator();
//		for (int i=0;it.hasNext();i++){
//			Object key = it.next();
//			System.out.println("Filter:"+key);
//		}
		chain.doFilter(request, response);
	}
}