package com.example.ProjetoPos;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests
						.requestMatchers("/", "/login", "/entrar/logar", "/entrar/auth", "/market/marketList",
						"/registros/registro",
						"/registros/salvar")
						.permitAll()
						.anyRequest()
						.authenticated());
		http.formLogin((form) -> form.loginPage("/entrar/logar").defaultSuccessUrl("/home/homeForm", true).permitAll());
		http.logout((form) -> form.deleteCookies("JSESSIONID").logoutSuccessUrl("/entrar/logar"));

		return http.build();
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		final JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.setUsersByUsernameQuery("SELECT nome, senha, 1 as enabled FROM usuario WHERE nome = ?");
		return userDetailsManager;
	}

}
