package edu.mum.cs544;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Student {
	@Id
	private long studentid;
	private String firstname;
	private String lastname;

	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "studentid")
	private Collection<Course> courselist = new ArrayList<Course>();

	public Student() {
	}

	public Student(long studentid, String firstname, String lastname) {
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void addCourse(Course course) {
		this.courselist.add(course);
	}

}
