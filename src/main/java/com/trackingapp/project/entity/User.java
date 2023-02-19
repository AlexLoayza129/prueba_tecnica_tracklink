// Java Program to Illustrate Department.java File
// Importing required package modules
package com.trackingapp.project.entity;
 
// Importing required classes
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;
 
@Entity
@Table(name = "users")
 
// Class
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="username")
    private String username;
    

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
    @Override
	public String toString(){
		return "Usuarios [id=" + id + ",username="+ username + "]";
	}
}