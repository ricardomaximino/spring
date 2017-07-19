package com.brasajava.business.registration;

import org.springframework.stereotype.Component;

@Component
@Nice
public class DependencyThree implements Dependency {

	public void sayWhoYouAre() {
		System.out.println("I am dependency three.");

	}

}
