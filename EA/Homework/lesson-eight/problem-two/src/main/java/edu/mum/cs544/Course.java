package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Course {

	@Id
	private long coursenumber;
	private String name;
	private String grade;

	public Course(long coursenumber, String name, String grade) {
		this.coursenumber = coursenumber;
		this.name = name;
		this.grade = grade;
	}

}
