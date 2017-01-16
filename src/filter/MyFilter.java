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
		System.out.println("Start……MydoFilter");
		String[] ignore=toignore.split(",");
		HttpServletRequest request2=(HttpServletRequest)request;
		String rString=request2.getRequestURI();
		boolean isignore=false;
		for (String string : ignore) {
			if(rString.indexOf(string)!=-1){//如果url中包含
				isignore=true;
				break;
			}
		}
		
		if(isignore){
			System.out.println("忽略过滤");
			chain.doFilter(request, response);//传递给下一个Filter
		}else if(request2.getSession().getAttribute("username")!=null){
			//过滤器具体功能是实现，省略……
			chain.doFilter(request, response);
			//对返回servlet执行返回的结果过滤，省略……
		}else {
			//如果Session中没有username,则重定向到login.jsp
			HttpServletResponse response2=(HttpServletResponse)response;
			response2.sendRedirect("login.jsp");
		}
		System.out.println("end……MydoFilter");

	}

	@Override
	public void destroy() {
		System.out.println("destory……MyFilter");
	}
}
