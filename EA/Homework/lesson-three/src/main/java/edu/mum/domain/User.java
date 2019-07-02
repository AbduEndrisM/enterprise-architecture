package edu.mum.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
  public class User implements Serializable  {

	@Id
	@Column(name = "USER_ID", length = 20 )
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id ;

	@Column(name = "FIRSTNAME", nullable = false)
     private String firstName;

	@Column(name = "LASTNAME", nullable = true)
     private String lastName;

	 @Column(name = "EMAIL", nullable = false)
     private String email;

	 @Column(name = "RATING",length = 11, nullable = false )
     private int rating = 0;
	 @Column(name = "IS_ADMIN", length = 1, nullable = false)
     private boolean admin = false;
     
     @Version()
	 @Column(length = 11, nullable = false)
     private int version = 0;

     @Column(nullable = true)
     private LocalDate lastLogin;


    public User(String firstName, String lastName, String email, int rating, boolean admin, int version, LocalDate lastLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rating = rating;
        this.admin = admin;
        this.version = version;
        this.lastLogin = lastLogin;
    }
}