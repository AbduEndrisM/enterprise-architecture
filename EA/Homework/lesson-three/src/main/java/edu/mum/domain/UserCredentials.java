package edu.mum.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity

@Table(name = "authentication")
public class UserCredentials {

	@Id
	@Column(name = "USER", length = 127, nullable = false)
  	private String username;

	@Column(name = "PASSWORD", length = 32, nullable = false)
 	private String password;

	@Transient
 	private String verifyPassword;

	@Column(length = 1)
	private Boolean enabled;


}
