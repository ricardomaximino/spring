package com.brasajava.business.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Bean {

	@Autowired
	@Qualifier("one")
	private Dependency dependencyOne;
	@Autowired
	@Qualifier("dependencyTwo")
	private Dependency dependencyTwo;
	@Autowired
	@Nice
	private Dependency dependencyThree;
	@Autowired(required=false)
	@Qualifier("dependencyFour")
	private Dependency dependencyFour;
	@Autowired(required=false)
	@Qualifier("dependencyFive")
	private Dependency dependencyFive;

	public Bean() {

	}

	public void pointCut() {

	}

	public void theMethod() {
		System.out.println("The Method");
		dependencyOne.sayWhoYouAre();
		dependencyTwo.sayWhoYouAre();
		dependencyThree.sayWhoYouAre();
		if (dependencyFour != null) {
			dependencyFour.sayWhoYouAre();
		} else {
			System.out.println("The dependencyFour is null");
		}
		if (dependencyFive != null) {
			dependencyFive.sayWhoYouAre();
		} else {
			System.out.println("The dependencyFive is null");
		}
	}
}
