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
		pWriter.println("���Ǿ���Listener,Filter,Servlet֮��ĵ�¼��ɽ���");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPostLoginServlet");
		doGet(req, resp);//ִ��doGetͬ���ķ���
	}
	
	@Override
	public void destroy() {
		System.out.println("destroyLoginServlet");
	}
}
