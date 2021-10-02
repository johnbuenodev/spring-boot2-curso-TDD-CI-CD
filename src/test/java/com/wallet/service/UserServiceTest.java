package com.wallet.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;
import com.wallet.entity.Usuario;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
	
	@MockBean
	UserRepository repository;
	
	@Autowired
	UserService service;
	
	@BeforeEach
	public void setUp() {
		//quando for chamado ofindByEmailEquals vai receber um usuario mocado
		BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new Usuario()));
	}

	@Test
	public void testFindByEmail() {
		Optional<Usuario> newUser = service.findByEmail("setup@gmail.com");
		
		Assertions.assertTrue(newUser.isPresent());
	}
	
}
