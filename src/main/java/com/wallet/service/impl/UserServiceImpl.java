package com.wallet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entity.Usuario;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public Usuario save(Usuario u) {
		// TODO Auto-generated method stub
		return repository.save(u);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmailEquals(email);
	}
	
}
