package com.fatih.blogproject.config;


import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.fatih.blogproject.web.WebConfig;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {RootConfig.class  ,DbConfig.class ,WebConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	 @Override
     protected Filter[] getServletFilters() {

       CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
       characterEncodingFilter.setEncoding("UTF-8");
       return new Filter[] { characterEncodingFilter};
     }
}
