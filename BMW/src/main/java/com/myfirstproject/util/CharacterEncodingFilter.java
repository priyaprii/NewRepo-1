package com.myfirstproject.util;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.engine.FilterDefinition;


public class CharacterEncodingFilter implements Filter {

    protected String encoding;

    public void init1(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter1(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding(encoding);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        encoding = null;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public FilterDefinition getFilterDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	public Filter setParameter(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Filter setParameterList(String name, Collection values) {
		// TODO Auto-generated method stub
		return null;
	}

	public Filter setParameterList(String name, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	public void validate() throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}