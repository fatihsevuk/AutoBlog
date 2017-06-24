package com.fatih.blogproject.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fatih.blogproject.config.DbConfig;


@Configuration
@EnableWebMvc
@ComponentScan("com.fatih.blogproject.web")
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setContentType("text/html; charset=UTF-8");
		return resolver;
		
	}
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	  }
	  
	  @Bean
		public static PropertySourcesPlaceholderConfigurer sourcesPlaceholderConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	  
	 
	  
}
