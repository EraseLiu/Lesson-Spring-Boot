package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class GBKCondition implements Condition {

	private static final Log logger = LogFactory.getLog(GBKCondition.class);

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = context.getEnvironment().getProperty("server.tomcat.uri-encoding");
		logger.info(encoding);
		if (encoding != null)
			return "GBK".equalsIgnoreCase(encoding);
		return false;
	}

}