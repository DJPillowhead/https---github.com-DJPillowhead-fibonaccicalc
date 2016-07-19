package hello;

// Security config part of the app

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/default.css","/fonts.css","/fonts").permitAll() // These pages don't require any authentication
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login") // The login page
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    	// LDAP auth is used against an OpenLDAP server (could be any other type of LDAP also)
    	
    	auth
		.ldapAuthentication()
			.userDnPatterns("uid={0},ou=People")
			.contextSource().url("ldap://localhost:389/dc=maxcrc,dc=com"); 

    }
    
}
