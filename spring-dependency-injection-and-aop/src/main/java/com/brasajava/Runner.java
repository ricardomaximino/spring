package com.brasajava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.AbstractEnvironment;

import com.brasajava.business.registration.Bean;
@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class Runner {

	public static void main(String[] args) {
		 System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "four,fives");
		ApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		
		for(String s : context.getBeanDefinitionNames()){
			System.out.println(s);
			System.out.println(context.getBean(s).getClass());
		}
		Bean bean = (Bean) context.getBean("bean");
		bean.theMethod();
		((AnnotationConfigApplicationContext)context).close();
	}

}
