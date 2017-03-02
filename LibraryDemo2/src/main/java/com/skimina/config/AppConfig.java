package com.skimina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.skimina.schedulers.SimpleScheduler;

@Configuration
@ComponentScan(basePackages = "com.skimina")
@EnableWebMvc
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("test@gmail.com");
		mailSender.setPassword("test");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
		mailSender.getJavaMailProperties().setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailSender;
	}

	@Bean
	public SimpleScheduler demoServiceMethod() {
		return new SimpleScheduler();
	}
}
