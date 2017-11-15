package org.musql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private void GlobalConfig(AuthenticationManagerBuilder authenticationManagerBuilder,DataSource datasource) throws Exception
	{
		/*authenticationManagerBuilder.inMemoryAuthentication().withUser("Mehdi").password("123").roles("ADMIN");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("Somaya").password("123").roles("PROF");
		authenticationManagerBuilder.inMemoryAuthentication().withUser("Imane").password("123").roles("PROF");
		*/
		String query="select username as principal, password as credentials ,true from users where username=?";
		authenticationManagerBuilder.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(query)
		.authoritiesByUsernameQuery("select users_username as principal,list_roles_nom as role FROM users_roles where users_username=?").rolePrefix("ROLE_");
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/css/**","/js/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/index.html");
	}
}
