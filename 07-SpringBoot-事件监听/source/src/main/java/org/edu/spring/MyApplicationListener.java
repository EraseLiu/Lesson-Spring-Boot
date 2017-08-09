package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

	private static final Log log = LogFactory.getLog(MyApplicationListener.class);

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		log.info("MyApplicationListener.onApplicationEvent(MyApplicationEvent event)");
		log.info(event);
	}

}
