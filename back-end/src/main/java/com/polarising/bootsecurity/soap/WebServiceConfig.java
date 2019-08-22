package com.polarising.bootsecurity.soap;

import javax.servlet.Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<Servlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);

		return new ServletRegistrationBean<>(servlet, "/bankrising/ws/*");
	}

	@Bean(name = "client")
	public Wsdl11Definition clientWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/client.wsdl"));
	

		return wsdl11Definition;
	}
	
	@Bean(name = "user")
	public Wsdl11Definition userWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();

		wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/user.wsdl"));

		return wsdl11Definition;
	}
	
	@Bean(name = "employee")
	public Wsdl11Definition employeeWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();

		wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/employee.wsdl"));

		return wsdl11Definition;
	}
	
	@Bean(name = "account")
	public Wsdl11Definition accountWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();

		wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/account.wsdl"));

		return wsdl11Definition;
	}
	
	@Bean(name = "transaction")
	public Wsdl11Definition transactionWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();

		wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/transaction.wsdl"));

		return wsdl11Definition;
	}
}
