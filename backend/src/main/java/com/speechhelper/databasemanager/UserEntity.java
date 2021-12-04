package com.speechhelper.databasemanager;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class UserEntity{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="userId")
  private Long userId;
  
  @Column(name="username")
  private String username;
  
  @Column(name="password")
  private String password;
  
  @Column(name="firstName")
  private String firstName;
  
  @Column(name="lastName")
  private String lastName;
  
  @Column(name="age")
  private int age;

  public UserEntity() {
	  
  }

  @Override
  public String toString() {
    return String.format(
        "User[userId=%d, username='%s', password='%s', firstName='%s', lastName='%s', age='%d']",
        userId, username, password, firstName, lastName, age);
  }

  public Long getUserId() {
    return userId;
  }

  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
	  this.firstName = firstName;
  }


	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

