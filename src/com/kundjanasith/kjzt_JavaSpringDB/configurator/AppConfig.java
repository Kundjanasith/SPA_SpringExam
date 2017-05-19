package com.kundjanasith.kjzt_JavaSpringDB.configurator;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tiles.web.util.TilesDecorationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.kundjanasith.kjzt_JavaSpringDB.database.BookJDBCTemplate;
import com.kundjanasith.kjzt_JavaSpringDB.database.PatternJDBCTemplate;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kundjanasith.kjzt_JavaSpringDB")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tc = new TilesConfigurer();
		tc.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
		tc.setCheckRefresh(true);
		return tc;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/assignment3?useUnicode=yes&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
//	@Bean
//	public StudentJDBCTemplate getStudentJDBCTemplate() {
//		StudentJDBCTemplate studentJDBCTemplate = new StudentJDBCTemplate();
//		studentJDBCTemplate.setDataSource(getDataSource());
//		return studentJDBCTemplate;
//	}
	
	@Bean
	public PatternJDBCTemplate getPatternJDBCTemplate() {
		PatternJDBCTemplate patternJDBCTemplate = new PatternJDBCTemplate();
		patternJDBCTemplate.setDataSource(getDataSource());
		return patternJDBCTemplate;
	}
	
}



