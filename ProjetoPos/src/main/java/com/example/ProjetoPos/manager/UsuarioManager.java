package com.example.ProjetoPos.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetoPos.model.Usuario;
import com.example.ProjetoPos.repository.UsuarioRepository;

@Service
public class UsuarioManager implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Usuario usuario = buscarPorEmail(username);
		return new User(usuario.getEmail(), usuario.getSenha(), AuthorityUtils.NO_AUTHORITIES);
	}

	@Transactional(readOnly = false)
	public void salvarUsuario(Usuario usuario) throws Exception {
		final String crypt = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(crypt);
		repository.save(usuario);
	}

	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {

		return repository.findById(id).get();
	}
}
