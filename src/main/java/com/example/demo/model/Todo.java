package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Todo {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String description ;
	private LocalDate dueDate;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
