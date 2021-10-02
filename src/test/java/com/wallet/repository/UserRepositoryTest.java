package com.wallet.repository;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.Usuario;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	private static final String EMAILTEST = "setup@gmail.com";
	
	@Autowired
	UserRepository repository;
	
	@BeforeEach
	public void setUp() {
		
		Usuario usertest = new Usuario();
		usertest.setName("Setup user");
		usertest.setPassword("32165");
		usertest.setEmail(EMAILTEST);
		
		repository.save(usertest);
		
	}
	
	@AfterEach
	public void tearDown() {
		
		repository.deleteAll();
		
	}
	
	@Test
	public void testSalvarUser() {
		
		Usuario u = new Usuario();
		u.setName("teste");
		u.setEmail("teste@gmail.com");
		u.setPassword("123456");
		
		Usuario usuarioNew = repository.save(u);
		
		//verifica se o usuario não é nulo
		Assertions.assertNotNull(usuarioNew);

		
	}
	
	@Test
	public void testFindByEmail() {
		
		Optional<Usuario> usuarioSalvo = repository.findByEmailEquals(EMAILTEST);
		
		//verificar se o usuario existe
		Assertions.assertTrue(usuarioSalvo.isPresent());
		
		Assertions.assertEquals(usuarioSalvo.get().getEmail(), EMAILTEST);
		
	}
	
}
