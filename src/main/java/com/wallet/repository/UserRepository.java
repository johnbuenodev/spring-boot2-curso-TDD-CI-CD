package com.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

    //utiizar a forma escrita estruturada com CAmmelCase para fazer chamada 
	//no banco de forma mais dinamica findByEmailEquals
	Optional<Usuario> findByEmailEquals(String emailtest);
	
	

}
