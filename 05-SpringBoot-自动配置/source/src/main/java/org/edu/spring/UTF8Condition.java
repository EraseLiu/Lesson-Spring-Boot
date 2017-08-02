package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UTF8Condition implements Condition {

	private static final Log logger = LogFactory.getLog(UTF8Condition.class);

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = context.getEnvironment().getProperty("server.tomcat.uri-encoding");
		logger.info(encoding);
		if (encoding != null)
			return "UTF-8".equalsIgnoreCase(encoding);
		return false;
	}

}