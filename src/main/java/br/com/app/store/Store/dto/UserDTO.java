package br.com.app.store.Store.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDTO {

	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;
	
	public UserDTO(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	

}
