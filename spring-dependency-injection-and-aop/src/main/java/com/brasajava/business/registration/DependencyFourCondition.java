package com.brasajava.business.registration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.AnnotatedTypeMetadata;


@PropertySource("classpath:application.properties")
public class DependencyFourCondition implements Condition {

	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		return conditionContext.getEnvironment().getActiveProfiles()[0].equals("four");
	}

}
