package com.brasajava.business.registration;

import org.springframework.stereotype.Component;
//@Primary
@Component(value="one")
public class DependencyOne implements Dependency {

	public void sayWhoYouAre() {
		System.out.println("I am dependency One.");

	}

}
