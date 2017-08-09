package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 2948393289098339763L;

	private static final Log log = LogFactory.getLog(MyApplicationEvent.class);

	public MyApplicationEvent(Object source) {
		super(source);
		log.info("MyApplicationEvent(Object source)");
		log.info(source);
	}

}
