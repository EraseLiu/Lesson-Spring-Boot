package readinglist;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JdbcTemplateCondition implements Condition {

	private static final Log logger = LogFactory.getLog(JdbcTemplateCondition.class);

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

}
