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
		
		//�ֹ��ж�
		//��ȡ������Դ��
		String url = req.getRequestURL().toString();
		
		boolean �������;
		
		if(url.endsWith("mainPage.jsp")||url.endsWith("qbook")||url.endsWith("department_query.jsp")){
			������� = true; //  �������
		} else {
			������� = false;  // ���������
		}
		
		if(������� == true && phone == null){
			
			//���δ��¼������ת���µ�¼ҳ��
			req.getRequestDispatcher("login.jsp").forward(req, (HttpServletResponse)response);
		} else {
			//����ִ�к���ҵ���߼�
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
