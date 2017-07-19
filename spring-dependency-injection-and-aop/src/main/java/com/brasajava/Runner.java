package com.brasajava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.brasajava.business.registration.Bean;
@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		
	/*	for(String s : context.getBeanDefinitionNames()){
			System.out.println(s);
			System.out.println(context.getBean(s).getClass());
		}*/
		Bean bean = (Bean) context.getBean("bean");
		bean.theMethod();
		((AnnotationConfigApplicationContext)context).close();
	}

}
