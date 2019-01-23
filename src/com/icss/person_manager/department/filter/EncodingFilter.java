package com.icss.person_manager.department.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebFilter;

//ע������
//@WebFilter(initParams={})
public class EncodingFilter implements Filter {

	private String requestCoding;
	private String responseCoding;

	/**
	 * ִֻ��һ��
	 * ����
	 */
	public void destroy() {
		System.out.println("------------destroy-----------");
	}

	/**
	 * �ᱻִ��N��
	 * ���˷���
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�����ַ���
		request.setCharacterEncoding(requestCoding);
		response.setCharacterEncoding(responseCoding);
		System.out.println("------------doFilter-----------");
		//���Ҫִ�к���ҵ�������ִ��������δ���
		chain.doFilter(request, response);
	}

	/**
	 * ִֻ��һ��
	 * ��ʼ��
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("------------init-----------" + this);
		requestCoding = fConfig.getInitParameter("request_coding");
		responseCoding = fConfig.getInitParameter("response_coding");
		System.out.println("requestCoding="+requestCoding);
		System.out.println("responseCoding="+responseCoding);
	}

}
