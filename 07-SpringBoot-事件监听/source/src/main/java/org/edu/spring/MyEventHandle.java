package org.edu.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/*
 * 可以根据形参类型来指定是什么什么事件
 */
@Component
public class MyEventHandle {

	private static final Log log = LogFactory.getLog(MyEventHandle.class);

	/*
	 * All
	 */
	@EventListener
	public void onApplicationEvent(ApplicationEvent event) {
		log.info("#A# MyEventHandle.onApplicationEvent(ApplicationEvent event)");
		log.info(event);
	}

	@EventListener
	public void onMyApplicationEvent(MyApplicationEvent event) {
		log.info("#M# MyEventHandle.onMyApplicationEvent(MyApplicationEvent event)");
		log.info(event);
	}

	@EventListener
	public void onContextStoppedEvent(ContextStoppedEvent event) {
		log.info("#-# MyEventHandle.onContextStoppedEvent(ContextStoppedEvent event)");
		log.info(event);
	}

	@EventListener
	public void onApplicationStartingEvent(ApplicationStartingEvent event) {
		log.info("#-# MyEventHandle.onApplicationStartingEvent(ApplicationStartingEvent event)");
		log.info(event);
	}

}
