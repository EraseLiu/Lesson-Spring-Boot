package org.edu.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author JinXiang_Liu
 *
 */
@Component
public class UseBean implements InitializingBean, SpringContextAware {

	private ApplicationContext applicationContext;

	private Object01 object01;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.print(3);
		System.out.println("	org.edu.spring.UseBean.afterPropertiesSet");
	}

	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		System.out.print(1);
		System.out.print("	org.edu.spring.UseBean.setApplicationContext:	");
		System.out.println(applicationContext.getId());
	}

	@Override
	public void setContext(ApplicationContext applicationContext, Object01 object01) {
		this.applicationContext = applicationContext;
		this.object01 = object01;
	}

	@Override
	public String toString() {
		return String.format("UseBean [applicationContext=%s, object01=%s]", applicationContext, object01);
	}

}
