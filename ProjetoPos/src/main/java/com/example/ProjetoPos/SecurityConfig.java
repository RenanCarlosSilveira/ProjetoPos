package com.example.ProjetoPos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ProjetoPos.manager.UsuarioManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UsuarioManager manager;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/", "/login", "/market/marketList", "/registros/registro",
						"/registros/salvar")
						.permitAll()
						.anyRequest()
						.authenticated());
		http.formLogin((form) -> form.loginPage("/login").permitAll().defaultSuccessUrl("/home/homeForm", true));
		http.logout((form) -> form.logoutSuccessUrl("/login"));

		return http.build();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(manager).passwordEncoder(new BCryptPasswordEncoder());
	}

}
