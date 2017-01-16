package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("initMyFilter2");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Start……MydoFilter2");
		chain.doFilter(request, response);//传递给下一个Filter
		System.out.println("end……MydoFilter2");

	}

	@Override
	public void destroy() {
		System.out.println("destory……MyFilter2");
	}
}
