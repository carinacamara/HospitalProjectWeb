package hospital.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
	//@Autowired
	//private DataSource DataSource;
	

	@Autowired
	//@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		DriverManagerDataSource DataSource = new DriverManagerDataSource();
		DataSource.setDriverClassName("com.mysql.jdbc.Driver");
		DataSource.setUrl("jdbc:mysql://localhost:3306/Hospital");
		DataSource.setUsername("root");
		DataSource.setPassword("root");

	  auth.jdbcAuthentication().dataSource(DataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from User where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from User_role where username=?");
	}
	
	
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/secretary/**").access("hasRole('ROLE_SEC')")
			.antMatchers("/doctor/**").access("hasRole('ROLE_DOC')")
			//.and()
			//	.formLogin().loginPage("/login").failureUrl("/login?error")
				//	.usernameParameter("username").passwordParameter("password")
			//.and()
				//.logout().logoutSuccessUrl("/login?logout")
		        .antMatchers("/").permitAll()
		        .and().formLogin()
				.and().exceptionHandling().accessDeniedPage("/403")
				.and().csrf();
		
	}

}