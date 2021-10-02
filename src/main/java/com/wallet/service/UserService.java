package com.wallet.service;

import java.util.Optional;

import com.wallet.entity.Usuario;

public interface UserService {

	Usuario save(Usuario u);
	
	Optional<Usuario> findByEmail(String email);
	
}
