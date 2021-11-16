package com.soses.hris.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

//@Configuration
public class ThymeleafConfig {

	@Bean
	public ThymeleafViewResolver viewResolver(MessageSource messageSource) {
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(templateEngine(messageSource));
	    viewResolver.setCharacterEncoding("UTF-8");
	    viewResolver.setViewNames(new String[] { ".html" });
	    viewResolver.setOrder(1);
	    return viewResolver;
	}
	
	@Bean
	@Description("Thymeleaf Template Resolver")
	public SpringResourceTemplateResolver templateResolver() {
	    final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	    templateResolver.setPrefix("classpath:/templates/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    return templateResolver;
	}
	 
	@Bean
	public SpringTemplateEngine templateEngine(MessageSource messageSource) {
	    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver());
	    templateEngine.setMessageSource(messageSource);
	    return templateEngine;
	}
}
