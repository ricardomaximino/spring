package com.brasajava.business.registration;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(DependencyFiveCondition.class)
public class DependencyFive implements Dependency {

	public void sayWhoYouAre() {
		System.out.println("I am dependency five.");

	}

}
