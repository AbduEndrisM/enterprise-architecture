package edu.mum.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;

	@Column(nullable = false)
	private String authority;

	@Column(nullable = true)
	private String username;


}
