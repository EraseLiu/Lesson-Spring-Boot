package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Conditional;

@SpringBootApplication
public class ReadingListApplication {

	@Conditional(JdbcTemplateCondition.class)
	public MyService myService() {
		return new MyService();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReadingListApplication.class, args);
		try {
			context.getBean("myService");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
