package com.example.ProjetoPos.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ProjetoPos.model.Usuario;
import com.example.ProjetoPos.repository.UsuarioRepository;

@Service
public class UsuarioManager implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Usuario usuario = usuarioRepository.findByNome(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado: " + username);
		}
		return org.springframework.security.core.userdetails.User.withUsername(username).password(usuario.getSenha())
				.roles("Usuario").build();
	}

	public void save(Usuario user) {
		final String senhaCriptografada = passwordEncoder.encode(user.getSenha());
		user.setSenha(senhaCriptografada);
		usuarioRepository.save(user);
	}

	public boolean autenticarUsuario(String username, String senha) {
		final UserDetails userDetails = loadUserByUsername(username);
		final String test = passwordEncoder.encode(senha);
		return passwordEncoder.matches(senha, userDetails.getPassword());
	}
}
