package com.topgames.topgames.security;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import 
org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.topgames.topgames.model.Usuario;
import com.topgames.topgames.repository.usuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private usuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String userName) 
		throws UsernameNotFoundException {

		Optional<Usuario> usuario = repository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + 
		" não encontrado."));

		return usuario.map(UserDetailsImpl::new).get();
	}
}