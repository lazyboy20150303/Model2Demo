package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	private String toignore="";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("initMyFilter");
		toignore=filterConfig.getInitParameter("toignore");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Start����MydoFilter");
		String[] ignore=toignore.split(",");
		HttpServletRequest request2=(HttpServletRequest)request;
		String rString=request2.getRequestURI();
		boolean isignore=false;
		for (String string : ignore) {
			if(rString.indexOf(string)!=-1){//���url�а���
				isignore=true;
				break;
			}
		}
		
		if(isignore){
			System.out.println("���Թ���");
			chain.doFilter(request, response);//���ݸ���һ��Filter
		}else if(request2.getSession().getAttribute("username")!=null){
			//���������幦����ʵ�֣�ʡ�ԡ���
			chain.doFilter(request, response);
			//�Է���servletִ�з��صĽ�����ˣ�ʡ�ԡ���
		}else {
			//���Session��û��username,���ض���login.jsp
			HttpServletResponse response2=(HttpServletResponse)response;
			response2.sendRedirect("login.jsp");
		}
		System.out.println("end����MydoFilter");

	}

	@Override
	public void destroy() {
		System.out.println("destory����MyFilter");
	}
}
