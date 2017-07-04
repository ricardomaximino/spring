package com.brasajava.business.registration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Registration {

	@Bean
	public Person person(){
		return new Person(1, "Ricardo Maximino", "Gonçalves de Moraes");
	}
	
	@Bean
	public Address address(){
		return new Address(1, "Spain", "Valencia", "Alicante", "Santa Pola", "centro", "Calle Ganaderos, 24");
	}
	
	@Bean
	public User user(Person person, Address address){
		return new User(1, "ricardomaximino", "Ricardo2", person, address);
	}
}
