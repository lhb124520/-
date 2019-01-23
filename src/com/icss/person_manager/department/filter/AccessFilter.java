package com.icss.person_manager.department.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AccessFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String phone = (String) req.getSession().getAttribute("username");
		
		//手工判断
		//获取请求资源名
		String url = req.getRequestURL().toString();
		
		boolean 必须控制;
		
		if(url.endsWith("mainPage.jsp")||url.endsWith("qbook")||url.endsWith("department_query.jsp")){
			必须控制 = true; //  必须控制
		} else {
			必须控制 = false;  // 不必须控制
		}
		
		if(必须控制 == true && phone == null){
			
			//如果未登录，则跳转重新登录页面
			req.getRequestDispatcher("login.jsp").forward(req, (HttpServletResponse)response);
		} else {
			//继续执行后续业务逻辑
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
