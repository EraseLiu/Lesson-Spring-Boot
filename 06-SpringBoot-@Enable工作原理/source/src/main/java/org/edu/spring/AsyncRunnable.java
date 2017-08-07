package org.edu.spring;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Async
@Component
public class AsyncRunnable implements Runnable {

	private static final Log logger = LogFactory.getLog(AsyncRunnable.class);

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				TimeUnit.SECONDS.sleep(1);
				logger.info("================: " + i);
			}
		} catch (InterruptedException e) {
			logger.error(e);
			Thread.currentThread().interrupt();
		}
	}

}
