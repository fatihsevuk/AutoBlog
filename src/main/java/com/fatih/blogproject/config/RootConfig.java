package com.fatih.blogproject.config;



import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.fatih.blogproject.config.RootConfig.WebPackage;

@Configuration
@ComponentScan(basePackages={"com.fatih.blogproject"}, 
    excludeFilters={
        @Filter(type=FilterType.CUSTOM, value=WebPackage.class)
    })

public class RootConfig {
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("blogproject\\.web"));
    }    
  }
}
