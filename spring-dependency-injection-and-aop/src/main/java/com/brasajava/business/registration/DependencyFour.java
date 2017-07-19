package com.brasajava.business.registration;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(DependencyFourCondition.class)
public class DependencyFour implements Dependency {

	public void sayWhoYouAre() {
		System.out.println("I am dependency four.");

	}

}
