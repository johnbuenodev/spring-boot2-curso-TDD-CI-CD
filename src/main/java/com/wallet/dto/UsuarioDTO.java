package com.wallet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

//data transfer object
//proteger a entidade do sistemas , exibir somente dados que o usuario precisa visualizar

//utiliza JsonInclude.NON_NULL para tratar dados nulos
//não adicionar valores nulos na chamada de retorno

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

	private long id;

	@Email(message="Email invalido")
	private String email;
	@Length(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
	private String name;
	@NotNull
	@Length(min=6, message="A Senha deve conter no minimo 6 caracteres")
	private String password;
	
	
}
