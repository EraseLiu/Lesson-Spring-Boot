package readinglist;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final Log logger = LogFactory.getLog(SecurityConfig.class);

	@Autowired
	private ReaderRepository readerRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("readinglist.SecurityConfig.configure(HttpSecurity http)");
		http.authorizeRequests().antMatchers("/").access("hasRole('READER')").antMatchers("/**").permitAll().and()
				.formLogin().loginPage("/login").failureUrl("/login?error=true");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("readinglist.SecurityConfig.configure(AuthenticationManagerBuilder auth)");
		auth.userDetailsService(new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return readerRepository.findOne(username);
			}

		});
	}

}
