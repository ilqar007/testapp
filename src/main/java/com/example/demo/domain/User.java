package com.example.demo.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "USERS")
@Entity
public class User {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer id;
	  private String name;
	  
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Role.class)
	    private Set<Role> role;
}
