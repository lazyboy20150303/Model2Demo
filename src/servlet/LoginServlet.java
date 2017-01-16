package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("initLoginServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGetLoginServlet");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter=resp.getWriter();
		pWriter.println("这是经过Listener,Filter,Servlet之后的登录完成界面");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPostLoginServlet");
		doGet(req, resp);//执行doGet同样的方法
	}
	
	@Override
	public void destroy() {
		System.out.println("destroyLoginServlet");
	}
}
