package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UsuarioDTO;
import com.wallet.entity.Usuario;
import com.wallet.response.Response;
import com.wallet.service.UserService;
import com.wallet.utils.Bcrypt;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Response<UsuarioDTO>> create(@Valid @RequestBody UsuarioDTO dto, BindingResult result){
		
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		
		//verificando se tem algum erro dentro do result que foi capturado atraves do @valid no objeto dto
		if(result.hasErrors()) {
			//vai mapear e interar atraves do lambda para retornar pelo response o resultado dos erros
			//pega e add no response errors o erro.getDefaultMessage que fica no @anotation da classe do objeto
			///no Caso o dto
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		//Save espera um Usuario
		Usuario novoUsuario = service.save(this.convertDtoToEntity(dto));
		
		//response espera um UsuarioDTO
		response.setData(this.convertEntityToDto(novoUsuario));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private Usuario convertDtoToEntity(UsuarioDTO dto) {
		
		Usuario u = new Usuario();
		u.setId(dto.getId());
		u.setEmail(dto.getEmail());
		u.setName(dto.getName());
		//criptografar a senha
		u.setPassword(Bcrypt.getHash(dto.getPassword()));
		
		return u;
	}
	
	private UsuarioDTO convertEntityToDto(Usuario u) {
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(u.getId());
		dto.setEmail(u.getEmail());
		dto.setName(u.getName());
		//criptografar a senha
		///dto.setPassword(u.getPassword());
		
		return dto;	
	}
	
}
