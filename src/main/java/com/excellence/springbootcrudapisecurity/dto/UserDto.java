package com.excellence.springbootcrudapisecurity.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDto {

	@NotNull(message = "username shouldn't be null")
	private String username;
	@Email(message = "invalid email address")
	private String email;
	@NonNull
	@NotBlank(message = "password is not valid")
	private String password;
	private String role; // user, admin

	public UserDto(@NotNull(message = "username shouldn't be null") String username,
			@Email(message = "invalid email address") String email, String role) {
		this.username = username;
		this.email = email;
		this.role = role;
	}

}
