package com.packt.webstore.domain;

import java.io.Serializable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement(name = "category")
public class Category implements Serializable {
	private static final long serialVersionUID = 5658716793957904104L;
	private int id;

	@NotEmpty
	private String name;
	@Size(min = 8, max = 50, message = "{Size.name.validation}")
	private String description;

	public Category() {
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
