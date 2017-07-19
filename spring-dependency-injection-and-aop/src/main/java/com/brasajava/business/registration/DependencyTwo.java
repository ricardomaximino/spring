package com.brasajava.business.registration;

import org.springframework.stereotype.Component;

@Component
public class DependencyTwo implements Dependency {

	public void sayWhoYouAre() {
		System.out.println("I am dependency two.");

	}

}
