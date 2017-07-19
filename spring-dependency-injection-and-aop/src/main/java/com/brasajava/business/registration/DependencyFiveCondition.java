package com.brasajava.business.registration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DependencyFiveCondition implements Condition{

	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		return conditionContext.getBeanFactory().containsBean("runner");
	}

}
