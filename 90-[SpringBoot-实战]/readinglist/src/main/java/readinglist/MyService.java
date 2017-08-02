package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class MyService {

	@Autowired
	private ApplicationContext context;

	@Override
	public String toString() {
		return String.format("MyService [context=%s, getClass()=%s, hashCode()=%s, toString()=%s]", context, getClass(),
				hashCode(), super.toString());
	}

}
