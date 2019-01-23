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

//注解配置
//@WebFilter(initParams={})
public class EncodingFilter implements Filter {

	private String requestCoding;
	private String responseCoding;

	/**
	 * 只执行一次
	 * 销毁
	 */
	public void destroy() {
		System.out.println("------------destroy-----------");
	}

	/**
	 * 会被执行N次
	 * 过滤方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//设置字符集
		request.setCharacterEncoding(requestCoding);
		response.setCharacterEncoding(responseCoding);
		System.out.println("------------doFilter-----------");
		//如果要执行后续业务，则必须执行下面这段代码
		chain.doFilter(request, response);
	}

	/**
	 * 只执行一次
	 * 初始化
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("------------init-----------" + this);
		requestCoding = fConfig.getInitParameter("request_coding");
		responseCoding = fConfig.getInitParameter("response_coding");
		System.out.println("requestCoding="+requestCoding);
		System.out.println("responseCoding="+responseCoding);
	}

}
