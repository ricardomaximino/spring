package com.brasajava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.brasajava.business.registration.User;
@ComponentScan
public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		for(String s : context.getBeanDefinitionNames()){
			System.out.println(s);
		}
		User user = context.getBean(User.class);
		System.out.println(user);
		((AnnotationConfigApplicationContext)context).close();
	}

}
